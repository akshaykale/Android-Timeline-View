package com.akshaykale.swipetimeline;

import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by akshaykale on 2017/08/21.
 */

public class TimeLineConfig {

    public static HashMap<String, ArrayList<TimelineObject>> timelineObjMap = new HashMap<>();
    public static ArrayList<String> headerList = new ArrayList<>();

    public static void setData(ArrayList<TimelineObject> list, TimelineGroupType type) {

        ArrayList<String> tabsList = new ArrayList<>();
        ArrayList<TimelineObject> _list = null;
        HashMap<String, ArrayList<TimelineObject>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            TimelineObject photo = list.get(i);
            long ts = photo.getTimestamp();
            Date date = new Date(ts);
            String day = (String) DateFormat.format("dd", date);
            String month = (String) DateFormat.format("MMM", date);
            String year = (String) DateFormat.format("yyyy", date);
            String tabTitle = "";
            switch (type) {
                case DAY:
                    tabTitle = day + " " + month + ", " + year;
                    break;
                case MONTH:
                    tabTitle = month + ", " + year;
                    break;
                case YEAR:
                    tabTitle = year;
            }
            if (tabsList.contains(tabTitle)) {
                _list.add(photo);
                if (i == list.size() - 1) {
                    ArrayList<TimelineObject> obj = map.get(tabTitle);
                    if (obj != null && obj.size() > 0) {

                        obj.addAll(_list);
                        map.put(tabTitle, obj);
                    } else
                        map.put(tabTitle, _list);
                }
            } else {
                if (_list != null) {
                    map.put(tabsList.get(tabsList.size() - 1), _list);
                }
                _list = new ArrayList<>();
                _list.clear();
                tabsList.add(tabTitle);
                _list.add(photo);
                if (i == list.size() - 1) {
                    map.put(tabTitle, _list);
                }
            }
        }

        timelineObjMap = map;
        headerList = tabsList;


    }

}

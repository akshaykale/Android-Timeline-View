package com.akshaykale.swipetimeline;

import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by akshaykale on 2017/08/21.
 */

public class TimeLineConfig {

    public static HashMap<String, ArrayList<TimeLineObject>> timelineObjMap = new HashMap<>();
    public static ArrayList<String> headerList = new ArrayList<>();


    public static void setData(ArrayList<TimeLineObject> list, String sortby){

        ArrayList<String> tabsList = new ArrayList<>();
        ArrayList<TimeLineObject> _list = null;
        HashMap<String, ArrayList<TimeLineObject>> map = new HashMap<>();
        switch (sortby) {
            case "date":
                break;
            case "month":
                for (int i = 0; i < list.size(); i++) {
                    TimeLineObject photo = list.get(i);
                    long ts = photo.getTimestamp();
                    Date date = new Date(ts);
                    String month = (String) DateFormat.format("MMM", date);
                    String year = (String) DateFormat.format("yyyy", date);
                    String tabTitle = month + ", " + year;

                    if (tabsList.contains(tabTitle)) {
                        _list.add(photo);
                        if (i == list.size() - 1) {
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
                break;
            case "year":
                break;
        }

        timelineObjMap = map;
        headerList = tabsList;


    }

}

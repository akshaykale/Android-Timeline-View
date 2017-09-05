package com.akshaykale.swipetimeline;

import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by akshaykale on 2017/08/21.
 */

class TimeLineConfig {

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


    public static TimelineObjectClickListener timelineObjectClickListener = null;
    public static void addOnClickListener(TimelineObjectClickListener listener){
        timelineObjectClickListener = listener;
    }
    public static TimelineObjectClickListener getListener(){
        return timelineObjectClickListener;
    }


    /**
     * Image loading engine
     * */
    public static ImageLoadingEngine imageLoadingEngine = null;
    public static void setImageLoadEngine(ImageLoadingEngine engine){
        imageLoadingEngine = engine;
    }
    public static ImageLoadingEngine getImageLoadEngine(){
        if (imageLoadingEngine == null){
            return new PicassoEngine();
        }
        return imageLoadingEngine;
    }


    /**
    * Timeline header text size
    * */
    static int TIMELINE_HEADER_TEXT_SIZE = 16;
    public static void setTimelineHeaderSize(int size){
        TIMELINE_HEADER_TEXT_SIZE = size;
    }
    public static int getTimelineHeaderSize(){
        return TIMELINE_HEADER_TEXT_SIZE;
    }

    /**
     * Timeline header text colour
     * */
    static String TIMELINE_HEADER_TEXT_COLOUR = "#000000";
    public static void setTimelineHeaderTextColour(String textColour){
        TIMELINE_HEADER_TEXT_COLOUR = textColour;
    }
    public static String getTimelineHeaderTextColour(){
        return TIMELINE_HEADER_TEXT_COLOUR;
    }

    /**
     * Timeline header background colour
     * */
    static String TIMELINE_HEADER_BACKGROUND_COLOUR = "#FF5C88C6";
    public static void setTimelineHeaderBackgroundColour(String textColour){
        TIMELINE_HEADER_BACKGROUND_COLOUR = textColour;
    }
    public static String getTimelineHeaderBackgroundColour(){
        return TIMELINE_HEADER_BACKGROUND_COLOUR;
    }

    /**
     * Timeline indicator background colour
     * */
    static String TIMELINE_INDICATOR_BACKGROUND_COLOUR = "#00ffffff";
    public static void setTimelineIndicatorBackgroundColour(String textColour){
        TIMELINE_INDICATOR_BACKGROUND_COLOUR = textColour;
    }
    public static String getTimelineIndicatorBackgroundColour(){
        return TIMELINE_INDICATOR_BACKGROUND_COLOUR;
    }

    /**
     * Timeline indicator line colour
     * */
    static String TIMELINE_INDICATOR_LINE_COLOUR = "#FF5C88C6";
    public static void setTimelineIndicatorLineColour(String textColour){
        TIMELINE_INDICATOR_LINE_COLOUR = textColour;
    }
    public static String getTimelineIndicatorLineColour(){
        return TIMELINE_INDICATOR_LINE_COLOUR;
    }



    /**
     * Timeline card text size
     * */
    static int TIMELINE_CARD_TEXT_SIZE = 18;
    public static void setTimelineCardTextSize(int size){
        TIMELINE_CARD_TEXT_SIZE = size;
    }
    public static int getTimelineCardTextSize(){
        return TIMELINE_CARD_TEXT_SIZE;
    }

    /**
     * Timeline card text colour
     * */
    static String TIMELINE_CARD_TEXT_COLOUR = "#ffffff";
    public static void setTimelineCardTextColour(String textColour){
        TIMELINE_CARD_TEXT_COLOUR = textColour;
    }
    public static String getTimelineCardTextColour(){
        return TIMELINE_CARD_TEXT_COLOUR;
    }

    /**
     * Timeline card text background colour
     * */
    static String TIMELINE_CARD_TEXT_BACKGROUND_COLOUR = "#dc252525";
    public static void setTimelineCardTextBackgroundColour(String textColour){
        TIMELINE_CARD_TEXT_BACKGROUND_COLOUR = textColour;
    }
    public static String getTimelineCardTextBackgroundColour(){
        return TIMELINE_CARD_TEXT_BACKGROUND_COLOUR;
    }


}

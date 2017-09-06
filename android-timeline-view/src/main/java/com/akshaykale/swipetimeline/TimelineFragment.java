package com.akshaykale.swipetimeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by akshaykale on 2017/08/21.
 */

/*
*
MIT License

Copyright (c) 2017 Akshay Kale

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
* */

public class TimelineFragment extends Fragment{

    private RecyclerView recyclerView;
    private LinearLayoutManager recyclerViewLayoutManager;
    private LinearLayoutManager verticalLinearLayoutManager;
    private VerticalRecyclerViewAdapter verticalRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.swipe_timeline_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_vertical_timeline);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        recyclerViewLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        // Adding items to RecyclerView.
        //addItemsToHorizontalRecyclerViewArrayList();

        verticalRecyclerViewAdapter = new VerticalRecyclerViewAdapter(getContext(), null);
        verticalLinearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLinearLayoutManager);
        recyclerView.setAdapter(verticalRecyclerViewAdapter);
    }

    public void addOnClickListener(TimelineObjectClickListener listener){
        TimeLineConfig.addOnClickListener(listener);
    }

    public void setImageLoadEngine(ImageLoadingEngine engine){
        TimeLineConfig.setImageLoadEngine(engine);
    }

    public void setData(ArrayList<TimelineObject> dataList, TimelineGroupType type ){
        TimeLineConfig.setData(dataList, type);
    }

    public void addSingleObject(TimelineObject data, TimelineGroupType type){
        TimeLineConfig.addObject(data,type);
        if (verticalRecyclerViewAdapter!=null)
            verticalRecyclerViewAdapter.notifyDataSetChanged();
    }

    public void clearData(){
        TimeLineConfig.clearData();
    }

    /**
     * Timeline header text size
     * */
    public void setTimelineHeaderSize(int size){
        TimeLineConfig.setTimelineHeaderSize(size);
    }
    public int getTimelineHeaderSize(){
        return TimeLineConfig.getTimelineHeaderSize();
    }

    /**
     * Timeline header text colour
     * */
    public void setTimelineHeaderTextColour(String textColour){
        TimeLineConfig.setTimelineHeaderTextColour(textColour);
    }
    public String getTimelineHeaderTextColour(){
        return TimeLineConfig.getTimelineHeaderTextColour();
    }

    /**
     * Timeline header background colour
     * */
    public void setTimelineHeaderBackgroundColour(String colour){
        TimeLineConfig.setTimelineHeaderBackgroundColour(colour);
    }
    public String getTimelineHeaderBackgroundColour(){
        return TimeLineConfig.getTimelineHeaderBackgroundColour();
    }

    /**
     * Timeline indicator background colour
     * */
    public void setTimelineIndicatorBackgroundColour(String colour){
        TimeLineConfig.setTimelineIndicatorBackgroundColour(colour);
    }
    public String getTimelineIndicatorBackgroundColour(){
        return TimeLineConfig.getTimelineIndicatorBackgroundColour();
    }

    /**
     * Timeline indicator line colour
     * */
    public void setTimelineIndicatorLineColour(String colour){
        TimeLineConfig.setTimelineIndicatorLineColour(colour);
    }
    public String getTimelineIndicatorLineColour(){
        return TimeLineConfig.getTimelineIndicatorLineColour();
    }

    /**
     * Timeline card text size
     * */
    public void setTimelineCardTextSize(int size){
        TimeLineConfig.setTimelineCardTextSize(size);
    }
    public int getTimelineCardTextSize(){
        return TimeLineConfig.getTimelineCardTextSize();
    }

    /**
     * Timeline card text colour
     * */
    public void setTimelineCardTextColour(String colour){
        TimeLineConfig.setTimelineCardTextColour(colour);
    }
    public String getTimelineCardTextColour(){
        return TimeLineConfig.getTimelineCardTextColour();
    }

    /**
     * Timeline card text background colour
     * */
    public void setTimelineCardTextBackgroundColour(String colour){
        TimeLineConfig.setTimelineCardTextBackgroundColour(colour);
    }
    public String getTimelineCardTextBackgroundColour(){
        return TimeLineConfig.getTimelineCardTextBackgroundColour();
    }

}

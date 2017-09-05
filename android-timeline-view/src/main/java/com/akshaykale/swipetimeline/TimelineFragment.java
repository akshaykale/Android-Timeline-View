package com.akshaykale.swipetimeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by akshaykale on 2017/08/21.
 */

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
}

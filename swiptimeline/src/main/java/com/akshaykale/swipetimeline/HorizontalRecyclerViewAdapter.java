package com.akshaykale.swipetimeline;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by akshaykale on 2017/08/22.
 */

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalRecyclerViewHolder> {


    ArrayList<TimelineObject> list = new ArrayList<>();

    public HorizontalRecyclerViewAdapter(ArrayList<TimelineObject> list) {
        this.list = list;
    }

    @Override
    public HorizontalRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_timeline_layout, parent, false);

        return new HorizontalRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HorizontalRecyclerViewHolder holder, final int position) {
        holder.textView.setText(""+list.get(position).getTitle());

        if (TimeLineConfig.getListener() != null) {
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimeLineConfig.getListener().onTimelineObjectClicked(list.get(position));
                }
            });

            holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    TimeLineConfig.getListener().onTimelineObjectLongClicked(list.get(position));
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }


    public class HorizontalRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public CardView cardView;

        //public MaterialRatingBar ratingBar;

        public HorizontalRecyclerViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.tv_timeline_horizontal_card_name);
            cardView = (CardView) view.findViewById(R.id.timeline_obj_cardview);

            textView.setTextSize(TimeLineConfig.getTimelineCardTextSize());
            textView.setTextColor(Color.parseColor(TimeLineConfig.getTimelineCardTextColour()));
            textView.setBackgroundColor(Color.parseColor(TimeLineConfig.getTimelineCardTextBackgroundColour()));
        }
    }
}
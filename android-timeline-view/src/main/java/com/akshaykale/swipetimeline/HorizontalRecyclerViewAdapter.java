package com.akshaykale.swipetimeline;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by akshaykale on 2017/08/22.
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

        TimeLineConfig.getImageLoadEngine().onLoadImage(holder.imageView, list.get(position).getImageUrl());

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

    @Override
    public void onViewRecycled(HorizontalRecyclerViewHolder holder) {
        holder.imageView.setImageDrawable(null);
        super.onViewRecycled(holder);
    }

    public class HorizontalRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;
        public CardView cardView;

        //public MaterialRatingBar ratingBar;

        public HorizontalRecyclerViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.tv_timeline_horizontal_card_name);
            cardView = (CardView) view.findViewById(R.id.timeline_obj_cardview);
            imageView = (ImageView) view.findViewById(R.id.iv_horizontal_card_image);

            textView.setTextSize(TimeLineConfig.getTimelineCardTextSize());
            textView.setTextColor(Color.parseColor(TimeLineConfig.getTimelineCardTextColour()));
            textView.setBackgroundColor(Color.parseColor(TimeLineConfig.getTimelineCardTextBackgroundColour()));
        }
    }
}
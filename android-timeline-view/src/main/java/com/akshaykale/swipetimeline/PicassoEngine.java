package com.akshaykale.swipetimeline;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by akshay.kale on 22/08/2017.
 */

public class PicassoEngine implements ImageLoadingEngine {
    @Override
    public void onLoadImage(ImageView imageView, String uri) {

        Picasso.with(imageView.getContext())
                .load(uri)
                .resize(250, 250)
                .placeholder(R.drawable.timeline_card_placeholder)
                .centerCrop()
                .into(imageView);

    }
}

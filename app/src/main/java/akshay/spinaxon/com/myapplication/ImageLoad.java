package akshay.spinaxon.com.myapplication;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.akshaykale.swipetimeline.ImageLoadingEngine;
import com.squareup.picasso.Picasso;

/**
 * Created by akshay.kale on 22/08/2017.
 */

public class ImageLoad implements ImageLoadingEngine {

    Context context;

    public ImageLoad(Context context) {
        this.context = context;
    }

    @Override
    public void onLoadImage(ImageView imageView, String uri) {

        Picasso.Builder builder = new Picasso.Builder(context);

        builder.listener(new Picasso.Listener()
        {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
            {
                exception.printStackTrace();
            }
        });
        builder.build().load(uri).into(imageView);
    }
}

package com.smartsoftasia.module.HorrizontalImageListView.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by gregoire on 9/18/14.
 */
public class PicassoImageView extends ImageView {

    public PicassoImageView(Context context) {
        super(context);
    }

    public PicassoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PicassoImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setImageUrl(String url){
        if(url == null) return;
        //this.url = url;
        Picasso.with(getContext()).load(url).into(this);
    }

    @Override
    public void setImageResource(int resource){
        super.setImageResource(resource);
    }

}

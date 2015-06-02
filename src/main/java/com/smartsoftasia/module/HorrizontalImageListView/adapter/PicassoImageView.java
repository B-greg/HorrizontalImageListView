package com.smartsoftasia.module.HorrizontalImageListView.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.smartsoftasia.module.HorrizontalImageListView.helper.Validator;
import com.squareup.picasso.Picasso;

import java.io.File;


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


    public void downloadImageFromURL(String url) {
        if (url!= null && Validator.isValid(url)) {
            Picasso.with(getContext())
                    .load(url)
                    .into(this);
        }
    }

    public void downloadImageFromFile(File file) {
        if(file == null)return;
        Picasso.with(getContext())
                .load(file)
                .into(this);
    }

    @Override
    public void setImageResource(int resource){
        super.setImageResource(resource);
    }



}

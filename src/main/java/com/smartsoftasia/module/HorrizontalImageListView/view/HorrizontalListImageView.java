package com.smartsoftasia.module.HorrizontalImageListView.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartsoftasia.module.HorrizontalImageListView.R;
import com.smartsoftasia.module.HorrizontalImageListView.adapter.ImageAdapter;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gregoire on 9/18/14.
 */
public class HorrizontalListImageView extends LinearLayout {

    TwoWayView mTwoWayView;
    ImageAdapter imageAdapter;
    List<Integer> mPictureResources = new ArrayList<>();

    public HorrizontalListImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.horizontal_listview, this);
        setupViewItems();

    }

    private void setupViewItems() {
        mTwoWayView = (TwoWayView) findViewById(R.id.twoWayView);
        imageAdapter = new ImageAdapter(mPictureResources, getContext());
        mTwoWayView.setAdapter(imageAdapter);
        mTwoWayView.setOrientation(TwoWayView.Orientation.HORIZONTAL);
    }

    public  void setPicturesDrawable(Collection<Integer> items){
        mPictureResources.addAll(items);
        imageAdapter.notifyDataSetChanged();
    }


}

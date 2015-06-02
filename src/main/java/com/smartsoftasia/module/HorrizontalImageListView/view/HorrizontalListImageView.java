package com.smartsoftasia.module.HorrizontalImageListView.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.smartsoftasia.module.HorrizontalImageListView.Model.HorizontalListViewModel;
import com.smartsoftasia.module.HorrizontalImageListView.R;
import com.smartsoftasia.module.HorrizontalImageListView.adapter.ImageAdapter;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by gregoire on 9/18/14.
 */
public class HorrizontalListImageView extends LinearLayout implements TwoWayView.OnScrollListener {


    TwoWayView mTwoWayView;
    ImageAdapter imageAdapter;
    ImageView mArrowLeft;
    ImageView mArrowRight;
    List<HorizontalListViewModel> mPictureResources = new ArrayList<>();
    Boolean isArrowVisible = false;

    public HorrizontalListImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.horizontal_listview, this);
        setupViewItems();

    }

    private void setupViewItems() {
        mTwoWayView = (TwoWayView) findViewById(R.id.twoWayView);
        mArrowLeft = (ImageView) findViewById(R.id.twoWayView_arrow_left);
        mArrowRight = (ImageView) findViewById(R.id.twoWayView_arrow_right);
        mTwoWayView.setOrientation(TwoWayView.Orientation.HORIZONTAL);
        imageAdapter = new ImageAdapter(mPictureResources, getContext());
        mTwoWayView.setAdapter(imageAdapter);
        mTwoWayView.setOnScrollListener(this);
    }

//    public  void setPicturesDrawable(Collection<Integer> items){
//        if(items==null)items = new ArrayList<>();
//        mPictureResources.addAll(items);
//        imageAdapter.notifyDataSetChanged();
//    }

    public void setItems(Collection<HorizontalListViewModel> items){
       if(items==null)items = new ArrayList<>();
        mPictureResources.addAll(items);
        imageAdapter.notifyDataSetChanged();
    }

    public void setcarousel(){
        imageAdapter.setCarousel(true);
    }

    public void setArrowVisible(Boolean isVisible){
        isArrowVisible = isVisible;
        if(isVisible){
            if(mArrowLeft!=null)mArrowLeft.setVisibility(VISIBLE);
            if(mArrowRight!=null)mArrowRight.setVisibility(VISIBLE);
        }else{
            if(mArrowLeft!=null)mArrowLeft.setVisibility(VISIBLE);
            if(mArrowRight!=null)mArrowRight.setVisibility(VISIBLE);
        }
    }


    @Override
    public void onScrollStateChanged(TwoWayView twoWayView, int i) {

    }

    @Override
    public void onScroll(TwoWayView twoWayView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if(!isArrowVisible)return;
        int l = visibleItemCount + firstVisibleItem;
        if (l >= totalItemCount) {
            if(mArrowRight!=null)mArrowRight.setVisibility(View.GONE);
        }else{
            if(mArrowRight!=null)mArrowRight.setVisibility(View.VISIBLE);
        }
        if (firstVisibleItem <= 0){
            if(mArrowLeft!=null)mArrowLeft.setVisibility(View.GONE);
        }else{
            if(mArrowLeft!=null)mArrowLeft.setVisibility(View.VISIBLE);
        }
    }


}

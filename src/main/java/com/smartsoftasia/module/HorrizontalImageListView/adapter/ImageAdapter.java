package com.smartsoftasia.module.HorrizontalImageListView.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.smartsoftasia.module.HorrizontalImageListView.Model.HorizontalListViewModel;
import com.smartsoftasia.module.HorrizontalImageListView.R;

import java.io.File;
import java.util.List;

/**
 * Created by gregoire on 9/18/14.
 */
public class ImageAdapter extends BaseAdapter {

    List<HorizontalListViewModel> imageResources;
    Context mContext;
    LayoutInflater mInflater;
    Boolean isCarousel = false;

    public ImageAdapter (List<HorizontalListViewModel> items, Context mContext) {
        this.imageResources = items;
        this.mContext = mContext;
        this.mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageResources.size();
    }

    @Override
    public Object getItem(int i) {
        return imageResources.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mInflater.inflate(R.layout.item_image, viewGroup, false);
            holder = new ViewHolder();
            holder.imageView = (PicassoImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if(isCarousel) carousel(holder);

        if(imageResources.get(i).getUri()!=null)
            holder.imageView.downloadImageFromFile(new File(imageResources.get(i).getUri()));
        else if(imageResources.get(i).getUrl()!=null)
            holder.imageView.downloadImageFromURL(imageResources.get(i).getUrl());

        return view;
    }

    public static class ViewHolder {
        public PicassoImageView imageView;

    }

    public void setCarousel(Boolean enable){
        this.isCarousel = enable;
    }

    private void carousel(ViewHolder holder){
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        ViewGroup.LayoutParams params = holder.imageView.getLayoutParams();
        params.width = width;
        holder.imageView.setLayoutParams(params);
    }
}

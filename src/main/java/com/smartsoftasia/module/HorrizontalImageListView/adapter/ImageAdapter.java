package com.smartsoftasia.module.HorrizontalImageListView.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartsoftasia.module.HorrizontalImageListView.R;

import java.util.List;

/**
 * Created by gregoire on 9/18/14.
 */
public class ImageAdapter extends BaseAdapter {

    List<Integer> imageResources;
    Context mContext;
    LayoutInflater mInflater;

    public ImageAdapter (List<Integer> items, Context mContext) {
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

        holder.imageView.setImageResource(imageResources.get(i));
        return view;
    }

    public static class ViewHolder {
        public PicassoImageView imageView;

    }
}

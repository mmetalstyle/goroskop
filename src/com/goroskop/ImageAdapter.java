package com.goroskop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    
    private int mGalleryItemBackground;
    private Context mContext;

    private final Integer[] mImage = {
        R.drawable.blizn, R.drawable.deva,
        R.drawable.koza, R.drawable.lev,
        R.drawable.oven, R.drawable.rak,
        R.drawable.ribi, R.drawable.skorp,
        R.drawable.strel, R.drawable.telex,
        R.drawable.vesi, R.drawable.voda      
    };
    
    public ImageAdapter(Context c) {
        mContext = c;
    } 

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = new ImageView(mContext);

        view.setImageResource(mImage[position]);
        view.setPadding(20,20,20,20);
        view.setLayoutParams(new Gallery.LayoutParams(80, 80));
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        view.setBackgroundResource(mGalleryItemBackground);
        return view;
    }
    
    public int getCount() {
        return mImage.length;
    }

    public Object getItem(int position) {
        return mImage[position];
    }

    public long getItemId(int position) {
        return mImage[position];
    }
}

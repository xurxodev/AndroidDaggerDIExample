package com.xurxo.androiddaggerdiexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryItemAdapter extends BaseAdapter {
    private Context context;
    private List<Country> items;

    public CountryItemAdapter(Context context,List<Country> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            //retrieve item view
            row = LayoutInflater.from(context)
                    .inflate(R.layout.item_country, null, false);

            holder = new ViewHolder();
            holder.nameTextView = (TextView) row.findViewById(R.id.nameTextView);
            holder.capitalTextView = (TextView) row.findViewById(R.id.capitalNameTextView);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        //retrieve item by position
        final Country item = items.get(i);

        holder.nameTextView.setText(item.getName());
        holder.capitalTextView.setText(item.getCapital());

        return row;
    }
    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    static class ViewHolder {
        TextView nameTextView;
        TextView capitalTextView;
    }
}


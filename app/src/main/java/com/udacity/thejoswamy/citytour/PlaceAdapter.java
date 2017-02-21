package com.udacity.thejoswamy.citytour;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Array adapter for a List view which uses {@Link Place} instances
 */
public class PlaceAdapter extends ArrayAdapter<Place> {

    private int mBackgroundResourceId;

    public PlaceAdapter(Context context, ArrayList<Place> places, int backgroundResId) {
        super(context, 0, places);
        mBackgroundResourceId = backgroundResId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item_layout, parent, false);
        }
        LinearLayout container = (LinearLayout) convertView.findViewById(R.id.text_container);
        container.setBackgroundResource(mBackgroundResourceId);

        Place currentPlace = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
        if (currentPlace.isImageAvailable()) {
            imageView.setImageResource(currentPlace.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text);
        nameTextView.setText(currentPlace.getName());

        TextView addressTextView = (TextView) convertView.findViewById(R.id.address_text);
        addressTextView.setText(currentPlace.getAddress());

        TextView timingsTextView = (TextView) convertView.findViewById(R.id.timings_text);
        timingsTextView.setText(currentPlace.getTimings());

        return convertView;
    }
}

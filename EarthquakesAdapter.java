package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by asus on 6/15/2017.
 */

public class EarthquakesAdapter extends ArrayAdapter<EarthquakeParam> {


    public EarthquakesAdapter(Activity context, ArrayList<EarthquakeParam> earthquakes) {




        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);

    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }


        EarthquakeParam currentWord = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude_text);
        magTextView.setText(currentWord.getMagnitude());

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text);
        locationTextView.setText(currentWord.getLocation());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text);
        dateTextView.setText(currentWord.getDate());






        return listItemView;



    }
}




package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;



import java.text.DecimalFormat;


import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }








        EarthquakeParam currentWord = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude_text);
        DecimalFormat formatter = new DecimalFormat("0.0");
        magTextView.setText(formatter.format(currentWord.getMagnitude()));

        long TimeInMilliSeconds = currentWord.getMillisconds();
        Date dateObject = new Date(TimeInMilliSeconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text);
        dateTextView.setText(dateToDisplay);

        Date timeObject = new Date(TimeInMilliSeconds);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormatter.format(timeObject);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text);
        timeTextView.setText(timeToDisplay);

        String totalLocation = currentWord.getLocation();
        String offset;
        String primaryLocation;


        if (totalLocation.contains("km ")) {
            int k = totalLocation.indexOf(" of");
            offset = totalLocation.substring(0, k + 3);
            primaryLocation = totalLocation.substring(k + 4);

        } else {
            primaryLocation = totalLocation;
            offset = "Near the";
        }

        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset_text);
        TextView primaryTextView = (TextView) listItemView.findViewById(R.id.primary_Location);

        offsetTextView.setText(offset);
        primaryTextView.setText(primaryLocation);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentWord.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);







        return listItemView;


    }
}




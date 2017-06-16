package com.example.android.quakereport;

/**
 * Created by asus on 6/15/2017.
 */

public class EarthquakeParam {

    private String mMagnitude;
    private String mLocation;
    private String mDate;

    public EarthquakeParam (String  magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public String getMagnitude (){
        return mMagnitude;
    }
    public String getLocation() {
        return mLocation;
    }
    public String getDate()  {
        return mDate;
    }

}

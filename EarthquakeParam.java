package com.example.android.quakereport;

/**
 * Created by asus on 6/15/2017.
 */

public class EarthquakeParam {

    private double mMagnitude;
    private String mLocation;
    private Long mMilliseconds;
    private String mUrl;

    public EarthquakeParam (double  magnitude, String location, Long milliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mMilliseconds = milliseconds;
        mUrl = url;
    }

    public double getMagnitude (){
        return mMagnitude;
    }
    public String getLocation() {
        return mLocation;
    }
    public Long getMillisconds ()  {
        return mMilliseconds;
    }
    public String getUrl() {
        return mUrl;
    }

}

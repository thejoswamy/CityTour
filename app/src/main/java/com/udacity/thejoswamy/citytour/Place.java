package com.udacity.thejoswamy.citytour;

/**
 * {@Link Place} represents a place in the city that the user wants to visit.
 * It contains place name, open timings, address, geo location and an image.
 */
public class Place {

    private static final int NO_IMG_RESOURCE = -1;

    /**
     * Name of the place
     */
    private String mName;
    /**
     * visiting hours of the place
     */
    private String mTimings;
    /**
     * Address of the place
     */
    private String mAddress;
    /**
     * Image resource of the place
     */
    private int mImageResId;

    public Place(String name, String timings, String address) {
        mName = name;
        mTimings = timings;
        mAddress = address;
        mImageResId = NO_IMG_RESOURCE;
    }

    public Place(String name, String timings, String address, int imgResId) {
        mName = name;
        mTimings = timings;
        mAddress = address;
        mImageResId = imgResId;
    }

    public String getName() {
        return mName;
    }

    public String getTimings() {
        return mTimings;
    }

    public String getAddress() {
        return mAddress;
    }

    public int getImageResourceId() {
        return mImageResId;
    }

    /**
     * Returns whether image resource is present or not
     *
     * @return
     */
    public boolean isImageAvailable() {
        return mImageResId != NO_IMG_RESOURCE;
    }

    @Override
    public String toString() {
        return "Place{" +
                "mName='" + mName + '\'' +
                ", mTimings='" + mTimings + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mImageResId=" + mImageResId +
                '}';
    }
}
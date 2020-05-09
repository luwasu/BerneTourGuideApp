package codes.gorillu.bernetourguideapp;

import android.graphics.drawable.Drawable;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class Attraction {

    private String mAttractionName;
    private String mAttractionAddress;
    private String mAttractionOpeningHours;
    private Drawable mImageID;

    public Attraction(String attractionName, String attractionAddress, String attractionOpeningHours, Drawable imageID) {
        this.mAttractionName = attractionName;
        this.mAttractionAddress = attractionAddress;
        this.mAttractionOpeningHours = attractionOpeningHours;
        this.mImageID = imageID;


    }

//    public Attraction(FragmentActivity activity, ArrayList<Attraction> attractions) {
//    }


    public String getAttractionName() {
        return mAttractionName;
    }

    public String getAttractionAddress() {
        return mAttractionAddress;
    }

    public String getAttractionOpeningHours() {
        return mAttractionOpeningHours;
    }

    public Drawable getImageID() {
        return mImageID;
    }
}

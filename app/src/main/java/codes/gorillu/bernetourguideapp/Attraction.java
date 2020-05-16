package codes.gorillu.bernetourguideapp;

import android.graphics.drawable.Drawable;

/**
 * {@link Attraction} represents a Attraction.
 * It contains all the information that is pulled together via an array in from the resources.
 */

public class Attraction {

    /**
     * Name of attraction
     */
    private String mAttractionName;

    /**
     * Address of attraction
     */
    private String mAttractionAddress;

    /**
     * Opening hours of attraction
     */
    private String mAttractionOpeningHours;

    /**
     * Image of attraction
     */
    private Drawable mImageID;

    /**
     * Create a new Attraction object.
     *
     * @param attractionName is the name of the attraction
     * @param attractionAddress   is the address of the attraction     *
     * @param attractionOpeningHours is the opening hours of the attraction
     * @param imageID is the image of the attraction
     */
    public Attraction(String attractionName, String attractionAddress, String attractionOpeningHours, Drawable imageID) {
        this.mAttractionName = attractionName;
        this.mAttractionAddress = attractionAddress;
        this.mAttractionOpeningHours = attractionOpeningHours;
        this.mImageID = imageID;


    }


    /**
     * Get attraction name.
     */
    public String getAttractionName() {
        return mAttractionName;
    }

    /**
     * Get attraction address.
     */
    public String getAttractionAddress() {
        return mAttractionAddress;
    }

    /**
     * Get attraction opening hours.
     */
    public String getAttractionOpeningHours() {
        return mAttractionOpeningHours;
    }

    /**
     * Get attraction image.
     */
    public Drawable getImageID() {
        return mImageID;
    }
}

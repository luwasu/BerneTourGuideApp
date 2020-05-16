package codes.gorillu.bernetourguideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

/**
 * {@link AttractionAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Attraction} objects.
 */
public class AttractionAdapter extends ArrayAdapter<Attraction> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link AttractionAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param localAttraction is the list of {@link Attraction}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public AttractionAdapter(Activity context, ArrayList<Attraction> localAttraction, int colorResourceId) {
        super(context, 0, localAttraction);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID attraction_name.
        TextView localAttractionNameTextView = listItemView.findViewById(R.id.attraction_name);
        // Get the attraction name from the currentAttraction object and set this text on
        // the attraction_name TextView.
        localAttractionNameTextView.setText(currentAttraction.getAttractionName());


        // Find the TextView in the list_item.xml layout with the ID attraction_address.
        TextView localAttractionAddressTextView = listItemView.findViewById(R.id.attraction_address);
        // Get the attraction address from the currentAttraction object and set this text on
        // the attraction_address TextView.
        localAttractionAddressTextView.setText(currentAttraction.getAttractionAddress());

        // Find the TextView in the list_item.xml layout with the ID attraction_opening_hours.
        TextView localAttractionOpeningHoursTextView = listItemView.findViewById(R.id.attraction_opening_hours);
        // Get the attraction opening hours from the currentAttraction object and set this text on
        // the attraction_opening_hour TextView.
        localAttractionOpeningHoursTextView.setText(currentAttraction.getAttractionOpeningHours());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = listItemView.findViewById(R.id.attraction_image);
        // Get the attraction image from the currentAttraction object and set this image on
        // the attraction_image) ImageView.
        imageView.setImageDrawable(currentAttraction.getImageID());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 3 TextViews and 1 ImageView) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}

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

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    private int mColorResourceId;


    public AttractionAdapter(Activity context, ArrayList<Attraction> localAttraction, int colorResourceId) {
        super(context, 0, localAttraction);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        TextView localAttractionNameTextView = listItemView.findViewById(R.id.tv_attraction_name);
        localAttractionNameTextView.setText(currentAttraction.getAttractionName());

        TextView localAttractionAddressTextView = listItemView.findViewById(R.id.tv_attraction_address);
        localAttractionAddressTextView.setText(currentAttraction.getAttractionAddress());

        TextView localAttractionOpeningHoursTextView = listItemView.findViewById(R.id.tv_attraction_opening_hours);
        localAttractionOpeningHoursTextView.setText(currentAttraction.getAttractionOpeningHours());


        ImageView imageView = listItemView.findViewById(R.id.iv_attraction_image);
        imageView.setImageDrawable(currentAttraction.getImageID());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

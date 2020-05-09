package codes.gorillu.bernetourguideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {


    public AttractionAdapter(Activity context, ArrayList<Attraction> localAttraction) {
        super(context, 0, localAttraction);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        TextView localAttractionNameTextView = (TextView) listItemView.findViewById(R.id.tv_attraction_name);
        localAttractionNameTextView.setText(currentAttraction.getAttractionName());

        TextView localAttractionAddressTextView = (TextView) listItemView.findViewById(R.id.tv_attraction_address);
        localAttractionAddressTextView.setText(currentAttraction.getAttractionAddress());

        TextView localAttractionOpeningHoursTextView = (TextView) listItemView.findViewById(R.id.tv_attraction_opening_hours);
        localAttractionOpeningHoursTextView.setText(currentAttraction.getAttractionOpeningHours());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.iv_attraction_image);
        imageView.setImageDrawable(currentAttraction.getImageID());

        return listItemView;
    }
}

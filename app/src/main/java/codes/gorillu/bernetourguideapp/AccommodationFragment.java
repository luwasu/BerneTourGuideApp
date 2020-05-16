package codes.gorillu.bernetourguideapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccommodationFragment extends Fragment {

    public AccommodationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_attraction, container, false);

        // Create a list of accommodations
        final ArrayList<Attraction> accommodation = new ArrayList<>();

        // pull the Strings and Image from res/values/arrays folder
        final String[] accommodationNames = getResources().getStringArray(R.array.list_accommodation_names);
        final String[] accommodationAddresses = getResources().getStringArray(R.array.list_accommodation_addresses);
        final String[] accommodationOpeningHours = getResources().getStringArray(R.array.list_accommodation_opening_hours);
        final TypedArray accommodationImages = getResources().obtainTypedArray(R.array.list_accommodation_images);


        // Create a list of items pulled from the res/values/arrays folder
        for (int id = 0; id != accommodationNames.length; ++id) {
            Attraction newAttraction = new Attraction(accommodationNames[id], accommodationAddresses[id],
                    accommodationOpeningHours[id], accommodationImages.getDrawable(id));
            accommodation.add(newAttraction);
        }

        // Create an {@link AttractionAdapter}, whose data source is a list of {@link Attraction}s. The
        // adapter knows how to create list items for each item in the list.
        // Set the color for the card view
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), accommodation, R.color.category_accommodation);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list_local_attraction, which is declared in the
        // fragment_attraction.xml layout file.
        ListView listView = rootView.findViewById(R.id.list_local_attraction);

        // Make the {@link ListView} use the {@link AttractionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adapter);

        // Now return all this magic to create a really cool layout
        return rootView;
    }
}

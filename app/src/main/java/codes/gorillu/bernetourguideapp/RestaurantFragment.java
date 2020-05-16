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
public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_attraction, container, false);
        // Create a list of Restaurants
        final ArrayList<Attraction> restaurant = new ArrayList<>();

        // pull the Strings and Image from res/values/arrays folder
        final String[] restaurantNames = getResources().getStringArray(R.array.list_restaurant_names);
        final String[] restaurantAddresses = getResources().getStringArray(R.array.list_restaurant_addresses);
        final String[] restaurantOpeningHours = getResources().getStringArray(R.array.list_restaurant_opening_hours);
        final TypedArray restaurantImages = getResources().obtainTypedArray(R.array.list_restaurant_images);

        // Create a list of items pulled from the res/values/arrays folder
        for (int id = 0; id != restaurantNames.length; ++id) {
            Attraction newAttraction = new Attraction(restaurantNames[id], restaurantAddresses[id],
                    restaurantOpeningHours[id], restaurantImages.getDrawable(id));
            restaurant.add(newAttraction);
        }

        // Create an {@link AttractionAdapter}, whose data source is a list of {@link Attraction}s. The
        // adapter knows how to create list items for each item in the list.
        // Set the color for the card view
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), restaurant, R.color.category_restaurant);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list_local_attraction, which is declared in the
        // fragment_attraction.xml layout file.
        ListView listView = rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        // Now return all this magic to create a really cool layout
        return rootView;
    }
}

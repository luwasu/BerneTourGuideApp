package codes.gorillu.bernetourguideapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_attraction, container, false);

        final ArrayList<Attraction> restaurant = new ArrayList<>();

        final String[] restaurantNames = getResources().getStringArray(R.array.list_restaurant_names);
        final String[] restaurantAddresses = getResources().getStringArray(R.array.list_restaurant_addresses);
        final String[] restaurantOpeningHours = getResources().getStringArray(R.array.list_restaurant_opening_hours);
        final TypedArray restaurantImages = getResources().obtainTypedArray(R.array.list_restaurant_images);

        for (int id = 0; id != restaurantNames.length; ++id) {
            Attraction newAttraction = new Attraction(restaurantNames[id], restaurantAddresses[id],
                    restaurantOpeningHours[id], restaurantImages.getDrawable(id));
            restaurant.add(newAttraction);
        }

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), restaurant);

        ListView listView = rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        return rootView;
    }
}

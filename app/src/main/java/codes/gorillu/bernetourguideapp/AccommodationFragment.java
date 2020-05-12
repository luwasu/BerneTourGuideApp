package codes.gorillu.bernetourguideapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AccommodationFragment extends Fragment {

    public AccommodationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_attraction, container, false);

        final ArrayList<Attraction> accommodation = new ArrayList<>();

        final String[] accommodationNames = getResources().getStringArray(R.array.list_accommodation_names);
        final String[] accommodationAddresses = getResources().getStringArray(R.array.list_accomodation_addresses);
        final String[] accommodationOpeningHours = getResources().getStringArray(R.array.list_accomodation_opening_hours);
        final TypedArray accommodationImages = getResources().obtainTypedArray(R.array.list_accomodation_images);

        for (int id = 0; id != accommodationNames.length; ++id) {
            Attraction newAttraction = new Attraction(accommodationNames[id], accommodationAddresses[id],
                    accommodationOpeningHours[id], accommodationImages.getDrawable(id));
            accommodation.add(newAttraction);
        }

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), accommodation, R.color.category_family);

        ListView listView = rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        return rootView;
    }
}

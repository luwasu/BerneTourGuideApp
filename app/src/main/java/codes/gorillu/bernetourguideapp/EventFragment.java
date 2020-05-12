package codes.gorillu.bernetourguideapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class EventFragment extends Fragment {

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_attraction, container, false);

        final ArrayList<Attraction> event = new ArrayList<>();

        final String[] eventNames = getResources().getStringArray(R.array.list_event_names);
        final String[] eventAddresses = getResources().getStringArray(R.array.list_event_addresses);
        final String[] eventOpeningHours = getResources().getStringArray(R.array.list_event_opening_hours);
        final TypedArray eventImages = getResources().obtainTypedArray(R.array.list_event_images);

        for (int id = 0; id != eventNames.length; ++id) {
            Attraction newAttraction = new Attraction(eventNames[id], eventAddresses[id],
                    eventOpeningHours[id], eventImages.getDrawable(id));
            event.add(newAttraction);
        }

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), event, R.color.category_event);

        ListView listView = rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        return rootView;
    }
}

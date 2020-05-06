package codes.gorillu.bernetourguideapp;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private static final int POSITION_ATTRACTION = 0;
    private static final int POSITION_EVENT = 1;
    private static final int POSITION_ACCOMMODATION = 2;
    private static final int POSITION_RESTAURANT = 3;
    private static final int NUMBER_OF_POSITIONS = POSITION_RESTAURANT + 1;


    /**
     * Context of the app
     */

    private Context mContext;


    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */

    @Override
    public Fragment getItem(int position) {
        if (POSITION_ATTRACTION == position) {
            return new AttractionFragment();
        } else if (POSITION_EVENT == position) {
            return new EventFragment();
        } else if (POSITION_ACCOMMODATION == position) {
            return new AccommodationFragment();
        } else {
            return new RestaurantFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return NUMBER_OF_POSITIONS;
    }

    /**
     * Return attraction fragment titles.
     */

    @Override
    public CharSequence getPageTitle(int position) {
        if (POSITION_ATTRACTION == position) {
            return mContext.getString(R.string.attraction);
        } else if (POSITION_EVENT == position) {
            return mContext.getString(R.string.event);
        } else if (POSITION_ACCOMMODATION == 2) {
            return mContext.getString(R.string.accommodation);
        } else {
            return mContext.getString(R.string.restaurant);
        }
    }
}



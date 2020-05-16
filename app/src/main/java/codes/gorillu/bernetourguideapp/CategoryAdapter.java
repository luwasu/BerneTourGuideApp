package codes.gorillu.bernetourguideapp;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Number of fragments pages to be displayed
     */
    private static int NUM_ITEMS = 4;


    /**
     * Context of the app
     */
    private Context mContext;


    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fragmentManager is the fragment manager that will keep each fragment's state in the adapter
     * @param context         is the context of the app
     */

    public CategoryAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }


    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttractionFragment();
        } else if (position == 1) {
            return new EventFragment();
        } else if (position == 2) {
            return new RestaurantFragment();
        } else {
            return new AccommodationFragment();
        }

    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }


    /**
     * Return attraction fragment titles.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.attraction);
        } else if (position == 1) {
            return mContext.getString(R.string.event);
        } else if (position == 2) {
            return mContext.getString(R.string.restaurant);
        } else {
            return mContext.getString(R.string.accommodation);
        }
    }
}




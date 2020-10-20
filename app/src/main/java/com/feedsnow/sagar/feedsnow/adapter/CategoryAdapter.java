package com.feedsnow.sagar.feedsnow.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.feedsnow.sagar.feedsnow.R;
import com.feedsnow.sagar.feedsnow.fragment.BusinessFragment;
import com.feedsnow.sagar.feedsnow.fragment.EntertainmentFragment;
import com.feedsnow.sagar.feedsnow.fragment.HealthFragment;
import com.feedsnow.sagar.feedsnow.fragment.ScienceFragment;
import com.feedsnow.sagar.feedsnow.fragment.SportsFragment;
import com.feedsnow.sagar.feedsnow.fragment.TechnologyFragment;
import com.feedsnow.sagar.feedsnow.fragment.Top_HeadlinesFragment;
import com.feedsnow.sagar.feedsnow.fragment.WorldFragment;



public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Top_HeadlinesFragment();
                break;
            case 1:
                fragment = new WorldFragment();
                break;
            case 2:
                fragment = new TechnologyFragment();
                break;
            case 3:
                fragment = new BusinessFragment();
                break;
            case 4:
                fragment = new ScienceFragment();
                break;
            case 5:
                fragment = new SportsFragment();
                break;
            case 6:
                fragment = new EntertainmentFragment();
                break;
            case 7:
                fragment = new HealthFragment();
                break;
            default:
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String pageTitle = null;
        switch (position) {
            case 0:
                pageTitle = mContext.getString(R.string.category_headlines);
                break;

            case 1:
                pageTitle = mContext.getString(R.string.category_world);
                break;
            case 2:
                pageTitle = mContext.getString(R.string.category_technology);
                break;
            case 3:
                pageTitle = mContext.getString(R.string.category_business);
                break;
            case 4:
                pageTitle = mContext.getString(R.string.category_science);
                break;
            case 5:
                pageTitle = mContext.getString(R.string.category_sports);
                break;
            case 6:
                pageTitle = mContext.getString(R.string.category_entertainment);
                break;
            case 7:
                pageTitle = mContext.getString(R.string.category_health);
                break;
            default:
                break;
        }

        return pageTitle;
    }

}

package com.example.android.musicalstructureapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Dolea on 22.03.2018.
 */

public class SongsFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SongsFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext=context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LoveSongsFragment();
        } else {
            return new RockSongsFragment();
        }

    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.love_songs);

        } else {
            return mContext.getString(R.string.rock_songs);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}


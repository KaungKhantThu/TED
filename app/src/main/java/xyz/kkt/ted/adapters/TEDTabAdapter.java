package xyz.kkt.ted.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class TEDTabAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragment;

    public TEDTabAdapter(FragmentManager fm) {
        super(fm);
        mFragment = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    public void addTap(Fragment fragment) {
        mFragment.add(fragment);
    }
}

package com.gjc.android.androidstu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gjc.android.androidstu.ui.fragment.CenterFragment;
import com.gjc.android.androidstu.ui.fragment.HomeFragment;
import com.gjc.android.androidstu.ui.fragment.UserFragment;
import com.gjc.android.androidstu.utils.StringUtils;

/**
 * Created by gjc on 2015/8/20.
 */
public class CollectionPagerAdapter extends FragmentPagerAdapter{
    public CollectionPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                CenterFragment centerFragment = new CenterFragment();
                return centerFragment;
            case 2:
                UserFragment userFragment = new UserFragment();
                return userFragment;
            case 3:
                userFragment = new UserFragment();
                return userFragment;
            case 4:
                userFragment = new UserFragment();
                return userFragment;
            default:
                break;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab"+(position+1);
    }

    @Override
    public int getCount() {
        return StringUtils.PAGER_TOTAL;
    }
}

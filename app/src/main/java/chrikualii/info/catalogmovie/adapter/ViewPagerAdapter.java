package chrikualii.info.catalogmovie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import chrikualii.info.catalogmovie.ui.NowPlayingFragment;
import chrikualii.info.catalogmovie.ui.UpcomingFragment;

/**
 * Created by chirikualii on 13/12/18
 * github.com/chirikualii
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new NowPlayingFragment();
                break;
            case 1:
                fragment = new UpcomingFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }


}

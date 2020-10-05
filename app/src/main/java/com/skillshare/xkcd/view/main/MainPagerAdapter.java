package com.skillshare.xkcd.view.main;

import android.content.res.Resources;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.skillshare.xkcd.R;
import com.skillshare.xkcd.view.main.tabs.comiclist.ComicListFragment;
import com.skillshare.xkcd.view.main.tabs.todayscomic.TodaysComicFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_TODAYS_COMIC = 0;
    private static final int PAGE_COMIC_LIST = 1;
    private Resources resources;

    public MainPagerAdapter(@NonNull FragmentManager fm, Resources resources) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.resources = resources;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PAGE_TODAYS_COMIC:
                return new TodaysComicFragment();
            case PAGE_COMIC_LIST:
                // TODO Replace with comic list fragment
                return new ComicListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case PAGE_TODAYS_COMIC:
                return resources.getString(R.string.title_todays_comic);
            case PAGE_COMIC_LIST:
                return resources.getString(R.string.title_comic_catalog);
            default:
                return "";
        }
    }


}

package com.dharmendra.redmart.uis.main.details;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dharmendra.redmart.models.pojos.Image;

import java.util.List;

/**
 * Created by dharmendra on 7/1/18.
 */

public class ImagePagerAdapter extends FragmentStatePagerAdapter {

    private List<Image> images;

    public ImagePagerAdapter(FragmentManager fm, List<Image> images) {
        super(fm);
        this.images= images;
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstance(images.get(position).getName());
    }

    @Override
    public int getCount() {
        return images.size();
    }
}

package com.example.mriogalvojnior.tap4personal.treinos.adaptertreinos;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mriogalvojnior.tap4personal.treinos.fragments.BisetDorsalFragment;
import com.example.mriogalvojnior.tap4personal.treinos.fragments.BisetQuadsFragment;
import com.example.mriogalvojnior.tap4personal.treinos.fragments.IsoladosDorsalFragment;
import com.example.mriogalvojnior.tap4personal.treinos.fragments.IsoladosQuadsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mário Galvão Júnior on 01/08/2016.
 */
public class QuadricepsAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    private IsoladosQuadsFragment isoladosFragment;
    private BisetQuadsFragment bisetFragment;

    protected static final String[] CONTENT = new String[]{
            "This", "Is", "A", "Test"
    };
    private int mCount = CONTENT.length;

    @Override
    public Parcelable saveState() {
        return null;
    }

    public QuadricepsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                isoladosFragment = new IsoladosQuadsFragment();
                return isoladosFragment;
            case 1:
                bisetFragment =  new BisetQuadsFragment();
                return bisetFragment;
        }
        return null;
    }

    @Override
    public int getIconResId(int index) {
        return 0;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String t = "";
        switch (position){
            case 0:
                t = "ISOLADOS";
                break;
            case 1:
                t = "BISET";
                break;
        }
        return t;
    }

    public List<String> itensShare() {
        List<String> itensShare = new ArrayList<>();
        if (isoladosFragment != null) {
            itensShare.addAll(isoladosFragment.listaShare());
        }
        if (bisetFragment != null) {
            itensShare.addAll(bisetFragment.listaShare());
        }

        return  itensShare;
    }

}

package com.example.mriogalvojnior.tap4personal.treinos.adaptertreinos;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mriogalvojnior.tap4personal.treinos.fragments.BisetDorsalFragment;
import com.example.mriogalvojnior.tap4personal.treinos.fragments.BisetFragment;
import com.example.mriogalvojnior.tap4personal.treinos.fragments.IsoladosDorsalFragment;
import com.example.mriogalvojnior.tap4personal.treinos.fragments.IsoladosFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mário Galvão Júnior on 01/08/2016.
 */
public class DorsalAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    private IsoladosDorsalFragment isoladosFragment;
    private BisetDorsalFragment bisetFragment;

    protected static final String[] CONTENT = new String[]{
            "This", "Is", "A", "Test"
    };
    private int mCount = CONTENT.length;

    @Override
    public Parcelable saveState() {
        return null;
    }

    public DorsalAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                isoladosFragment = new IsoladosDorsalFragment();
                return isoladosFragment;
            case 1:
                bisetFragment =  new BisetDorsalFragment();
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

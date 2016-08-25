package com.example.mriogalvojnior.tap4personal.treinos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.treinos.adaptertreinos.AdapterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mário Galvão Júnior on 01/08/2016.
 */
public class BisetQuadsFragment extends Fragment{

    private ListView listExercicios;
    private AdapterFragment adapterFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listExercicios = (ListView) view.findViewById(R.id.listView_frag);
        adapterFragment = new AdapterFragment(listaExercicios(), getActivity());
        listExercicios.setAdapter(adapterFragment);
        listaExercicios();
    }

    public List<String> listaExercicios() {
        List<String> lista = new ArrayList<String>();
        lista.add("");
        return lista;
    }

    public List<String> listaShare(){
        return adapterFragment.itensSelecionados();
    }
}

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
public class IsoladosFragment extends Fragment{

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
        lista.add("Supino Reto - 4 Séries - 8 Reps");
        lista.add("Supino Reto - 4 Séries - 10 Reps");
        lista.add("Supino Reto - 4 Séries - 12 Reps");
        lista.add("Supino Reto - 4 Séries - 15 Reps");
        lista.add("Supino Inclinado - 4 Séries - 8 Reps");
        lista.add("Supino Inclinado - 4 Séries - 10 Reps");
        lista.add("Supino Inclinado - 4 Séries - 12 Reps");
        lista.add("Supino Inclinado - 4 Séries - 15 Reps");
        lista.add("Supino Declinado - 4 Séries - 8 Reps");
        lista.add("Supino Declinado - 4 Séries - 10 Reps");
        lista.add("Supino Declinado - 4 Séries - 12 Reps");
        lista.add("Supino Declinado - 4 Séries - 15 Reps");
        lista.add("Supino Reto c/ Halteres - 4 Séries - 8 Reps");
        lista.add("Supino Reto c/ Halteres - 4 Séries - 10 Reps");
        lista.add("Supino Reto c/ Halteres - 4 Séries - 12 Reps");
        lista.add("Supino Reto c/ Halteres - 4 Séries - 15 Reps");
        lista.add("Supino Reto no Cross Over - 4 Séries - 8 Reps");
        lista.add("Supino Reto no Cross Over - 4 Séries - 10 Reps");
        lista.add("Supino Reto no Cross Over - 4 Séries - 12 Reps");
        lista.add("Supino Reto no Cross Over - 4 Séries - 15 Reps");
        lista.add("Supino Incliando no Cross Over - 4 Séries - 8 Reps");
        lista.add("Supino Incliando no Cross Over - 4 Séries - 10 Reps");
        lista.add("Supino Incliando no Cross Over - 4 Séries - 12 Reps");
        lista.add("Supino Incliando no Cross Over - 4 Séries - 15 Reps");
        lista.add("Supino Inclinado c/ Halteres - 4 Séries - 8 Reps");
        lista.add("Supino Inclinado c/ Halteres - 4 Séries - 10 Reps");
        lista.add("Supino Inclinado c/ Halteres - 4 Séries - 12 Reps");
        lista.add("Supino Inclinado c/ Halteres - 4 Séries - 15 Reps");
        lista.add("Supino Declinado c/ Halteres - 4 Séries - 8 Reps");
        lista.add("Supino Declinado c/ Halteres - 4 Séries - 10 Reps");
        lista.add("Supino Declinado c/ Halteres - 4 Séries - 12 Reps");
        lista.add("Supino Declinado c/ Halteres - 4 Séries - 15 Reps");
        lista.add("Crucifixo c/ Halteres - 4 Séries - 8 Reps");
        lista.add("Crucifixo c/ Halteres - 4 Séries - 10 Reps");
        lista.add("Crucifixo c/ Halteres - 4 Séries - 12 Reps");
        lista.add("Crucifixo c/ Halteres - 4 Séries - 15 Reps");
        lista.add("Crucifixo Inclinado c/ Halteres - 4 Séries - 8 Reps");
        lista.add("Crucifixo Inclinado c/ Halteres - 4 Séries - 10 Reps");
        lista.add("Crucifixo Inclinado c/ Halteres - 4 Séries - 12 Reps");
        lista.add("Crucifixo Inclinado c/ Halteres - 4 Séries - 15 Reps");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação - 4 Séries - 8 Reps");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação - 4 Séries - 10 Reps");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação - 4 Séries - 12 Reps");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação - 4 Séries - 15 Reps");
        lista.add("Fly - 4 Séries - 8 Reps");
        lista.add("Fly - 4 Séries - 10 Reps");
        lista.add("Fly - 4 Séries - 12 Reps");
        lista.add("Fly - 4 Séries - 15 Reps");
        lista.add("Chest Press - 4 Séries - 8 Reps");
        lista.add("Chest Press - 4 Séries - 10 Reps");
        lista.add("Chest Press - 4 Séries - 12 Reps");
        lista.add("Chest Press - 4 Séries - 15 Reps");
        lista.add("Flexão de Braço - 4 Séries - 8 Reps");
        lista.add("Flexão de Braço - 4 Séries - 10 Reps");
        lista.add("Flexão de Braço - 4 Séries - 12 Reps");
        lista.add("Flexão de Braço - 4 Séries - 15 Reps");
        lista.add("Supino Reto - 5 Séries - 8 Reps");
        lista.add("Supino Reto - 5 Séries - 10 Reps");
        lista.add("Supino Reto - 5 Séries - 12 Reps");
        lista.add("Supino Reto - 5 Séries - 15 Reps");
        lista.add("Supino Inclinado - 5 Séries - 8 Reps");
        lista.add("Supino Inclinado - 5 Séries - 10 Reps");
        lista.add("Supino Inclinado - 5 Séries - 12 Reps");
        lista.add("Supino Inclinado - 5 Séries - 15 Reps");
        lista.add("Supino Declinado - 5 Séries - 8 Reps");
        lista.add("Supino Declinado - 5 Séries - 10 Reps");
        lista.add("Supino Declinado - 5 Séries - 12 Reps");
        lista.add("Supino Declinado - 5 Séries - 15 Reps");
        lista.add("Supino Reto c/ Halteres - 5 Séries - 8 Reps");
        lista.add("Supino Reto c/ Halteres - 5 Séries - 10 Reps");
        lista.add("Supino Reto c/ Halteres - 5 Séries - 12 Reps");
        lista.add("Supino Reto c/ Halteres - 5 Séries - 15 Reps");
        lista.add("Supino Reto no Cross Over - 5 Séries - 8 Reps");
        lista.add("Supino Reto no Cross Over - 5 Séries - 10 Reps");
        lista.add("Supino Reto no Cross Over - 5 Séries - 12 Reps");
        lista.add("Supino Reto no Cross Over - 5 Séries - 15 Reps");
        lista.add("Supino Incliando no Cross Over - 5 Séries - 8 Reps");
        lista.add("Supino Incliando no Cross Over - 5 Séries - 10 Reps");
        lista.add("Supino Incliando no Cross Over - 5 Séries - 12 Reps");
        lista.add("Supino Incliando no Cross Over - 5 Séries - 15 Reps");
        lista.add("Supino Inclinado c/ Halteres - 5 Séries - 8 Reps");
        lista.add("Supino Inclinado c/ Halteres - 5 Séries - 10 Reps");
        lista.add("Supino Inclinado c/ Halteres - 5 Séries - 12 Reps");
        lista.add("Supino Inclinado c/ Halteres - 5 Séries - 15 Reps");
        lista.add("Supino Declinado c/ Halteres - 5 Séries - 8 Reps");
        lista.add("Supino Declinado c/ Halteres - 5 Séries - 10 Reps");
        lista.add("Supino Declinado c/ Halteres - 5 Séries - 12 Reps");
        lista.add("Supino Declinado c/ Halteres - 5 Séries - 15 Reps");
        lista.add("Crucifixo c/ Halteres - 5 Séries - 8 Reps");
        lista.add("Crucifixo c/ Halteres - 5 Séries - 10 Reps");
        lista.add("Crucifixo c/ Halteres - 5 Séries - 12 Reps");
        lista.add("Crucifixo c/ Halteres - 5 Séries - 15 Reps");
        lista.add("Crucifixo Inclinado c/ Halteres - 5 Séries - 8 Reps");
        lista.add("Crucifixo Inclinado c/ Halteres - 5 Séries - 10 Reps");
        lista.add("Crucifixo Inclinado c/ Halteres - 5 Séries - 12 Reps");
        lista.add("Crucifixo Inclinado c/ Halteres - 5 Séries - 15 Reps");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação - 5 Séries - 8 Reps");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação - 5 Séries - 10 Reps");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação - 5 Séries - 12 Reps");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação - 5 Séries - 15 Reps");
        lista.add("Fly - 5 Séries - 8 Reps");
        lista.add("Fly - 5 Séries - 10 Reps");
        lista.add("Fly - 5 Séries - 12 Reps");
        lista.add("Fly - 5 Séries - 15 Reps");
        lista.add("Chest Press - 5 Séries - 8 Reps");
        lista.add("Chest Press - 5 Séries - 10 Reps");
        lista.add("Chest Press - 5 Séries - 12 Reps");
        lista.add("Chest Press - 5 Séries - 15 Reps");
        lista.add("Flexão de Braço - 5 Séries - 8 Reps");
        lista.add("Flexão de Braço - 5 Séries - 10 Reps");
        lista.add("Flexão de Braço - 5 Séries - 12 Reps");
        lista.add("Flexão de Braço - 5 Séries - 15 Reps");

        return lista;
    }

    public List<String> listaShare(){
        return adapterFragment.itensSelecionados();
    }
}

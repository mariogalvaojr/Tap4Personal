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
public class IsoladosQuadsFragment extends Fragment{

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
        lista.add("Agachamento Livre - 8 Reps - 4 Séries");
        lista.add("Agachamento Smith - 8 Reps - 4 Séries");
        lista.add("Agachamento c/ Halteres - 8 Reps - 4 Séries");
        lista.add("Agachamento c/ Bola - 8 Reps - 4 Séries");
        lista.add("Agachamento Sumô Smith - 8 Reps - 4 Séries");
        lista.add("Agachamento Sumô c/ Halteres - 8 Reps - 4 Séries");
        lista.add("Agachamento Sumô Livre - 8 Reps - 4 Séries");
        lista.add("Hack Machine - 8 Reps - 4 Séries");
        lista.add("Leg Press 45º - 8 Reps - 4 Séries");
        lista.add("Leg Press 90º - 8 Reps - 4 Séries");
        lista.add("Leg Press 180º - 8 Reps - 4 Séries");
        lista.add("Extensora - 8 Reps - 4 Séries");
        lista.add("Flexora deitada - 8 Reps - 4 Séries");
        lista.add("Flexora sentada - 8 Reps - 4 Séries");
        lista.add("Flexora livre c/ halteres - 8 Reps - 4 Séries");
        lista.add("Passada Unilateral Livre c/ Barra - 8 Reps - 4 Séries");
        lista.add("Passada Unilateral Livre c/ Halteres - 8 Reps - 4 Séries");
        lista.add("Passada Unilateral no Smith - 8 Reps - 4 Séries");
        return lista;
    }

    public List<String> listaShare(){
        return adapterFragment.itensSelecionados();
    }
}

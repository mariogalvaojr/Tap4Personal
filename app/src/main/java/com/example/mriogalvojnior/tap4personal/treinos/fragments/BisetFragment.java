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
public class BisetFragment extends Fragment{

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
        lista.add("Supino Reto 10 Reps + Fly 15 Reps - 4 Séries");
        lista.add("Supino Reto 10 Reps + Crucifixo Reto c/ Halteres 15 Reps - 4 Séries");
        lista.add("Supino Inclinado 10 Reps + Fly 15 Reps - 4 Séries");
        lista.add("Supino Declinado 10 Reps + Crucifixo Reto c/ Halteres 15 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 10 Reps + Cross Over 15 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres 10 Reps + Barra Paralela até a Falha - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 8 Reps + Crucifixo Inclinado 12 Reps - 4 Séries");
        lista.add("Supino Inclinado Máquina 10 Reps + Cross Over 15 Reps - 4 Séries");
        lista.add("Supino Reto Barra Guiada 10 Reps + Flexão de Braço até a Falha - 4 Séries");
        lista.add("Supino Inclinado Barra Guiada 10 Reps + Flexão de Braço até a Falha - 4 Séries");
        lista.add("Cross Over 10 Reps + Chest Press 15 Reps - 4 Séries");
        lista.add("Paralela até a Falha + Cross Over 15 Reps - 4 Séries");
        lista.add("Crucifixo Inclinado 10 Reps + Chest Press 15 Reps - 4 Séries");
        lista.add("Crucifixo Reto 10 Reps + Supino Reto c/ Halteres 12 Reps - 4 Séries");
        lista.add("Chest Press Inclinado 10 Reps + Fly 15 Reps - 4 Séries");
        lista.add("Chest Press 10 Reps + Crucifixo Reto 15 Reps - 4 Séries");
        lista.add("Supino Declinado 10 Reps + Fly 15 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 10 Reps + Crucifixo Inclinado 15 Reps - 4 Séries");
        lista.add("");
        lista.add("Supino Reto 8 Reps + Fly 12 Reps - 4 Séries");
        lista.add("Supino Reto 8 Reps + Crucifixo Reto c/ Halteres 12 Reps - 4 Séries");
        lista.add("Supino Inclinado 8 Reps + Fly 12 Reps - 4 Séries");
        lista.add("Supino Declinado 8 Reps + Crucifixo Reto c/ Halteres 12 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 8 Reps + Cross Over 12 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres 8 Reps + Barra Paralela até a Falha - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 8 Reps + Crucifixo Inclinado 12 Reps - 4 Séries");
        lista.add("Supino Inclinado Máquina 8 Reps + Cross Over 12 Reps - 4 Séries");
        lista.add("Supino Reto Barra Guiada 8 Reps + Flexão de Braço até a Falha - 4 Séries");
        lista.add("Supino Inclinado Barra Guiada 8 Reps + Flexão de Braço até a Falha - 4 Séries");
        lista.add("Cross Over 8 Reps + Chest Press 12 Reps - 4 Séries");
        lista.add("Paralela até a Falha + Cross Over 12 Reps - 4 Séries");
        lista.add("Crucifixo Inclinado 8 Reps + Chest Press 12 Reps - 4 Séries");
        lista.add("Crucifixo Reto 8 Reps + Supino Reto c/ Halteres 12 Reps - 4 Séries");
        lista.add("Chest Press Inclinado 8 Reps + Fly 12 Reps - 4 Séries");
        lista.add("Chest Press 8 Reps + Crucifixo Reto 12 Reps - 4 Séries");
        lista.add("Supino Declinado 8 Reps + Fly 12 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 8 Reps + Crucifixo Inclinado 12 Reps - 4 Séries");
        lista.add("");
        lista.add("Supino Reto 6 Reps + Fly 8 Reps - 3 Séries");
        lista.add("Supino Reto 6 Reps + Crucifixo Reto c/ Halteres 8 Reps - 4 Séries");
        lista.add("Supino Inclinado 6 Reps + Fly 10 Reps - 4 Séries");
        lista.add("Supino Declinado 6 Reps + Crucifixo Reto c/ Halteres 10 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 6 Reps + Cross Over 12 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres 6 Reps + Barra Paralela até a Falha - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 6 Repetições + Crucifixo Inclinado 12 Reps - 4 Séries");
        lista.add("Supino Inclinado Máquina 10 Reps + Cross Over 10 Reps - 4 Séries");
        lista.add("Supino Reto Barra Guiada 6 Reps + Flexão de Braço até a Falha - 4 Séries");
        lista.add("Supino Inclinado Barra Guiada 6 Reps + Flexão de Braço até a Falha - 4 Séries");
        lista.add("Cross Over 6 Reps + Chest Press 12 Reps - 4 Séries");
        lista.add("Paralela até a Falha + Cross Over 6 Reps - 4 Séries");
        lista.add("Crucifixo Inclinado 6 Reps + Chest Press 6 Reps - 4 Séries");
        lista.add("Crucifixo Reto 6 Reps + Supino Reto c/ Halteres 6 Reps - 4 Séries");
        lista.add("Chest Press Inclinado 6 Reps + Fly 6 Reps - 4 Séries");
        lista.add("Chest Press 6 Reps + Crucifixo Reto 6 Reps - 4 Séries");
        lista.add("Supino Declinado 6 Reps + Fly 6 Reps - 4 Séries");
        lista.add("Supino Inclinado c/ Halteres c/ Rotação 6 Reps + Crucifixo Inclinado 6 Reps - 4 Séries");

        return lista;
    }

    public List<String> listaShare(){
        return adapterFragment.itensSelecionados();
    }
}

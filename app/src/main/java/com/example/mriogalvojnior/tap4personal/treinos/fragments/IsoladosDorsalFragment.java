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
public class IsoladosDorsalFragment extends Fragment{

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
        lista.add("Remada Baixa Sentado c/ Barra pegada aberta - 8 Reps - 4 Séries");
        lista.add("Remada Baixa Sentado c/ Triângulo - 8 Reps - 4 Séries");
        lista.add("Remada Baixa Sentado c/ Barra Neutra - 8 Reps - 4 Séries");
        lista.add("Remada Alta c/ Barra - 8 Reps - 4 Séries");
        lista.add("Encolhimento c/ Halteres - 8 Reps - 4 Séries");
        lista.add("Encolhimento c/ Barra - 8 Reps - 4 Séries");
        lista.add("Remada Serrador Unilateral - 8 Reps - 4 Séries");
        lista.add("Remada Curvada c/ Barra pegada pronada - 8 Reps - 4 Séries");
        lista.add("Remada Curvada c/ Barra pegada supinada - 8 Reps - 4 Séries");
        lista.add("Remada Cavalinho c/ Triângulo - 8 Reps - 4 Séries");
        lista.add("Remada Articulada - 8 Reps - 4 Séries");
        lista.add("Puxador Frontal c/ barra Aberto pegada pronada - 8 Reps - 4 Séries");
        lista.add("Puxador Frontal c/ barra fechado pegada supinada - 8 Reps - 4 Séries");
        lista.add("Puxador Frontal c/ barra neutra - 8 Reps - 4 Séries");
        lista.add("Puxador Frontal c/ triângulo - 8 Reps - 4 Séries");
        lista.add("Puxador Nuca c/ barra Aberto - 8 Reps - 4 Séries");
        lista.add("Puxador Nuca c/ barra Neutra - 8 Reps - 4 Séries");
        lista.add("Barra Fixa - 8 Reps - 4 Séries");
        lista.add("Levantamento Terra - 8 Reps - 4 Séries");
        lista.add("Extensão Lombar - 8 Reps - 4 Séries");
        lista.add("Puxada no Cross Over c/ alça - 8 Reps - 4 Séries");
        lista.add("Pull Down c/ barra no Cross Over - 8 Reps - 4 Séries");
        lista.add("Pull Down c/ Triângulo no Cross Over - 8 Reps - 4 Séries");
        lista.add("Pull Down c/ Halteres no banco - 8 Reps - 4 Séries");
        return lista;
    }

    public List<String> listaShare(){
        return adapterFragment.itensSelecionados();
    }
}

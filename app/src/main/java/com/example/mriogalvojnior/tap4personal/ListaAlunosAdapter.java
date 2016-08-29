package com.example.mriogalvojnior.tap4personal;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mário Galvão Júnior on 27/07/2016.
 */
public class ListaAlunosAdapter extends BaseAdapter{

    private Context context;
    private List<Aluno> listaExibicao;
    private List<Aluno> lista;
    private AlunoDao alunoDao;
    private ListaAlunosActivity activity;

    public ListaAlunosAdapter(Context context, List<Aluno> listaAlunos, AlunoDao alunoDao) {
        this.context = context;
        this.lista = listaAlunos;
        this.alunoDao = alunoDao;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Aluno getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Aluno aluno = lista.get(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_adapter, null);
        }

        Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf");
        TextView text = (TextView) view.findViewById(R.id.textView);
        text.setTypeface(font);
        text.setText(aluno.getNome());

        return view;
    }
}

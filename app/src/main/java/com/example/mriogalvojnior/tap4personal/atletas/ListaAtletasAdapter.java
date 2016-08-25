package com.example.mriogalvojnior.tap4personal.atletas;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Atleta;
import com.example.mriogalvojnior.tap4personal.gen.dao.AtletaDao;

import java.util.List;

/**
 * Created by Mário Galvão Júnior on 29/07/2016.
 */
public class ListaAtletasAdapter extends BaseAdapter {

    private List<Atleta> lista;
    private Context context;
    private AtletaDao dao;

    public ListaAtletasAdapter(List<Atleta> lista, Context context, AtletaDao dao) {
        this.lista = lista;
        this.context = context;
        this.dao = dao;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Atleta getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Atleta atleta = lista.get(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_adapter, null);
        }

        Typeface font = Typeface.createFromAsset(context.getAssets(), "times.ttf");
        TextView text = (TextView) view.findViewById(R.id.textView);
        text.setTypeface(font);
        text.setText(atleta.getNome());

        return view;
    }
}

package com.example.mriogalvojnior.tap4personal;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Patologia;
import com.example.mriogalvojnior.tap4personal.gen.Trofeus;
import com.example.mriogalvojnior.tap4personal.gen.dao.PatologiaDao;

import java.util.List;

/**
 * Created by Mário Galvão Júnior on 23/08/2016.
 */
public class ListaPatologiaAdapter extends BaseAdapter {

    private Context context;
    private List<Patologia> patologiaList;
    private PatologiaDao patologiaDao;

    public ListaPatologiaAdapter(Context context, List<Patologia> patologiaList, PatologiaDao patologiaDao) {
        this.context = context;
        this.patologiaList = patologiaList;
        this.patologiaDao = patologiaDao;
    }

    @Override
    public int getCount() {
        return patologiaList.size();
    }

    @Override
    public Patologia getItem(int i) {
        return patologiaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Patologia patologia = patologiaList.get(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_adapter_patologias, null);
        }

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");
        TextView textView = (TextView) view.findViewById(R.id.textView_pat);
        textView.setText(patologia.getNome());
        textView.setTypeface(typeface);

        return view;
    }

    public void setListaPatologias(List<Patologia> patologiaList){
        this.patologiaList = patologiaList;
        notifyDataSetChanged();
    }
}

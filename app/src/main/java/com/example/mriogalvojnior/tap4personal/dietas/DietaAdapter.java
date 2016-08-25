package com.example.mriogalvojnior.tap4personal.dietas;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.gen.Aluno;

import java.util.List;

public class DietaAdapter extends BaseAdapter {

    private List<String> lista;
    private Context context;

    public DietaAdapter(List<String> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public String getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final String ref = lista.get(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_dieta_adapter, null);
        }

        Typeface font = Typeface.createFromAsset(context.getAssets(), "times.ttf");
        TextView refeicao = (TextView) view.findViewById(R.id.refeicao);
        refeicao.setTypeface(font);
        refeicao.setText(ref);

        ImageView delete = (ImageView) view.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.remove(i);
                notifyDataSetChanged();
                Toast.makeText(context, "Refeição Excluida!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void refeicoes(List<String> listaRefs) {
        this.lista = listaRefs;
        notifyDataSetChanged();
    }
}



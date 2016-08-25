package com.example.mriogalvojnior.tap4personal.treinos.adaptertreinos;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mário Galvão Júnior on 22/07/2016.
 */
public class AdapterFragment extends BaseAdapter {

    private List<String> lista;
    private Context context;
    private List<String> itensSelecionados = new ArrayList<>();

    public AdapterFragment(List<String> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    public List<String> itensSelecionados() {
        return itensSelecionados;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public String getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String exercicio = lista.get(position);
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_fragment_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Typeface font = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");
        holder.texto.setText(exercicio);
        holder.texto.setTypeface(font);
        if (holder.texto.getText().toString().equals("")){
            holder.checkBox.setVisibility(View.INVISIBLE);
        }else{
            holder.checkBox.setVisibility(View.VISIBLE);
        }
        holder.checkBox.setTag(exercicio);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox check = (CheckBox) v;
                String exerc = (String) check.getTag();
                if (check.isChecked()) {
                    if (!itensSelecionados.contains(exerc)) {
                        itensSelecionados.add(exerc);
                    } else {
                        if (itensSelecionados.contains(exerc)) ;
                        itensSelecionados.remove(exerc);
                    }
                }
            }
        });

        if (itensSelecionados.contains(exercicio)) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }

        return convertView;
    }

    public class ViewHolder {
        public TextView texto;
        public CheckBox checkBox;

        public ViewHolder(View view) {
            texto = (TextView) view.findViewById(R.id.text_fragment);
            checkBox = (CheckBox) view.findViewById(R.id.checkbox_fragment);
        }
    }
}

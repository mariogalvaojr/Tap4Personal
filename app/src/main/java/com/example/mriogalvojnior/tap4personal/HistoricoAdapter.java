package com.example.mriogalvojnior.tap4personal;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Histotico;
import com.example.mriogalvojnior.tap4personal.gen.dao.HistoticoDao;

import org.w3c.dom.Text;

import java.util.List;

public class HistoricoAdapter extends BaseAdapter {

    private Context context;
    private List<Histotico> listaHistorico;
    private HistoticoDao dao;

    public HistoricoAdapter(Context context, List<Histotico> listaHistorico, HistoticoDao dao) {
        this.context = context;
        this.listaHistorico = listaHistorico;
        this.dao = dao;
    }

    @Override
    public int getCount() {
        return listaHistorico.size();
    }

    @Override
    public Histotico getItem(int i) {
        return listaHistorico.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Histotico historico = listaHistorico.get(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_historico_adapter, null);
        }

        Typeface font = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");
        TextView dataText = (TextView) view.findViewById(R.id.text_data);
        dataText.setTypeface(font);
        dataText.setText("Data: " + historico.getData());
//
//        TextView pesoText = (TextView) view.findViewById(R.id.text_peso);
//        pesoText.setTypeface(font);
//        pesoText.setText("Peso: " + historico.getPeso() + " kg");
//
//        TextView bfText = (TextView) view.findViewById(R.id.text_bf);
//        bfText.setTypeface(font);
//        bfText.setText("BF: " + historico.getBf() + "%");



        return view;
    }

    public void setListaHistorico(List<Histotico> lista){
        this.listaHistorico = lista;
        notifyDataSetChanged();
    }
}

package com.example.mriogalvojnior.tap4personal.atletas;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.gen.Trofeus;
import com.example.mriogalvojnior.tap4personal.gen.dao.TrofeusDao;

import org.w3c.dom.Text;

import java.util.List;

public class TrofeusAdapter extends BaseAdapter {

    private List<Trofeus> listaTrofeus;
    private Context context;
    private TrofeusDao dao;

    public TrofeusAdapter(List<Trofeus> listaTrofeus, Context context, TrofeusDao dao) {
        this.listaTrofeus = listaTrofeus;
        this.context = context;
        this.dao = dao;
    }

    @Override
    public int getCount() {
        return listaTrofeus.size();
    }

    @Override
    public Trofeus getItem(int i) {
        return listaTrofeus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Trofeus trofeus = listaTrofeus.get(i);
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_trofeus_adapter, null);
        }

        Typeface font = Typeface.createFromAsset(context.getAssets(), "times.ttf");
        TextView colocacaoText = (TextView) view.findViewById(R.id.text_colocacao_ad);
        colocacaoText.setText(trofeus.getColocacao());
        colocacaoText.setTypeface(font);

        TextView campeonatoTxt = (TextView) view.findViewById(R.id.text_campeonato_ad);
        campeonatoTxt.setText(trofeus.getCampeonato());
        campeonatoTxt.setTypeface(font);

        TextView anoText = (TextView) view.findViewById(R.id.text_ano);
        anoText.setText(trofeus.getAno());
        anoText.setTypeface(font);

        return view;
    }
    public void setListaTrofeus(List<Trofeus> listaTrofeus){
        this.listaTrofeus = listaTrofeus;
        notifyDataSetChanged();
    }

}

package com.example.mriogalvojnior.tap4personal;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.gen.DivisaoTreino;
import com.example.mriogalvojnior.tap4personal.gen.Patologia;
import com.example.mriogalvojnior.tap4personal.gen.dao.DivisaoTreinoDao;

import java.util.List;

/**
 * Created by Mário Galvão Júnior on 24/08/2016.
 */
public class DivisaoTreinoAdapter extends BaseAdapter {

    private Context context;
    private List<DivisaoTreino> divisaoTreinoList;
    private DivisaoTreinoDao divisaoTreinoDao;

    public DivisaoTreinoAdapter(DivisaoTreinoDao divisaoTreinoDao, Context context, List<DivisaoTreino> divisaoTreinoList) {
        this.divisaoTreinoDao = divisaoTreinoDao;
        this.context = context;
        this.divisaoTreinoList = divisaoTreinoList;
    }

    @Override
    public int getCount() {
        return divisaoTreinoList.size();
    }

    @Override
    public DivisaoTreino getItem(int i) {
        return divisaoTreinoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final DivisaoTreino divisaoTreino = divisaoTreinoList.get(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_adapter_patologias, null);
        }

        Typeface font = Typeface.createFromAsset(context.getAssets(), "roboto.ttf");
        TextView textView = (TextView) view.findViewById(R.id.textView_pat);
        textView.setText(divisaoTreino.getDiadasemana());
        textView.setTypeface(font);

        return view;
    }

    public void setDivisaoTreino(List<DivisaoTreino> divisaoTreinoList){
        this.divisaoTreinoList = divisaoTreinoList;
        notifyDataSetChanged();
    }
}

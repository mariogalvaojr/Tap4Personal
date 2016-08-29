package com.example.mriogalvojnior.tap4personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mário Galvão Júnior on 29/08/2016.
 */
public class HistoricoPagamentoAdapter extends BaseAdapter {

    private Context context;
    private List<String> datas;

    public HistoricoPagamentoAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final String listDatas = datas.get(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_adapter, null);
        }

        TextView textView = (TextView) view.findViewById(R.id.textDatasPagamentos);
        textView.setText(listDatas.toString());
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner_statusPagamentos);
        List<String> statusList = new ArrayList<>();
        statusList.add("Em aberto");
        statusList.add("Pago");
        statusList.add("Atrasado");
        ArrayAdapter<String> statusAdapter = new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_list_item_1, statusList);
        spinner.setAdapter(statusAdapter);

        return view;
    }
}

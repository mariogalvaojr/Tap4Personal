package com.example.mriogalvojnior.tap4personal;

import android.app.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HistoricoPagamentoActivity extends AppCompatActivity implements View.OnClickListener {

    private AlunoDao alunoDao;
    private Aluno aluno;
    private Toolbar toolbar;
    private TextView textToolbar;
    private long getIdAluno;
    private ImageView arrowImage;
    private ListView listView;
    private int year, month, day;
    private DatePicker datePicker;
    private Calendar calendar;
    List<String> datas = new ArrayList<>();
    private HistoricoPagamentoAdapter historicoPagamentoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_pagamento);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        alunoDao = application.getNewDBSession().getAlunoDao();

        getIdAluno = getIntent().getExtras().getLong("alunoid");

        aluno = alunoDao.load(getIdAluno);

        toolbar = (Toolbar) findViewById(R.id.toolbar_historicoPagamentos);
        textToolbar = (TextView) findViewById(R.id.title_toolbar_historicoPagamentos);
        arrowImage = (ImageView) findViewById(R.id.iv_back_historicoPagamentos);
        listView = (ListView) findViewById(R.id.listaHistoricoPagamentos);
        historicoPagamentoAdapter = new HistoricoPagamentoAdapter(this, datas);
        listView.setAdapter(historicoPagamentoAdapter);

        arrowImage.setOnClickListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.iv_back_historicoPagamentos:
                intent = new Intent(this, InfoAlunoActivity.class);
                intent.putExtra("alunoid", aluno.getId());
                startActivity(intent);
                break;
        }
    }

    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new android.app.DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private android.app.DatePickerDialog.OnDateSetListener myDateListener = new android.app.DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showDate(i, i1+1, i2);
        }
    };


    private void showDate(int year, int month, int day) {
            datas.add(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year).toString());
    }
}

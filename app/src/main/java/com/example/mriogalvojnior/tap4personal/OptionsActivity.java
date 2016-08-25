package com.example.mriogalvojnior.tap4personal;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.atletas.ListaAtletasActivity;
import com.example.mriogalvojnior.tap4personal.dietas.DietasActivity;
import com.example.mriogalvojnior.tap4personal.suplementos.SuplementosActivity;
import com.example.mriogalvojnior.tap4personal.treinos.MusculosActivity;
import com.github.clans.fab.FloatingActionButton;

import java.lang.reflect.Type;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fabPessoas, fabTreinos, fabDietas, fabSuplementos;
    private AlertDialog alerta;
    private Toolbar toolbar;
    private ImageView arrowBack;
    private TextView textToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        fabPessoas = (FloatingActionButton) findViewById(R.id.fab_pessoas);
        fabTreinos = (FloatingActionButton) findViewById(R.id.fab_treinos);
        fabDietas = (FloatingActionButton) findViewById(R.id.fab_dietas);
        fabSuplementos = (FloatingActionButton) findViewById(R.id.fab_suplementos);
        arrowBack = (ImageView) findViewById(R.id.iv_back);

        arrowBack.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textToolbar = (TextView) findViewById(R.id.textToolbar);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textToolbar.setTypeface(font);

        setSupportActionBar(toolbar);

        fabPessoas.setOnClickListener(this);
        fabTreinos.setOnClickListener(this);
        fabDietas.setOnClickListener(this);
        fabSuplementos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_pessoas:
                startActivity(new Intent(this, ListaAlunosActivity.class));
//                optionsPessoas();
                break;
            case R.id.fab_treinos:
                startActivity(new Intent(this, MusculosActivity.class));
                break;
            case R.id.fab_dietas:
                startActivity(new Intent(this, DietasActivity.class));
                break;
            case R.id.fab_suplementos:
                startActivity(new Intent(this, SuplementosActivity.class));
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void optionsPessoas(){

        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.dialog_pessoa, null);
        view.findViewById(R.id.button_alunos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListaAlunosActivity.class));
            }
        });
        view.findViewById(R.id.button_atletas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(), ListaAtletasActivity.class));
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }
}

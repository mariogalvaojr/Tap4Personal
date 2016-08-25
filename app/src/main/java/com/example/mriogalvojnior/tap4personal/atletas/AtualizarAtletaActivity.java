package com.example.mriogalvojnior.tap4personal.atletas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.ListaAlunosActivity;
import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.Tap4PersonalApplication;
import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Atleta;
import com.example.mriogalvojnior.tap4personal.gen.dao.AtletaDao;

import java.util.ArrayList;
import java.util.List;

public class AtualizarAtletaActivity extends AppCompatActivity {

    private AtletaDao dao;
    private EditText nome, treinador;
    private Spinner categoria;
    private long idAtt;
    private Atleta atleta;
    private String cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_atleta);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        dao = application.getNewDBSession().getAtletaDao();

        getSupportActionBar().setTitle("Atualizar");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nome = (EditText) findViewById(R.id.edit_nome_atletaatt);
        treinador = (EditText) findViewById(R.id.edit_treinador_atletaatt);
        categoria = (Spinner) findViewById(R.id.spinner_categoriaatt);

        idAtt = getIntent().getExtras().getLong("atletaatt");
        atleta = dao.load(idAtt);

        atleta.getId();
        nome.setText(atleta.getNome());
        treinador.setText(atleta.getTreinador());

        List<String> categorias = new ArrayList<>();
        categorias.add("Culturismo Clássico");
        categorias.add("Men's Physique");
        categorias.add("Culturismo Sênior");
        categorias.add("Welness");
        categorias.add("Bikini");

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorias);
        categoria.setAdapter(adapterSpinner);
        categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cat = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                cat = "";
            }
        });

        categoria.getSelectedItem();

        for (int  i = 0; i < categoria.getCount(); i++){
            if (categoria.getItemAtPosition(i).toString().equalsIgnoreCase(atleta.getCategoria())){
                categoria.setSelection(i);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_atualizar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_done:
                if (atleta != null) {
                    atleta.setNome(nome.getText().toString());
                    atleta.setTreinador(treinador.getText().toString());
                    atleta.setCategoria(categoria.getSelectedItem().toString());
                    dao.update(atleta);
                    Toast.makeText(this, "Atleta Atualizado com Sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, ListaAtletasActivity.class));
                } else {
                    Toast.makeText(this, "Aluno Ainda não Cadastrado!.", Toast.LENGTH_SHORT).show();
                }
                return true;

            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

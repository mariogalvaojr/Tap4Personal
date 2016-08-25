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

public class CadastroAtletasActivity extends AppCompatActivity {

    private AtletaDao dao;
    private EditText nomeEdit, treinadorEdit;
    private Spinner categoriaSpinner;
    private String cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atletas);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        dao = application.getNewDBSession().getAtletaDao();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Cadastro de Atletas");

        nomeEdit = (EditText) findViewById(R.id.edit_nome_atleta);
        treinadorEdit = (EditText) findViewById(R.id.edit_treinador_atleta);
        categoriaSpinner = (Spinner) findViewById(R.id.spinner_categoria);

        List<String> categorias = new ArrayList<>();
        categorias.add("Culturismo Clássico");
        categorias.add("Men's Physique");
        categorias.add("Culturismo Sênior");
        categorias.add("Welness");
        categorias.add("Bikini");

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorias);
        categoriaSpinner.setAdapter(adapterSpinner);
        categoriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cat = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                cat = "";
            }
        });


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
                cadastroAtletas();
                startActivity(new Intent(this, ListaAtletasActivity.class));
                return true;
            case android.R.id.home:
                onBackPressed();
                startActivity(new Intent(this, ListaAtletasActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cadastroAtletas(){
        boolean validacao = true;
        String nome = nomeEdit.getText().toString();
        String treinador = treinadorEdit.getText().toString();
        String categoria = categoriaSpinner.getSelectedItem().toString();

        if (validacao){
            Atleta atleta = new Atleta();
            atleta.setNome(nome);
            atleta.setTreinador(treinador);
            atleta.setCategoria(categoria);

            dao.insert(atleta);
            Toast.makeText(this, "Atleta Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
        }
    }
}

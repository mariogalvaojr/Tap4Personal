package com.example.mriogalvojnior.tap4personal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.github.clans.fab.FloatingActionButton;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView lista;
    private ListaAlunosAdapter adapter;
    private List<Aluno> alunos;
    private Toolbar toolbar;
    private TextView textView;
    private ImageView arrowLeft;
    private AlunoDao dao;
    private FloatingActionButton fabAddPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        toolbar = (Toolbar) findViewById(R.id.toolbar_listaAlunos);
        textView = (TextView) findViewById(R.id.title_toolbar_listaAlunos);
        arrowLeft = (ImageView) findViewById(R.id.iv_back_listaAlunos);
        arrowLeft.setOnClickListener(this);

        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textView.setTypeface(font);

        setSupportActionBar(toolbar);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        dao = application.getNewDBSession().getAlunoDao();

        fabAddPessoa = (FloatingActionButton) findViewById(R.id.fab_add_pessoa);
        fabAddPessoa.setOnClickListener(this);
        lista = (ListView) findViewById(R.id.lista_alunos);
        alunos = dao.loadAll();
        adapter = new ListaAlunosAdapter(this, alunos, dao);
        lista.setAdapter(adapter);
        lista.setTextFilterEnabled(false);
        lista.setOnItemClickListener(this);

        getSupportActionBar().setTitle("Lista de Alunos");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_add_pessoa:
                startActivity(new Intent(this, CadastroAlunosActivity.class));
                break;
            case R.id.iv_back_listaAlunos:
                startActivity(new Intent(this, OptionsActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Aluno aluno = (Aluno) adapterView.getItemAtPosition(i);
        Toast.makeText(this, "Você clicou em: " + aluno.getNome().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, InfoAlunoActivity.class);
        intent.putExtra("alunoid", aluno.getId());
        startActivity(intent);
    }
}

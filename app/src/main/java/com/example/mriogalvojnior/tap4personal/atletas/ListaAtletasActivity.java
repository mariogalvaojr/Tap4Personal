package com.example.mriogalvojnior.tap4personal.atletas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.InfoAlunoActivity;
import com.example.mriogalvojnior.tap4personal.ListaAlunosAdapter;
import com.example.mriogalvojnior.tap4personal.OptionsActivity;
import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.Tap4PersonalApplication;
import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Atleta;
import com.example.mriogalvojnior.tap4personal.gen.dao.AtletaDao;
import com.github.clans.fab.FloatingActionButton;

import java.util.List;

public class ListaAtletasActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listViewAtletas;
    private AtletaDao dao;
    private List<Atleta>  listaAtletas;
    private Atleta atleta;
    private FloatingActionButton buttonAddAtleta;
    private ListaAtletasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_atletas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        dao = application.getNewDBSession().getAtletaDao();

        listViewAtletas = (ListView) findViewById(R.id.list_atletas);

        listaAtletas = dao.loadAll();
        adapter = new ListaAtletasAdapter(listaAtletas, this, dao);
        listViewAtletas.setAdapter(adapter);

        getSupportActionBar().setTitle("Lista de Atletas");

        buttonAddAtleta = (FloatingActionButton) findViewById(R.id.fab_atleta_add);
        buttonAddAtleta.setOnClickListener(this);

        listViewAtletas.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                return true;
            case android.R.id.home:
                onBackPressed();
                finish();
                startActivity(new Intent(this, OptionsActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_atleta_add:
                startActivity(new Intent(this, CadastroAtletasActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Atleta atleta = (Atleta) adapterView.getItemAtPosition(i);
        Toast.makeText(this, "Você clicou em: " + atleta.getNome().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, InfoAtletaActivity.class);
        intent.putExtra("atletaid", atleta.getId());
        startActivity(intent);
    }
}

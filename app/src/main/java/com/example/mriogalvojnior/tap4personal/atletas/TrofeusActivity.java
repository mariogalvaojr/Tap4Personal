package com.example.mriogalvojnior.tap4personal.atletas;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.Tap4PersonalApplication;
import com.example.mriogalvojnior.tap4personal.gen.Atleta;
import com.example.mriogalvojnior.tap4personal.gen.Trofeus;
import com.example.mriogalvojnior.tap4personal.gen.dao.AtletaDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.DaoSession;
import com.example.mriogalvojnior.tap4personal.gen.dao.TrofeusDao;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TrofeusActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView colocacaoText, campeonatoText;
    private Spinner colocacaoSpinner, campeonatoSpinner;
    private FloatingActionButton fabAddTrofeus;
    private TrofeusDao dao;
    private EditText anoEdit;
    private String camp, coloc;
    private List<Trofeus> listaTrofeus;
    private ListView listView;
    private long idAtleta;
    private TrofeusAdapter adapter;
    private AtletaDao atletaDao;
    private Atleta atleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trofeus);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        DaoSession daoSession = application.getNewDBSession();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dao = daoSession.getTrofeusDao();
        atletaDao = daoSession.getAtletaDao();

        Typeface font = Typeface.createFromAsset(getAssets(), "times.ttf");

        idAtleta = getIntent().getExtras().getLong("atletaid");
        atleta = atletaDao.load(idAtleta);

        getSupportActionBar().setTitle("Conquistas do Atleta");

        colocacaoText = (TextView) findViewById(R.id.text_colocacao);
        campeonatoText = (TextView) findViewById(R.id.text_campeonato);

        fabAddTrofeus = (FloatingActionButton) findViewById(R.id.fab_add_trofeus);

        fabAddTrofeus.setOnClickListener(this);

        anoEdit = (EditText) findViewById(R.id.edit_ano);

        listView = (ListView) findViewById(R.id.lista_trofeus);
        listaTrofeus = dao.loadAll();
        adapter = new TrofeusAdapter(listaTrofeus, this, dao);
        adapter.setListaTrofeus(atleta.getTrofeusAtleta());
        listView.setAdapter(adapter);

        colocacaoText.setTypeface(font);
        campeonatoText.setTypeface(font);

        colocacaoSpinner = (Spinner) findViewById(R.id.spinner_colocacao);
        campeonatoSpinner = (Spinner) findViewById(R.id.spinner_campeonato);

        List<String> colocacao = new ArrayList<>();
        colocacao.add("1º Colocado");
        colocacao.add("2º Colocado");
        colocacao.add("3º Colocado");
        colocacao.add("4º Colocado");
        colocacao.add("5º Colocado");
        colocacao.add("6º Colocado");

        final List<String> campeonato = new ArrayList<>();
        campeonato.add("Campeonato Amazonense");
        campeonato.add("Copa Manaus");
        campeonato.add("Campeonato Brasileiro");
        campeonato.add("Arnold Classic Brasil");

        ArrayAdapter<String> campeonatoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                campeonato);
        ArrayAdapter<String> colocacaoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                colocacao);

        campeonatoSpinner.setAdapter(campeonatoAdapter);
        colocacaoSpinner.setAdapter(colocacaoAdapter);

        campeonatoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                camp = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                camp = "";
            }
        });

        colocacaoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                coloc = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                coloc = "";

            }
        });
    }

    public void cadastrarTrofeus(){
        boolean validacao = true;
        String campeonato = campeonatoSpinner.getSelectedItem().toString();
        String colocacao = colocacaoSpinner.getSelectedItem().toString();
        String ano = anoEdit.getText().toString();

        if (validacao){
            Trofeus trofeus = new Trofeus();
            trofeus.setCampeonato(campeonato);
            trofeus.setColocacao(colocacao);
            trofeus.setAno(ano);

            trofeus.setAtletaID(atleta.getId());

            dao.insert(trofeus);
            Toast.makeText(this, "Conquista Cadastrada com Sucesso!", Toast.LENGTH_SHORT).show();

            adapter.setListaTrofeus(dao._queryAtleta_TrofeusAtleta(atleta.getId()));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_add_trofeus:
                cadastrarTrofeus();
                anoEdit.setText("");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

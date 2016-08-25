package com.example.mriogalvojnior.tap4personal.atletas;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.AtualizarAlunoActivity;
import com.example.mriogalvojnior.tap4personal.ListaAlunosActivity;
import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.Tap4PersonalApplication;
import com.example.mriogalvojnior.tap4personal.gen.Atleta;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.AtletaDao;

public class InfoAtletaActivity extends AppCompatActivity implements View.OnClickListener {

    private AtletaDao dao;
    private TextView nome, treinador, categoria, trofeusText;
    private long idAtelta;
    private Atleta atleta;
    private ImageView trofeusImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_atleta);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        dao = application.getNewDBSession().getAtletaDao();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nome = (TextView) findViewById(R.id.text_nomeAtleta);
        treinador = (TextView) findViewById(R.id.text_treinadorAtleta);
        categoria = (TextView) findViewById(R.id.text_catAtleta);
        trofeusImage = (ImageView) findViewById(R.id.iv_trofes);
        trofeusText = (TextView) findViewById(R.id.text_trofeus);

        trofeusImage.setOnClickListener(this);

        idAtelta = getIntent().getExtras().getLong("atletaid");
        atleta = dao.load(idAtelta);
        atleta.getTrofeusAtleta();

        Typeface typeface = Typeface.createFromAsset(getAssets(), "times.ttf");

        nome.setText(atleta.getNome());
        treinador.setText(atleta.getTreinador());
        categoria.setText(atleta.getCategoria());

        nome.setTypeface(typeface);
        treinador.setTypeface(typeface);
        categoria.setTypeface(typeface);
        trofeusText.setTypeface(typeface);


        getSupportActionBar().setTitle("Informações");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_infoaluno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                dao.deleteByKey(atleta.getId());
                startActivity(new Intent(this, ListaAtletasActivity.class));
                Toast.makeText(this, "Atleta Removido com Sucesso!", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;

            case R.id.action_atualizar:
                Intent intentAtualizar = new Intent(this, AtualizarAtletaActivity.class);
                intentAtualizar.putExtra("atletaatt", atleta.getId());
                startActivity(intentAtualizar);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_trofes:
                Intent intent = new Intent(this, TrofeusActivity.class);
                intent.putExtra("atletaid", atleta.getId());
                startActivity(intent);
                break;
        }
    }
}

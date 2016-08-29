package com.example.mriogalvojnior.tap4personal;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Histotico;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.DaoSession;
import com.example.mriogalvojnior.tap4personal.gen.dao.HistoticoDao;
import com.example.mriogalvojnior.tap4personal.treinos.InfoHistoricoActivity;
import com.github.clans.fab.FloatingActionButton;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HistoricoAlunoActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private HistoticoDao dao;
    private ListView listView;
    private Toolbar toolbar;
    private ImageView imageView;
    private TextView textView, textAvisoHistorico;
    private EditText dataEdit, pesoEdit, bfEdit;
    private FloatingActionButton fabAddHistorico;
    private HistoricoAdapter adapter;
    private List<Histotico> listaHistorico;
    private DatePickerDialog dialog;
    private long idAluno;
    private Aluno aluno;
    private AlunoDao alunodao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_aluno);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        DaoSession daoSession = application.getNewDBSession();

        toolbar = (Toolbar) findViewById(R.id.toolbar_hitoricoAlunos);
        textView = (TextView) findViewById(R.id.title_toolbar_histAlunos);
        imageView = (ImageView) findViewById(R.id.iv_back_histAlunos);
        textAvisoHistorico = (TextView) findViewById(R.id.textAvisoHistorico);

        imageView.setOnClickListener(this);

        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textView.setTypeface(font);
        textAvisoHistorico.setTypeface(font);

        dao = daoSession.getHistoticoDao();
        alunodao = daoSession.getAlunoDao();

        idAluno = getIntent().getExtras().getLong("alunoid");
        aluno = alunodao.load(idAluno);

        fabAddHistorico = (FloatingActionButton) findViewById(R.id.fab_add_histotico);
        fabAddHistorico.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.lista_historico);
        listaHistorico = dao.loadAll();
        if (listaHistorico.size() == 0 && listaHistorico.isEmpty()){
            textAvisoHistorico.setVisibility(View.VISIBLE);
            textAvisoHistorico.setText("Aluno ainda não possui históricos cadastados!");
        }else{
            textAvisoHistorico.setVisibility(View.GONE);
        }
        adapter = new HistoricoAdapter(this, listaHistorico, dao);
        adapter.setListaHistorico(aluno.getHistoricoAlunos());
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }
//
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_add_histotico:
                Intent intent = new Intent(this, CadastroHistoricoActivity.class);
                intent.putExtra("alunoid", aluno.getId());
                startActivity(intent);
                break;
            case R.id.iv_back_histAlunos:
                Intent intentw = new Intent(this, InfoAlunoActivity.class);
                intentw.putExtra("alunoid", aluno.getId());
                startActivity(intentw);
                break;
        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:
//                onBackPressed();
//                Intent intent = new Intent(this, InfoAlunoActivity.class);
//                intent.putExtra("alunoid", aluno.getId());
//                startActivity(intent);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Histotico historico = (Histotico) adapterView.getItemAtPosition(i);
        Intent intent = new Intent(this, InfoHistoricoActivity.class);
        intent.putExtra("historicoid", historico.getId());
        intent.putExtra("alunoid", aluno.getId());
        startActivity(intent);
    }
}

package com.example.mriogalvojnior.tap4personal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Patologia;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.DaoSession;
import com.example.mriogalvojnior.tap4personal.gen.dao.PatologiaDao;
import com.github.clans.fab.FloatingActionButton;

import java.util.List;

public class FichaOcorrenciaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    private ListaPatologiaAdapter adapter;
    private PatologiaDao patologiaDao;
    private AlunoDao alunoDao;
    private TextView textView, optionsText;
    private LinearLayout llAddPatologias;
    private Toolbar toolbar;
    private ImageView imageView;
    private List<Patologia> list;
    private ListView listView;
    private EditText addPatologiaEdit;
    private FloatingActionButton fabAddPatologia;
    private long getIdAluno;
    private Aluno aluno;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_ocorrencia);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        DaoSession daoSession = application.getNewDBSession();

        patologiaDao = daoSession.getPatologiaDao();
        alunoDao = daoSession.getAlunoDao();

        listView = (ListView) findViewById(R.id.listView_patologias);
        addPatologiaEdit = (EditText) findViewById(R.id.edit_add_patologia);
        fabAddPatologia = (FloatingActionButton) findViewById(R.id.fab_add_patologia);
        toolbar = (Toolbar) findViewById(R.id.toolbar_patologias);
        textView = (TextView) findViewById(R.id.title_toolbar_patologias);
        imageView = (ImageView) findViewById(R.id.iv_back_patologias);
        optionsText = (TextView) findViewById(R.id.textOptionsPatologias);
        llAddPatologias = (LinearLayout) findViewById(R.id.lladdpatologia);

        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        optionsText.setTypeface(font);
        textView.setTypeface(font);

        optionsText.setOnClickListener(this);
        imageView.setOnClickListener(this);

        getIdAluno = getIntent().getExtras().getLong("alunoid");
        aluno = alunoDao.load(getIdAluno);

        list = patologiaDao.loadAll();
        adapter = new ListaPatologiaAdapter(this, list, patologiaDao);
        adapter.setListaPatologias(aluno.getPatologiasAlunos());
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(this);

        fabAddPatologia.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_add_patologia:
                addPatologias();
                addPatologiaEdit.setText("");
                break;
            case R.id.iv_back_patologias:
                Intent intent =  new Intent(this, InfoAlunoActivity.class);
                intent.putExtra("alunoid", aluno.getId());
                startActivity(intent);
                break;
            case R.id.textOptionsPatologias:
                if (llAddPatologias.getVisibility() == View.GONE){
                    llAddPatologias.setVisibility(View.VISIBLE);
                    optionsText.setText("HIDE Options");
                    optionsText.setTextColor(Color.BLUE);
                }else {
                    llAddPatologias.setVisibility(View.GONE);
                    optionsText.setText("SHOW Options");
                    optionsText.setTextColor(Color.RED);
                }
                break;
        }
    }

    private void addPatologias(){
        boolean validacao = true;
        String nome = addPatologiaEdit.getText().toString();
        if (nome == null || nome.equals("")){
            addPatologiaEdit.setError("Campo Obrigatório");
        }

        if (validacao){
            Patologia patologia = new Patologia();
            patologia.setNome(nome);
            patologia.setAlunoID(aluno.getId());

            patologiaDao.insert(patologia);
            Toast.makeText(this, "Patologia Adicionada com Sucesso!", Toast.LENGTH_SHORT).show();

            adapter.setListaPatologias(patologiaDao._queryAluno_PatologiasAlunos(aluno.getId()));
        }
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:
//                onBackPressed();
//                Intent intent =  new Intent(this, InfoAlunoActivity.class);
//                intent.putExtra("alunoid", aluno.getId());
//                startActivity(intent);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int i, long l) {
        final Patologia patologia = (Patologia) adapterView.getItemAtPosition(i);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Excluir Patologia");
        builder.setMessage("Deseja realmente excluir a Patologia:");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                patologiaDao.deleteByKey(patologia.getId());
                list.remove(patologia.getId());
                adapter.notifyDataSetChanged();
                Intent intent = new Intent(getApplicationContext(), FichaOcorrenciaActivity.class);
                intent.putExtra("alunoid", aluno.getId());
                intent.putExtra("patologiaid", patologia.getId());
                startActivity(intent);
            }
        });
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialog = builder.create();
        alertDialog.show();

        return true;
    }
}

package com.example.mriogalvojnior.tap4personal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.DivisaoTreino;
import com.example.mriogalvojnior.tap4personal.gen.Patologia;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.DaoSession;
import com.example.mriogalvojnior.tap4personal.gen.dao.DivisaoTreinoDao;
import com.github.clans.fab.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DivisaoTreinoActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, View.OnClickListener {

    private EditText gruposmuscularesEdit;
    private FloatingActionButton fabAddGruposMusculares;
    private Spinner diassemanaSpinner;
    private AlunoDao alunoDao;
    private DivisaoTreinoDao divisaoTreinoDao;
    private Aluno aluno;
    private RelativeLayout rlOptions;
    private TextView txtOptions;
    private long getIDAluno;
    private String semana;
    private LinearLayout llADDOptions;
    private DivisaoTreinoAdapter adapter;
    private ListView listView;
    private List<DivisaoTreino> list;
    private AlertDialog alertDialog;
    private Toolbar toolbar;
    private TextView textView;
    private ImageView imageView;
    private FloatingActionButton fabWpp, fabEmail;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisao_treino_activiity);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        DaoSession daoSession = application.getNewDBSession();

        alunoDao = daoSession.getAlunoDao();
        divisaoTreinoDao = daoSession.getDivisaoTreinoDao();

        getIDAluno = getIntent().getExtras().getLong("alunoid");
        aluno = alunoDao.load(getIDAluno);

        gruposmuscularesEdit = (EditText) findViewById(R.id.edit_cad_gruposmusculares);
        fabAddGruposMusculares = (FloatingActionButton) findViewById(R.id.fab_add_gm);
        diassemanaSpinner = (Spinner) findViewById(R.id.spinner_diassemana);
        toolbar = (Toolbar) findViewById(R.id.toolbar_divisaotreino);
        textView = (TextView) findViewById(R.id.title_toolbar_divisaotreino);
        imageView = (ImageView) findViewById(R.id.iv_back_divisaotreino);
        txtOptions = (TextView) findViewById(R.id.textOptions);
        rlOptions = (RelativeLayout) findViewById(R.id.rloptions);
        llADDOptions = (LinearLayout) findViewById(R.id.llviewbutton);
        fabWpp = (FloatingActionButton) findViewById(R.id.fab_wpp_dv);
        fabEmail = (FloatingActionButton) findViewById(R.id.fab_email_dv);

        setSupportActionBar(toolbar);

        Typeface font2 = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");

        textView.setTypeface(font2);
        txtOptions.setTypeface(font2);

        imageView.setOnClickListener(this);
        txtOptions.setOnClickListener(this);
        fabWpp.setOnClickListener(this);
        fabEmail.setOnClickListener(this);

        List<String> diassemana = new ArrayList<>();
        diassemana.add("Segunda-Feira");
        diassemana.add("Terça-Feira");
        diassemana.add("Quarta-Feira");
        diassemana.add("Quinta-Feira");
        diassemana.add("Sexta-Feira");
        diassemana.add("Sábado");

        ArrayAdapter<String> diasAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diassemana);
        diassemanaSpinner.setAdapter(diasAdapter);
        diassemanaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                semana = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                semana = "";
            }
        });

        listView = (ListView) findViewById(R.id.listview_divisaotreino);
        list = divisaoTreinoDao.loadAll();
        adapter = new DivisaoTreinoAdapter(divisaoTreinoDao, this, list);
        adapter.setDivisaoTreino(aluno.getDivisaoTreinoAlunos());
        listView.setAdapter(adapter);

        fabAddGruposMusculares.setOnClickListener(this);

        listView.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        final DivisaoTreino divisaoTreino = (DivisaoTreino) adapterView.getItemAtPosition(i);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Excluir Divisão de Treino");
        builder.setMessage("Deseja realmente excluir a Divisão de Treino?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                divisaoTreinoDao.deleteByKey(divisaoTreino.getId());
                list.remove(divisaoTreino.getId());
                adapter.notifyDataSetChanged();
                Intent intent = new Intent(getApplicationContext(), DivisaoTreinoActivity.class);
                intent.putExtra("alunoid", aluno.getId());
                intent.putExtra("divisaoid", divisaoTreino.getId());
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_add_gm:
                cadDivisaoTreino();
                gruposmuscularesEdit.setText("");
                break;
            case R.id.textOptions:
                if (rlOptions.getVisibility() == View.GONE){
                    rlOptions.setVisibility(View.VISIBLE);
                    txtOptions.setTextColor(Color.BLUE);
                    txtOptions.setText("HIDE Options");
                    llADDOptions.setVisibility(View.VISIBLE);
                } else {
                    rlOptions.setVisibility(View.GONE);
                    txtOptions.setTextColor(Color.RED);
                    txtOptions.setText("SHOW Options");
                    llADDOptions.setVisibility(View.GONE);
                }
                break;
            case R.id.iv_back_divisaotreino:
                Intent intent =  new Intent(this, InfoAlunoActivity.class);
                intent.putExtra("alunoid", aluno.getId());
                startActivity(intent);
                break;
            case R.id.fab_wpp_dv:
                StringBuilder text1 = new StringBuilder("");
                text1.append("Divisão de Treinameno: \n\n");
                for (DivisaoTreino divisaoTreino : list) {
                    text1.append("- " + divisaoTreino.getDiadasemana().toString() + "\n\n");
                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    waIntent.setPackage("com.whatsapp");
                    waIntent.putExtra(Intent.EXTRA_TEXT, text1.toString());
                    startActivity(Intent.createChooser(waIntent, "Share with"));
                }
                break;
            case R.id.fab_email_dv:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{aluno.getEmail()});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Divisão de Treinamento.");
                StringBuilder text = new StringBuilder("");
                    for (DivisaoTreino d : list) {
                        text.append("- " + d.getDiadasemana().toString() + "\n\n");
                        intent.putExtra(Intent.EXTRA_TEXT, "Divisão de treino: " + "\n\n" + text.toString());
                }
                startActivity(Intent.createChooser(intent, "Chooser Email:"));
                break;
        }
    }

    private void cadDivisaoTreino(){
        boolean validacao = true;
        String divisao = diassemanaSpinner.getSelectedItem() +  ": " + gruposmuscularesEdit.getText().toString();

        if (validacao){
            DivisaoTreino divisaoTreino = new DivisaoTreino();
            divisaoTreino.setDiadasemana(divisao);
            divisaoTreino.setAlunoID(aluno.getId());

            divisaoTreinoDao.insert(divisaoTreino);
            Toast.makeText(this, "Divisão de Treino Cadastrada com Sucesso!", Toast.LENGTH_SHORT).show();
            adapter.setDivisaoTreino(divisaoTreinoDao._queryAluno_DivisaoTreinoAlunos(aluno.getId()));
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
}

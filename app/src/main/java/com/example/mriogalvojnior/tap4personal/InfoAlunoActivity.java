package com.example.mriogalvojnior.tap4personal;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.github.clans.fab.FloatingActionButton;

import java.lang.reflect.Type;

public class InfoAlunoActivity extends AppCompatActivity implements View.OnClickListener {

    private AlunoDao dao;
    private Aluno aluno;
    private TextView nome, idade, sexo, objetivo, email, phone, preco, data, historicoText, diasText, horasText, fichaocorrencia, divisaotreino;
    private long idAluno;
    private FloatingActionButton fabPhone, fabEmail, fabHistorico, fabFichadeOcorrencia, fabDivisaoTreino,
            fabDeleteAluno, fabRefresh;
    private Toolbar toolbar;
    private TextView textToolbar;
    private ImageView arrowBack;
    private LinearLayout llInformacoes;
    private RelativeLayout rlInformacoes;
    private TextView txtInformacoes, text1fichadeocorrencia, text2fichadeocorrencia, textdivisaodetreino, texthistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_aluno);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        dao = application.getNewDBSession().getAlunoDao();

        toolbar = (Toolbar) findViewById(R.id.toolbar_infoAlunos);
        textToolbar = (TextView) findViewById(R.id.title_toolbar_infoAlunos);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textToolbar.setTypeface(font);
        arrowBack = (ImageView) findViewById(R.id.iv_back_listaAlunos);
        arrowBack.setOnClickListener(this);
        text1fichadeocorrencia = (TextView) findViewById(R.id.textFichadeOcorrencia);
        text2fichadeocorrencia = (TextView) findViewById(R.id.text2FichadeOcorrencia);
        textdivisaodetreino = (TextView) findViewById(R.id.textDivisaodeTreino);
        texthistorico = (TextView) findViewById(R.id.textHistorico);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Informações");

        nome = (TextView) findViewById(R.id.text_nomeAluno);
        idade = (TextView) findViewById(R.id.text_idadeAluno);
        sexo = (TextView) findViewById(R.id.text_sexoAluno);
        objetivo = (TextView) findViewById(R.id.text_objetivoAluno);
        email = (TextView) findViewById(R.id.text_emailAluno);
        phone = (TextView) findViewById(R.id.text_phoneAluno);
        preco = (TextView) findViewById(R.id.text_precoAluno);
        data = (TextView) findViewById(R.id.text_dataAluno);
        fabHistorico = (FloatingActionButton) findViewById(R.id.ib_historico);
//        historicoText = (TextView) findViewById(R.id.textHistorico);
        fabPhone = (FloatingActionButton) findViewById(R.id.phone_infoaluno);
        fabEmail = (FloatingActionButton) findViewById(R.id.email_infoaluno);
        diasText = (TextView) findViewById(R.id.text_dias_semana);
        horasText = (TextView) findViewById(R.id.text_hora);
//        fichaocorrencia = (TextView) findViewById(R.id.textfichadeocorrencia);
        fabFichadeOcorrencia = (FloatingActionButton) findViewById(R.id.iv_fichaocorrencia_aluno);
//        divisaotreino = (TextView) findViewById(R.id.text_divisaotreino_aluno);
        fabDivisaoTreino = (FloatingActionButton) findViewById(R.id.iv_divisaotreino_aluno);
        fabDeleteAluno = (FloatingActionButton) findViewById(R.id.fab_delaluno);
        fabRefresh = (FloatingActionButton) findViewById(R.id.fab_attaluno);
        llInformacoes = (LinearLayout) findViewById(R.id.llinformacoes);
        rlInformacoes = (RelativeLayout) findViewById(R.id.rlinformacoes);
        txtInformacoes = (TextView) findViewById(R.id.txtInformacoes);

        llInformacoes.setOnClickListener(this);

        fabPhone.setOnClickListener(this);
        fabEmail.setOnClickListener(this);
        fabDeleteAluno.setOnClickListener(this);
        fabRefresh.setOnClickListener(this);

        idAluno = getIntent().getExtras().getLong("alunoid");
        aluno = dao.load(idAluno);

        aluno.getHistoricoAlunos();

        nome.setText(aluno.getNome());
        idade.setText(aluno.getIdade().toString() + " anos");
        sexo.setText(aluno.getSexo().toString());
        objetivo.setText(aluno.getObjetivo().toString());
        email.setText(aluno.getEmail().toString());
        phone.setText("092 " + aluno.getTelefone().toString());
        preco.setText("R$ " + aluno.getPreco().toString() + " reais");
        data.setText(aluno.getData().toString());
        diasText.setText(aluno.getDaysforweek().toString());
        horasText.setText(aluno.getHour().toString());

        fabEmail.setOnClickListener(this);
        fabPhone.setOnClickListener(this);
        fabHistorico.setOnClickListener(this);
        fabFichadeOcorrencia.setOnClickListener(this);
        fabDivisaoTreino.setOnClickListener(this);

        Typeface font2 = Typeface.createFromAsset(getAssets(), "roboto.ttf");
        nome.setTypeface(font);
        idade.setTypeface(font2);
        sexo.setTypeface(font2);
        objetivo.setTypeface(font2);
        email.setTypeface(font2);
        phone.setTypeface(font2);
        preco.setTypeface(font2);
        data.setTypeface(font2);
        diasText.setTypeface(font2);
        horasText.setTypeface(font2);
        text1fichadeocorrencia.setTypeface(font);
        text2fichadeocorrencia.setTypeface(font);
        textdivisaodetreino.setTypeface(font);
        texthistorico.setTypeface(font);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_infoaluno, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_delete:
//                dao.deleteByKey(aluno.getId());
//                startActivity(new Intent(this, ListaAlunosActivity.class));
//                Toast.makeText(this, "Aluno Removido com Sucesso!", Toast.LENGTH_SHORT).show();
//                return true;
//            case android.R.id.home:
//                onBackPressed();
//                startActivity(new Intent(this, ListaAlunosActivity.class));
//                finish();
//                return true;
//
//            case R.id.action_atualizar:
//                Intent intentAtualizar = new Intent(this, AtualizarAlunoActivity.class);
//                intentAtualizar.putExtra("alunoattid", aluno.getId());
//                startActivity(intentAtualizar);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.ib_historico:
                Intent intent1 = new Intent(this, HistoricoAlunoActivity.class);
                intent1.putExtra("alunoid", aluno.getId());
                startActivity(intent1);
                break;
            case R.id.phone_infoaluno:
                Intent phoneInfoIntent = new Intent(Intent.ACTION_DIAL);
                phoneInfoIntent.setData(Uri.parse("tel:" + phone.getText().toString()));
                startActivity(phoneInfoIntent);
                break;
            case R.id.email_infoaluno:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{aluno.getEmail()});
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, "Chooser Email:"));
                break;
            case R.id.iv_fichaocorrencia_aluno:
                Intent intent2 = new Intent(this, FichaOcorrenciaActivity.class);
                intent2.putExtra("alunoid", aluno.getId());
                startActivity(intent2);
                break;
            case R.id.iv_divisaotreino_aluno:
                Intent intentDivisaoTreino = new Intent(this, DivisaoTreinoActivity.class);
                intentDivisaoTreino.putExtra("alunoid", aluno.getId());
                startActivity(intentDivisaoTreino);
                break;
            case R.id.fab_delaluno:
                dao.deleteByKey(aluno.getId());
                startActivity(new Intent(this, ListaAlunosActivity.class));
                Toast.makeText(this, "Aluno Removido com Sucesso!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_back_listaAlunos:
                Intent intent3 = new Intent(this, ListaAlunosActivity.class);
                intent3.putExtra("alunoid", aluno.getId());
                startActivity(intent3);
                break;
            case R.id.fab_attaluno:
                Intent intentAtualizar = new Intent(this, AtualizarAlunoActivity.class);
                intentAtualizar.putExtra("alunoattid", aluno.getId());
                startActivity(intentAtualizar);
                break;
            case R.id.llinformacoes:
                if (rlInformacoes.getVisibility() == View.GONE){
                    rlInformacoes.setVisibility(View.VISIBLE);
                    txtInformacoes.setText("- Informações");
                } else{
                    rlInformacoes.setVisibility(View.GONE);
                    txtInformacoes.setText("+ Informaçoes");
                }
                break;
        }
    }
}

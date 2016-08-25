package com.example.mriogalvojnior.tap4personal.treinos;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.HistoricoAlunoActivity;
import com.example.mriogalvojnior.tap4personal.ListaAlunosActivity;
import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.Tap4PersonalApplication;
import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Histotico;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.DaoSession;
import com.example.mriogalvojnior.tap4personal.gen.dao.HistoticoDao;
import com.github.clans.fab.FloatingActionButton;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.List;

public class InfoHistoricoActivity extends AppCompatActivity implements View.OnClickListener {

    private HistoticoDao dao;
    private AlunoDao alunoDao;
    private Aluno aluno;
    private TextView data, peso, altura, bf, bracodireito, bracoesquerdo, coxadireita, coxaesquerda
            , pantudireita, pantesquerda, torax, abdomen, cintura, quadril, antebracodireito, antebracoesquerdo
            , subescapular, tricipital, peitora, abdominal, coxa, axilarmedio, suprailiaca, dorascutaneas;
    private long idHistorico, idAtleta;
    private Histotico historico;
    private FloatingActionButton fabMail, fabWapp;
    private Toolbar toolbar;
    private ImageView imageView;
    private TextView textView;
    private LinearLayout llperimetros, lldobras;
    private RelativeLayout rlshowperimentros, rlshowdobras;
    private FloatingActionButton fabDeleteHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_historico);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        DaoSession daoSession = application.getNewDBSession();

        toolbar = (Toolbar) findViewById(R.id.toolbar_infohitoricoAlunos);
        textView = (TextView) findViewById(R.id.title_toolbar_infohistAlunos);
        imageView = (ImageView) findViewById(R.id.iv_back_infohistAlunos);
        fabDeleteHistorico = (FloatingActionButton) findViewById(R.id.fabdeletehistorico);

        fabDeleteHistorico.setOnClickListener(this);
        imageView.setOnClickListener(this);

        Typeface font2 = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textView.setTypeface(font2);

        setSupportActionBar(toolbar);


        dao = daoSession.getHistoticoDao();
        alunoDao = daoSession.getAlunoDao();

        data = (TextView) findViewById(R.id.text_data_infohist);
        peso = (TextView) findViewById(R.id.text_peso_info_hist);
        altura = (TextView) findViewById(R.id.text_altura_info_hist);
        bf = (TextView) findViewById(R.id.text_bf_info_hist);
        bracodireito = (TextView) findViewById(R.id.text_bracodireito_infohistorico);
        bracoesquerdo = (TextView) findViewById(R.id.text_bracoesquerdo_infohistorico);
        coxadireita = (TextView) findViewById(R.id.text_coxadireita_infohistorico);
        coxaesquerda = (TextView) findViewById(R.id.text_coxaesquerda_infohistorico);
        pantudireita = (TextView) findViewById(R.id.text_pantudireita_infohistorico);
        pantesquerda = (TextView) findViewById(R.id.text_pantuesquerda_infohistorico);
        torax = (TextView) findViewById(R.id.text_torax_histo);
        abdomen = (TextView) findViewById(R.id.text_abdomen_histo);
        cintura = (TextView) findViewById(R.id.text_cintura_histo);
        quadril = (TextView) findViewById(R.id.text_quadril_histo);
        fabMail = (FloatingActionButton) findViewById(R.id.fab_email);
        fabWapp = (FloatingActionButton) findViewById(R.id.fab_wpp);
        antebracodireito = (TextView) findViewById(R.id.text_antebracodireito_infohistorico);
        antebracoesquerdo = (TextView) findViewById(R.id.text_antebracoesquerdo_infohistorico);
        subescapular = (TextView) findViewById(R.id.text_subescapular_histo);
        tricipital = (TextView) findViewById(R.id.text_tricipital_histo);
        axilarmedio = (TextView) findViewById(R.id.text_axilarmedio_histo);
        suprailiaca = (TextView) findViewById(R.id.text_suprailiaca_histo);
        peitora = (TextView) findViewById(R.id.text_peitoral_histo);
        abdominal = (TextView) findViewById(R.id.text_abdominal_histo);
        coxa = (TextView) findViewById(R.id.text_coxa_histo);
        dorascutaneas = (TextView) findViewById(R.id.text_dobrascutaneas_hist);
        llperimetros = (LinearLayout) findViewById(R.id.llperimetros);
        rlshowperimentros = (RelativeLayout) findViewById(R.id.rlshowperimetros);
        lldobras = (LinearLayout) findViewById(R.id.lldobracutaneasinfo);
        rlshowdobras = (RelativeLayout) findViewById(R.id.rlshowdobras);

        llperimetros.setOnClickListener(this);
        lldobras.setOnClickListener(this);


        fabMail.setOnClickListener(this);
        fabWapp.setOnClickListener(this);

        idHistorico = getIntent().getExtras().getLong("historicoid");
        historico = dao.load(idHistorico);

        idAtleta = getIntent().getExtras().getLong("alunoid");
        aluno = alunoDao.load(idAtleta);


        data.setText("Dia: " + historico.getData());
        peso.setText("Peso: " + historico.getPeso() + " kg");
        altura.setText("Altura: " + historico.getAltura()+ " cm");
        bf.setText("BF: " + historico.getBf() + "%");
        bracoesquerdo.setText("Braço esq: " + historico.getBracoesquerdo() + " cm");
        bracodireito.setText("Braço dir: " + historico.getBracodireito() + " cm");
        coxaesquerda.setText("Coxa esq: " + historico.getCoxaesquerda() + " cm");
        coxadireita.setText("Coxa dir: " + historico.getCoxadireita() + " cm");
        pantudireita.setText("Pants dir: " + historico.getPantdireita() + " cm");
        pantesquerda.setText("Pants esq: " + historico.getPantesquerda() + " cm");
        torax.setText("Toráx: " + historico.getTorax() + " cm");
        abdomen.setText("Andomen: " + historico.getAbdomen() + " cm");
        cintura.setText("Cintura: " + historico.getCintura() + " cm");
        quadril.setText("Quadril: " + historico.getQuadril() + " cm");
        antebracoesquerdo.setText("Antebraço esq: " + historico.getAntebracoesquerdo() + " cm");
        antebracodireito.setText("Antebraço dir: " + historico.getAntebracodireito() + " cm");
        suprailiaca.setText("Supra-Ilíaca: " + historico.getSuprailiaca() + " mm");
        subescapular.setText("Subescapular: " + historico.getSubescapular() + " mm");
        tricipital.setText("Tricipital: " + historico.getTricipital() + " mm");
        peitora.setText("Peitoral: " + historico.getPeitoral() + " mm");
        axilarmedio.setText("Axilar-Média: " + historico.getAxilarmedio() + " mm");
        abdominal.setText("Abdominal: " + historico.getAbdominal() + " mm");
        coxa.setText("Coxa: " + historico.getCoxa() + " mm");

        Typeface font = Typeface.createFromAsset(getAssets(), "roboto.ttf");
        data.setTypeface(font);
        peso.setTypeface(font);
        altura.setTypeface(font);
        bf.setTypeface(font);
        bracodireito.setTypeface(font);
        bracoesquerdo.setTypeface(font);
        coxadireita.setTypeface(font);
        coxaesquerda.setTypeface(font);
        pantudireita.setTypeface(font);
        pantesquerda.setTypeface(font);
        torax.setTypeface(font);
        abdomen.setTypeface(font);
        cintura.setTypeface(font);
        quadril.setTypeface(font);
        antebracodireito.setTypeface(font);
        antebracoesquerdo.setTypeface(font);
        subescapular.setTypeface(font);
        suprailiaca.setTypeface(font);
        abdominal.setTypeface(font);
        coxa.setTypeface(font);
        tricipital.setTypeface(font);
        axilarmedio.setTypeface(font);
        peitora.setTypeface(font);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_comp_del_historico, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:
//                onBackPressed();
//                finish();
//                return true;
//            case R.id.action_delete_hist:
//                dao.deleteByKey(historico.getId());
//                Intent intent =  new Intent(this, HistoricoAlunoActivity.class);
//                intent.putExtra("alunoid", aluno.getId());
//                startActivity(intent);
//                Toast.makeText(this, "Histórico Removido com Sucesso!", Toast.LENGTH_SHORT).show();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void compartilharHistorico() {
        StringBuilder text = new StringBuilder("");
        text.append("Histórico: \n\n");

            text.append("Dia: " + historico.getData().toString() +  "\n\n"
            + "Peso: " + historico.getPeso().toString() + " kg" + "\n"
            + "Altura: " + historico.getAltura().toString()+ " cm"  + "\n"
            + "BF: " + historico.getBf().toString()+ " %"  + "\n\n"
            + "Perímetros: " + "\n\n"
            + "Braço Direito: " + historico.getBracodireito().toString() + " cm" + "\n"
            + "Braço Esquerdo: " + historico.getBracoesquerdo().toString()+ " cm"  + "\n"
                    + "Antebraço Direito: " + historico.getAntebracodireito().toString() + " cm" + "\n"
                    + "Antebraço Esquerdo: " + historico.getAntebracoesquerdo().toString()+ " cm"  + "\n"
            + "Coxa Direita: " + historico.getCoxadireita().toString() + " cm" + "\n"
            + "Coxa Esquerda: " + historico.getCoxaesquerda().toString()+ " cm"  + "\n"
            + "Pantu Direita: " + historico.getPantdireita().toString()+ " cm"  + "\n"
            + "Pantu Esquerda: " + historico.getPantesquerda().toString() + " cm" + "\n"
            + "Toráx: " + historico.getTorax().toString() + " cm" + "\n"
            + "Abdomen: " + historico.getAbdomen().toString() + " cm" + "\n"
            + "Cintura: " + historico.getCintura().toString() + " cm" + "\n"
            + "Quadril: " + historico.getQuadril().toString() + " cm" + "\n\n"
            + "Dobras Cutâneas: " + "\n\n"
            + "Subescapular: " + historico.getSubescapular() + " mm" + "\n"
                    + "Tricipital: " + historico.getTricipital() + " mm" + "\n"
                    + "Peitoral: " + historico.getPeitoral() + " mm" + "\n"
                    + "Axilar-Média: " + historico.getAxilarmedio() + " mm" + "\n"
                    + "Supra-Ilíaca: " + historico.getSuprailiaca() + " mm" + "\n"
                    + "Abdominal: " + historico.getAbdominal() + " mm" + "\n"
                    + "Coxa: " + historico.getCoxa() + " mm" + "\n");

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            waIntent.setPackage("com.whatsapp");
            waIntent.putExtra(Intent.EXTRA_TEXT, text.toString());
            startActivity(Intent.createChooser(waIntent, "Share with"));
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.fab_email:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{aluno.getEmail()});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Histórico do dia: " + historico.getData().toString());
                intent.putExtra(Intent.EXTRA_TEXT, "Dia: " + historico.getData().toString() +  "\n\n"
                        + "Peso: " + historico.getPeso().toString() + "cm" + "\n"
                        + "Altura: " + historico.getAltura().toString()+ "cm"  + "\n"
                        + "BF: " + historico.getBf().toString()+ "cm"  + "\n\n"
                        + "Perímetros: " + "\n\n"
                        + "Braço Direito: " + historico.getBracodireito().toString() + "cm" + "\n"
                        + "Braço Esquerdo: " + historico.getBracoesquerdo().toString()+ "cm"  + "\n"
                        + "Antebraço Direito: " + historico.getAntebracodireito().toString() + " cm" + "\n"
                        + "Antebraço Esquerdo: " + historico.getAntebracoesquerdo().toString()+ " cm"  + "\n"
                        + "Coxa Direita: " + historico.getCoxadireita().toString() + "cm" + "\n"
                        + "Coxa Esquerda: " + historico.getCoxaesquerda().toString()+ "cm"  + "\n"
                        + "Pantu Direita: " + historico.getPantdireita().toString()+ "cm"  + "\n"
                        + "Pantu Esquerda: " + historico.getPantesquerda().toString() + "cm" + "\n"
                        + "Toráx: " + historico.getTorax().toString() + "cm" + "\n"
                        + "Abdomen: " + historico.getAbdomen().toString() + "cm" + "\n"
                        + "Cintura: " + historico.getCintura().toString() + "cm" + "\n"
                        + "Quadril: " + historico.getQuadril().toString() + "cm" + "\n\n"
                        + "Dobras Cutâneas: " + "\n\n"
                        + "Subescapular: " + historico.getSubescapular() + " mm" + "\n"
                        + "Tricipital: " + historico.getTricipital() + " mm" + "\n"
                        + "Peitoral: " + historico.getPeitoral() + " mm" + "\n"
                        + "Axilar-Média: " + historico.getAxilarmedio() + " mm" + "\n"
                        + "Supra-Ilíaca: " + historico.getSuprailiaca() + " mm" + "\n"
                        + "Abdominal: " + historico.getAbdominal() + " mm" + "\n"
                        + "Coxa: " + historico.getCoxa() + " mm" + "\n");
                startActivity(Intent.createChooser(intent, "Chooser Email:"));
                break;
            case R.id.fab_wpp:
                compartilharHistorico();
                break;
            case R.id.fabdeletehistorico:
                dao.deleteByKey(historico.getId());
                Intent intent2 =  new Intent(this, HistoricoAlunoActivity.class);
                intent2.putExtra("alunoid", aluno.getId());
                startActivity(intent2);
                Toast.makeText(this, "Histórico Removido com Sucesso!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_back_infohistAlunos:
                Intent intent1 = new Intent(this, HistoricoAlunoActivity.class);
                intent1.putExtra("alunoid", aluno.getId());
                intent1.putExtra("historicoid", historico.getId());
                startActivity(intent1);
                break;
            case R.id.llperimetros:
                if (rlshowperimentros.getVisibility() == View.GONE){
                    rlshowperimentros.setVisibility(View.VISIBLE);
                } else {
                    rlshowperimentros.setVisibility(View.GONE);
                }
                break;
            case R.id.lldobracutaneasinfo:
                if (rlshowdobras.getVisibility() == View.GONE){
                    rlshowdobras.setVisibility(View.VISIBLE);
                }else{
                    rlshowdobras.setVisibility(View.GONE);
                }
                break;
        }
    }
}

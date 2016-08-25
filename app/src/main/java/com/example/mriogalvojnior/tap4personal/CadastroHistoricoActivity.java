package com.example.mriogalvojnior.tap4personal;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Histotico;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.DaoSession;
import com.example.mriogalvojnior.tap4personal.gen.dao.HistoticoDao;
import com.github.clans.fab.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.Calendar;

public class CadastroHistoricoActivity extends AppCompatActivity implements View.OnClickListener {

    private HistoticoDao dao;
    private AlunoDao alunoDao;
    private EditText pesoEdit, alturaEdit, bfEdit, dataEdit, bracodireitoEdit, bracoesquerdoEdit
            , coxadireitaEdit, coxaesquerdaEdit, pantdireitaEdit, pantesquerdaEdit
            , toraxEdit, abdomenEdit, cinturaEdit, quadrilEdit, subescapularEdit, tricipitalEdit
            , peitoralEdit, axilarmediaEdit, suprailiacaEdit, abdominalEdit, coxaEdit, antebracodireitoEdit
            , antebracoesquerdoEdit;
    private TextView circunferenciasText, dobrascutaneasText;
    private long idAluno;
    private Aluno aluno;
    private HistoricoAlunoActivity activity;
    private ImageView ivData;
    private Toolbar toolbar;
    private TextView textView;
    private ImageView arrowBack;
    private FloatingActionButton fabCadHistorico;
    private int year, month, day;
    private DatePicker datePicker;
    private Calendar calendar;
    private LinearLayout llperimentos, llperimetrosadd, lldobras, lldobrasadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_historico);


        toolbar = (Toolbar) findViewById(R.id.toolbar_cadhitoricoAlunos);
        textView = (TextView) findViewById(R.id.title_toolbar_cadhistAlunos);
        arrowBack = (ImageView) findViewById(R.id.iv_back_cadhistAlunos);

        arrowBack.setOnClickListener(this);

        Typeface font2 = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textView.setTypeface(font2);
        setSupportActionBar(toolbar);

        pesoEdit = (EditText) findViewById(R.id.edit_peso_hist);
        alturaEdit = (EditText) findViewById(R.id.edit_altura_hist);
        bfEdit = (EditText) findViewById(R.id.edit_bf_hist);
        dataEdit = (EditText) findViewById(R.id.edit_data_historico);
        bracodireitoEdit = (EditText) findViewById(R.id.edit_braco_dir_cad);
        bracoesquerdoEdit = (EditText) findViewById(R.id.edit_braco_esq_cad);
        coxadireitaEdit = (EditText) findViewById(R.id.edit_perna_dir_cad);
        coxaesquerdaEdit = (EditText) findViewById(R.id.edit_perna_esq_cad);
        pantdireitaEdit = (EditText) findViewById(R.id.edit_pants_dir_cad);
        pantesquerdaEdit = (EditText) findViewById(R.id.edit_pants_esq_cad);
        toraxEdit = (EditText) findViewById(R.id.edit_torax_cad);
        abdomenEdit = (EditText) findViewById(R.id.edit_andomen_cad);
        cinturaEdit = (EditText) findViewById(R.id.edit_cintura_cad);
        quadrilEdit = (EditText) findViewById(R.id.edit_quadril_cad);
        circunferenciasText = (TextView) findViewById(R.id.text_cirunferencias);
        ivData = (ImageView) findViewById(R.id.iv_data_hist);
        subescapularEdit = (EditText) findViewById(R.id.edit_dc_subescapular);
        tricipitalEdit = (EditText) findViewById(R.id.edit_dc_tricipital);
        peitoralEdit = (EditText) findViewById(R.id.edit_dc_Peitoral);
        axilarmediaEdit = (EditText) findViewById(R.id.edit_dc_axilarmedia);
        suprailiacaEdit = (EditText) findViewById(R.id.edit_dc_Supra_iliaca);
        abdominalEdit = (EditText) findViewById(R.id.edit_dc_abdominal);
        coxaEdit = (EditText) findViewById(R.id.edit_dc_coxa);
        dobrascutaneasText = (TextView) findViewById(R.id.text_dobrascutaneas);
        antebracodireitoEdit = (EditText) findViewById(R.id.edit_antebraco_dir_cad);
        antebracoesquerdoEdit = (EditText) findViewById(R.id.edit_antebraco_esq_cad);
        fabCadHistorico = (FloatingActionButton) findViewById(R.id.fabcadHistorico);

        llperimentos = (LinearLayout) findViewById(R.id.ll_perimetros);
        llperimetrosadd = (LinearLayout) findViewById(R.id.llperimetrosadd);
        lldobras = (LinearLayout) findViewById(R.id.ll_dobrascutaneas);
        lldobrasadd = (LinearLayout) findViewById(R.id.lldobrasadd);

        llperimentos.setOnClickListener(this);
        lldobras.setOnClickListener(this);

        ivData.setOnClickListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        Typeface font = Typeface.createFromAsset(getAssets(), "roboto.ttf");
        circunferenciasText.setTypeface(font);
        dobrascutaneasText.setTypeface(font);

        idAluno = getIntent().getExtras().getLong("alunoid");


        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        DaoSession daoSession = application.getNewDBSession();

        dao = daoSession.getHistoticoDao();
        alunoDao = daoSession.getAlunoDao();

        aluno = alunoDao.load(idAluno);

        dataEdit.setOnClickListener(this);
        fabCadHistorico.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_data_hist:
                setDate(view);
                break;
            case R.id.fabcadHistorico:
                cadastrarHistotico();
                Intent intent = new Intent(this, HistoricoAlunoActivity.class);
                intent.putExtra("alunoid", aluno.getId());
                startActivity(intent);
                break;
            case R.id.iv_back_cadhistAlunos:
                Intent intent1 = new Intent(this, HistoricoAlunoActivity.class);
                intent1.putExtra("alunoid", aluno.getId());
                startActivity(intent1);
                break;
            case R.id.ll_perimetros:
                if (llperimetrosadd.getVisibility() == View.GONE){
                    llperimetrosadd.setVisibility(View.VISIBLE);
                }else{
                    llperimetrosadd.setVisibility(View.GONE);
            }
                break;
            case R.id.ll_dobrascutaneas:
                if (lldobrasadd.getVisibility() == View.GONE){
                    lldobrasadd.setVisibility(View.VISIBLE);
                }else{
                    lldobrasadd.setVisibility(View.GONE);
                }
                break;
        }
    }

    public void cadastrarHistotico(){
        boolean validacao = true;
        String data = dataEdit.getText().toString();
        String peso = pesoEdit.getText().toString();
        String altura = alturaEdit.getText().toString();
        String bf = bfEdit.getText().toString();
        String bracodireito = bracodireitoEdit.getText().toString();
        String bracoesquerdo = bracoesquerdoEdit.getText().toString();
        String antebracodireito = antebracodireitoEdit.getText().toString();
        String antebracoesquerdo = antebracoesquerdoEdit.getText().toString();
        String coxadireita = coxadireitaEdit.getText().toString();
        String coxaesquerda = coxaesquerdaEdit.getText().toString();
        String pantdireita = pantdireitaEdit.getText().toString();
        String pantesquerda = pantesquerdaEdit.getText().toString();
        String torax = toraxEdit.getText().toString();
        String abdomen = abdomenEdit.getText().toString();
        String cintura = cinturaEdit.getText().toString();
        String quadril = quadrilEdit.getText().toString();
        String subescapular = subescapularEdit.getText().toString();
        String tricipital = tricipitalEdit.getText().toString();
        String peitoral = peitoralEdit.getText().toString();
        String axilarmedio = axilarmediaEdit.getText().toString();
        String suprailiaca = suprailiacaEdit.getText().toString();
        String abdominal = abdominalEdit.getText().toString();
        String coxa = coxaEdit.getText().toString();

        if (validacao){
            Histotico historico = new Histotico();
            historico.setData(data);
            historico.setPeso(peso);
            historico.setAltura(altura);
            historico.setBf(bf);
            historico.setBracodireito(bracodireito);
            historico.setBracoesquerdo(bracoesquerdo);
            historico.setAntebracodireito(antebracodireito);
            historico.setAntebracoesquerdo(antebracoesquerdo);
            historico.setCoxadireita(coxadireita);
            historico.setCoxaesquerda(coxaesquerda);
            historico.setPantdireita(pantdireita);
            historico.setPantesquerda(pantesquerda);
            historico.setTorax(torax);
            historico.setAbdomen(abdomen);
            historico.setCintura(cintura);
            historico.setQuadril(quadril);
            historico.setSubescapular(subescapular);
            historico.setTricipital(tricipital);
            historico.setPeitoral(peitoral);
            historico.setAxilarmedio(axilarmedio);
            historico.setSuprailiaca(suprailiaca);
            historico.setAbdominal(abdominal);
            historico.setCoxa(coxa);
            historico.setAlunoID(aluno.getId());

            dao.insert(historico);
            Toast.makeText(this, "Historico Adicionado com Sucesso", Toast.LENGTH_SHORT).show();

        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_atualizar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_done:
//                cadastrarHistotico();
//                Intent intent = new Intent(this, HistoricoAlunoActivity.class);
//                intent.putExtra("alunoid", aluno.getId());
//                startActivity(intent);
//                return true;
//            case android.R.id.home:
//                onBackPressed();
//                Intent intent1 = new Intent(this, HistoricoAlunoActivity.class);
//                intent1.putExtra("alunoid", aluno.getId());
//                startActivity(intent1);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new android.app.DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private android.app.DatePickerDialog.OnDateSetListener myDateListener = new android.app.DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showDate(i, i1+1, i2);
        }
    };


    private void showDate(int year, int month, int day) {
        dataEdit.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}

package com.example.mriogalvojnior.tap4personal;

import android.app.*;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.mriogalvojnior.tap4personal.R.id.title_toolbar_attinfoAlunos;

public class CadastroAlunosActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nomeEdt, idadeEdt,phoneEdt, emailEdt, precoEdt, dataEdt;
    private Button okButton;
    private Spinner objSpinner, sexoSpinner, diasSpinner, horasSpinner;
    private AlunoDao dao;
    private ImageView dataImage;
    private String obj, sex, days, hour;
    private Toolbar toolbar;
    private TextView textView;
    private FloatingActionButton fabaddAluno;
    private ImageView imageView;
    private int year, month, day;
    private DatePicker datePicker;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alunos);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        dao = application.getNewDBSession().getAlunoDao();

        toolbar = (Toolbar) findViewById(R.id.toolbar_attinfoAlunos);
        textView = (TextView) findViewById(R.id.title_toolbar_attinfoAlunos);
        imageView = (ImageView) findViewById(R.id.iv_back_attAlunos);

        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textView.setTypeface(font);
        setSupportActionBar(toolbar);

        imageView.setOnClickListener(this);

        nomeEdt = (EditText) findViewById(R.id.edit_nome);
        idadeEdt = (EditText) findViewById(R.id.edit_idade);
        phoneEdt = (EditText) findViewById(R.id.edit_phone);
        emailEdt = (EditText) findViewById(R.id.edit_email);
        precoEdt = (EditText) findViewById(R.id.edit_preco);
        dataEdt = (EditText) findViewById(R.id.edit_data);
        objSpinner = (Spinner) findViewById(R.id.spinner_obj);
        sexoSpinner = (Spinner) findViewById(R.id.spinner_sexo);
        okButton = (Button) findViewById(R.id.button_ok);
        dataImage = (ImageView) findViewById(R.id.iv_data);
        diasSpinner = (Spinner) findViewById(R.id.spinner_days_week);
        horasSpinner = (Spinner) findViewById(R.id.spinner_hour);
        fabaddAluno = (FloatingActionButton) findViewById(R.id.fab_attinfo_aluno);

        dataImage.setOnClickListener(this);
        fabaddAluno.setOnClickListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        okButton.setOnClickListener(this);
        dataEdt.setOnClickListener(this);

        okButton.setVisibility(View.GONE);

        List<String> objetivos = new ArrayList<>();
        objetivos.add("Condicionamento Físico");
        objetivos.add("Hipertrofia");
        objetivos.add("Emagrecimento");
        objetivos.add("Saúde e Qualidade de Vida");

        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, objetivos);
        objSpinner.setAdapter(objAdapter);
        objSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                obj = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                obj = "";
            }
        });

        List<String> sexo = new ArrayList<>();
        sexo.add("Masculino");
        sexo.add("Feminino");

        ArrayAdapter<String> sexoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sexo);
        sexoSpinner.setAdapter(sexoAdapter);
        sexoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sex = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sex = "";
            }
        });

        List<String> dias = new ArrayList<>();
        dias.add("Seg - Qua - Sex");
        dias.add("Ter - Qui - Sab");
        dias.add("Todos os dias");
        dias.add("4 vezes na semana");
        dias.add("Seg à Sex");
        dias.add("3 vezes na semana - Aleatóriamente");

        ArrayAdapter<String> diasAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dias);
        diasSpinner.setAdapter(diasAdapter);
        diasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                days = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                days = "";
            }
        });

        final List<String> horas = new ArrayList<>();
        horas.add("6:00 - 7:00");
        horas.add("7:00 - 8:00");
        horas.add("8:00 - 9:00");
        horas.add("9:00 - 10:00");
        horas.add("10:00 - 11:00");
        horas.add("11:00 - 12:00");
        horas.add("12:00 - 13:00");
        horas.add("13:00 - 14:00");
        horas.add("14:00 - 15:00");
        horas.add("15:00 - 16:00");
        horas.add("16:00 - 17:00");
        horas.add("17:00 - 18:00");
        horas.add("18:00 - 19:00");
        horas.add("19:00 - 20:00");
        horas.add("20:00 - 21:00");
        horas.add("21:00 - 22:00");
        horas.add("22:00 - 23:00");
        horas.add("23:00 - 24:00");

        ArrayAdapter<String> horasAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, horas);
        horasSpinner.setAdapter(horasAdapter);
        horasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hour = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                hour = "";
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_data:
                setDate(view);
                break;
            case R.id.iv_back_attAlunos:
                Intent intent = new Intent(this, ListaAlunosActivity.class);
                startActivity(intent);
                break;
            case R.id.fab_attinfo_aluno:
                cadastroAlunos();
                startActivity(new Intent(this, ListaAlunosActivity.class));
                break;
        }
    }

    public void cadastroAlunos(){

        boolean validacao = true;

        String nome = nomeEdt.getText().toString();
        String idade = idadeEdt.getText().toString();
        String sexo = sexoSpinner.getSelectedItem().toString();
        String obj = objSpinner.getSelectedItem().toString();
        String email = emailEdt.getText().toString();
        String phone = phoneEdt.getText().toString();
        String preco = precoEdt.getText().toString();
        String data = dataEdt.getText().toString();
        String dias = diasSpinner.getSelectedItem().toString();
        String horas = horasSpinner.getSelectedItem().toString();

        if (validacao){

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setIdade(idade);
            aluno.setSexo(sexo);
            aluno.setObjetivo(obj);
            aluno.setEmail(email);
            aluno.setPreco(preco);
            aluno.setTelefone(phone);
            aluno.setData(data);
            aluno.setDaysforweek(dias);
            aluno.setHour(horas);

            dao.insert(aluno);
            Toast.makeText(this, "Aluno Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
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
//                cadastroAlunos();
//                startActivity(new Intent(this, ListaAlunosActivity.class));
//                return true;
//            case android.R.id.home:
//                onBackPressed();
//                finish();
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
            return new DatePickerDialog(this, myDateListener, year, month, day);
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
        dataEdt.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}

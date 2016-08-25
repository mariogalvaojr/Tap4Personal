package com.example.mriogalvojnior.tap4personal;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AtualizarAlunoActivity extends AppCompatActivity implements View.OnClickListener, GetDateListener  {

    private AlunoDao dao;
    private Aluno aluno;
    private long idAlunoAtt;
    private Toolbar toolbar;
    private FloatingActionButton fabAtualizar;
    private TextView textView;
    private ImageView imageView;
    private EditText editNome, editIdade, editPhone, editPreco, editData, editEmail;
    private Spinner sexoSpinner, objetivoSpinner, diasSpinner, horaSpinner;
    private Button buttonOk;
    private DatePickerDialog dialog;
    private String sex, obj, days, hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alunos);

        Tap4PersonalApplication application = (Tap4PersonalApplication) getApplication();
        dao = application.getNewDBSession().getAlunoDao();

        toolbar = (Toolbar) findViewById(R.id.toolbar_attinfoAlunos);
        textView = (TextView) findViewById(R.id.title_toolbar_attinfoAlunos);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textView.setTypeface(font);
        imageView = (ImageView) findViewById(R.id.iv_back_attAlunos);
        imageView.setOnClickListener(this);

        setSupportActionBar(toolbar);

        editNome = (EditText) findViewById(R.id.edit_nome);
        editIdade = (EditText) findViewById(R.id.edit_idade);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editData = (EditText) findViewById(R.id.edit_data);
        editPhone = (EditText) findViewById(R.id.edit_phone);
        editPreco = (EditText) findViewById(R.id.edit_preco);
        sexoSpinner = (Spinner) findViewById(R.id.spinner_sexo);
        objetivoSpinner = (Spinner) findViewById(R.id.spinner_obj);
        buttonOk = (Button) findViewById(R.id.button_ok);
        diasSpinner = (Spinner) findViewById(R.id.spinner_days_week);
        horaSpinner = (Spinner) findViewById(R.id.spinner_hour);
        fabAtualizar = (FloatingActionButton) findViewById(R.id.fab_attinfo_aluno);

        buttonOk.setVisibility(View.GONE);

        buttonOk.setOnClickListener(this);
        editData.setOnClickListener(this);
        fabAtualizar.setOnClickListener(this);

        idAlunoAtt = getIntent().getExtras().getLong("alunoattid");
        aluno = dao.load(idAlunoAtt);

        aluno.getId();
        editNome.setText(aluno.getNome());
        editIdade.setText(aluno.getIdade());
        editEmail.setText(aluno.getEmail());
        editPreco.setText(aluno.getPreco());
        editData.setText(aluno.getData());
        editPhone.setText(aluno.getTelefone());

        List<String> objetivos = new ArrayList<>();
        objetivos.add("Condicionamento Físico");
        objetivos.add("Aumento da Massa Magra");
        objetivos.add("Emagrecimento");
        objetivos.add("Terapêutico");

        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, objetivos);
        objetivoSpinner.setAdapter(objAdapter);

        List<String> sexo = new ArrayList<>();
        sexo.add("Masculino");
        sexo.add("Feminino");

        ArrayAdapter<String> sexoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sexo);
        sexoSpinner.setAdapter(sexoAdapter);

       objetivoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               obj = String.valueOf(aluno.getObjetivo());
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
                obj = "";
           }
       });

        sexoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sex = String.valueOf(aluno.getSexo());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sex = "";
            }
        });

        sexoSpinner.getSelectedItem();
        objetivoSpinner.getSelectedItem();

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
        horaSpinner.setAdapter(horasAdapter);
        horaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hour = String.valueOf(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                hour = "";
            }
        });

        List<String> dias = new ArrayList<>();
        dias.add("Seg - Qua - Sex");
        dias.add("Ter - Qui - Sab");
        dias.add("Todos os dias");
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

        for (int i = 0; i < sexoSpinner.getCount(); i++){
            if (sexoSpinner.getItemAtPosition(i).toString().equalsIgnoreCase(aluno.getSexo())){
                sexoSpinner.setSelection(i);
            }
        }

        for (int i = 0; i < objetivoSpinner.getCount(); i++){
            if (objetivoSpinner.getItemAtPosition(i).toString().equalsIgnoreCase(aluno.getObjetivo())){
                objetivoSpinner.setSelection(i);
            }
        }

        for (int i = 0; i < diasSpinner.getCount(); i++){
            if (diasSpinner.getItemAtPosition(i).toString().equalsIgnoreCase(aluno.getDaysforweek())){
                diasSpinner.setSelection(i);
            }
        }

        for (int i = 0; i < horaSpinner.getCount(); i++){
            if (horaSpinner.getItemAtPosition(i).toString().equalsIgnoreCase(aluno.getHour())){
                horaSpinner.setSelection(i);
            }
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_ok:
                if (aluno != null) {
                    aluno.setNome(editNome.getText().toString());
                    aluno.setIdade(editIdade.getText().toString());
                    aluno.setSexo(sexoSpinner.getSelectedItem().toString());
                    aluno.setEmail(editEmail.getText().toString());
                    aluno.setTelefone(editPhone.getText().toString());
                    aluno.setPreco(editPreco.getText().toString());
                    aluno.setObjetivo(objetivoSpinner.getSelectedItem().toString());
                    aluno.setData(editData.getText().toString());
                    dao.update(aluno);
                    Toast.makeText(this, "Aluno Atualizado com Sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, ListaAlunosActivity.class));
                } else {
                    Toast.makeText(this, "Aluno Ainda não Cadastrado!.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.edit_data:
                showDialogGetDateContrato();
                break;
            case R.id.iv_back_attAlunos:
                Intent intent = new Intent(this, InfoAlunoActivity.class);
                intent.putExtra("alunoid", aluno.getId());
                startActivity(intent);
                break;
            case R.id.fab_attinfo_aluno:
                if (aluno != null) {
                    aluno.setNome(editNome.getText().toString());
                    aluno.setIdade(editIdade.getText().toString());
                    aluno.setSexo(sexoSpinner.getSelectedItem().toString());
                    aluno.setEmail(editEmail.getText().toString());
                    aluno.setTelefone(editPhone.getText().toString());
                    aluno.setPreco(editPreco.getText().toString());
                    aluno.setObjetivo(objetivoSpinner.getSelectedItem().toString());
                    aluno.setData(editData.getText().toString());
                    aluno.setDaysforweek(diasSpinner.getSelectedItem().toString());
                    aluno.setHour(horaSpinner.getSelectedItem().toString());
                    dao.update(aluno);
                    Toast.makeText(this, "Aluno Atualizado com Sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, ListaAlunosActivity.class));
                } else {
                    Toast.makeText(this, "Aluno Ainda não Cadastrado!.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onDateContratoSelected(String datecontrato) {
        editData.setText(datecontrato);
        dialog.dismissAllowingStateLoss();
    }

    private void showDialogGetDateContrato() {
        dialog = new DatePickerDialog();
        dialog.setListener(this);
        dialog.setCancelable(true);
        dialog.show(this.getSupportFragmentManager(), DatePickerDialog.TAG);
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
//                if (aluno != null) {
//                    aluno.setNome(editNome.getText().toString());
//                    aluno.setIdade(editIdade.getText().toString());
//                    aluno.setSexo(sexoSpinner.getSelectedItem().toString());
//                    aluno.setEmail(editEmail.getText().toString());
//                    aluno.setTelefone(editPhone.getText().toString());
//                    aluno.setPreco(editPreco.getText().toString());
//                    aluno.setObjetivo(objetivoSpinner.getSelectedItem().toString());
//                    aluno.setData(editData.getText().toString());
//                    aluno.setDaysforweek(diasSpinner.getSelectedItem().toString());
//                    aluno.setHour(horaSpinner.getSelectedItem().toString());
//                    dao.update(aluno);
//                    Toast.makeText(this, "Aluno Atualizado com Sucesso!", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(this, ListaAlunosActivity.class));
//                } else {
//                    Toast.makeText(this, "Aluno Ainda não Cadastrado!.", Toast.LENGTH_SHORT).show();
//                }
//                return true;
//
//            case android.R.id.home:
//                onBackPressed();
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}

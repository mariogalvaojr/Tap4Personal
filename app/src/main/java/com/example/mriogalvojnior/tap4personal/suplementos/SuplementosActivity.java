package com.example.mriogalvojnior.tap4personal.suplementos;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.dietas.DietaAdapter;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.mriogalvojnior.tap4personal.R.id.sp_carbos;
import static com.example.mriogalvojnior.tap4personal.R.id.sp_hora_suplementos;
import static com.example.mriogalvojnior.tap4personal.R.id.sp_proteinas;
import static com.example.mriogalvojnior.tap4personal.R.id.sp_qtd_carbos;
import static com.example.mriogalvojnior.tap4personal.R.id.sp_qtd_proteinas;
import static com.example.mriogalvojnior.tap4personal.R.id.sp_suplementos;

public class SuplementosActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner suplementosSpinner, horaSpinner;
    private ListView lista_dietas;
    private FloatingActionButton fabAdd, fabLimpar, fabWpp, fabMail;
    private DietaAdapter adapter;
    private List<String> refs;
    private TextView suple;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suplementos_activity);

        suplementosSpinner = (Spinner) findViewById(R.id.sp_suplementos);
        horaSpinner = (Spinner) findViewById(R.id.sp_hora_suplementos);

        lista_dietas = (ListView) findViewById(R.id.list_dietas);

        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add_suplementos);
        fabLimpar = (FloatingActionButton) findViewById(R.id.fab_limpar);
        fabWpp = (FloatingActionButton) findViewById(R.id.fab_wppd);
        fabMail = (FloatingActionButton) findViewById(R.id.fab_emaild);
        suple = (TextView) findViewById(R.id.text_suplementos);

        Typeface font = Typeface.createFromAsset(getAssets(), "times.ttf");
        suple.setTypeface(font);


        fabAdd.setOnClickListener(this);
        fabLimpar.setOnClickListener(this);
        fabWpp.setOnClickListener(this);
        fabMail.setOnClickListener(this);

        getSupportActionBar().setTitle("Refeições");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        List<String> suplementos = new ArrayList<>();
        suplementos.add("");
        suplementos.add("Whey Protein");
        suplementos.add("BCAA");
        suplementos.add("Glutamina");
        suplementos.add("Vit C");
        suplementos.add("Omega 3");
        suplementos.add("Caseína");
        suplementos.add("Albumina");
        suplementos.add("Malto");
        suplementos.add("Waxy Maize");
        suplementos.add("Pré treino");
        suplementos.add("Termogênico");

        List<String> hora = new ArrayList<>();
        hora.add("");
        hora.add("Ao acordar");
        hora.add("Pre treino");
        hora.add("Pos treino");
        hora.add("Antes de dormir");
        hora.add("Na hora do almoço");

        ArrayAdapter<String> suplementosAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, suplementos);
        ArrayAdapter<String> horaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hora);

        suplementosSpinner.setAdapter(suplementosAdapter);
        horaSpinner.setAdapter(horaAdapter);

        refs = new ArrayList<>();
        adapter = new DietaAdapter(refs, this);
        adapter.refeicoes(refs);
        lista_dietas.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.fab_add_suplementos:
                    refs.add("Suplementação " + i + ": \n" + suplementosSpinner.getSelectedItem().toString() + " - " + horaSpinner.getSelectedItem().toString() + "\n");
                    adapter.refeicoes(refs);
                    i++;
                break;
            case R.id.fab_limpar:
                refs.clear();
                adapter.refeicoes(refs);
                break;
            case R.id.fab_wppd:
                compartilharDieta();
                break;
            case R.id.fab_emaild:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, "");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Dieta");
                List<String> texto = new ArrayList<>();
                List<String> lista = refs;
                for (String p : lista) {
                    texto.add(p + "\n\n");
                }
                intent.putExtra(Intent.EXTRA_TEXT, String.valueOf(texto));
                startActivity(Intent.createChooser(intent, "Chooser Email:"));
                break;
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_comp, menu);
//        return true;
//    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
//            case R.id.action_comp:
//                compartilharDieta();
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void compartilharDieta() {
        StringBuilder text = new StringBuilder("");
        List<String> list = refs;
        text.append("Suplementação: \n\n");
        for (String p : list) {

            text.append(p + "\n\n");

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            waIntent.setPackage("com.whatsapp");
            waIntent.putExtra(Intent.EXTRA_TEXT, text.toString());
            startActivity(Intent.createChooser(waIntent, "Share with"));
        }
    }
}

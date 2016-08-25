package com.example.mriogalvojnior.tap4personal.dietas;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.R;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.mriogalvojnior.tap4personal.R.id.sp_carbos;
import static com.example.mriogalvojnior.tap4personal.R.id.sp_proteinas;
import static com.example.mriogalvojnior.tap4personal.R.id.sp_qtd_carbos;
import static com.example.mriogalvojnior.tap4personal.R.id.sp_qtd_proteinas;

public class DietasActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spnProteinas, spnQtdProteinas, spnCarboidratos, spnQtdCarboidratos;
    private ListView lista_dietas;
    private FloatingActionButton fabAdd, fabLimpar, fabWpp, fabMail;
    private DietaAdapter adapter;
    private List<String> refs;
    private TextView prot, carb;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietas);

        spnProteinas = (Spinner) findViewById(sp_proteinas);
        spnQtdProteinas = (Spinner) findViewById(sp_qtd_proteinas);
        spnCarboidratos = (Spinner) findViewById(sp_carbos);
        spnQtdCarboidratos = (Spinner) findViewById(sp_qtd_carbos);

        lista_dietas = (ListView) findViewById(R.id.list_dietas);

        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add_refeicao);
        fabLimpar = (FloatingActionButton) findViewById(R.id.fab_limpar);
        fabWpp = (FloatingActionButton) findViewById(R.id.fab_wppd);
        fabMail = (FloatingActionButton) findViewById(R.id.fab_emaild);
        prot = (TextView) findViewById(R.id.text_proteina);
        carb = (TextView) findViewById(R.id.text_caboidratos);

        Typeface font = Typeface.createFromAsset(getAssets(), "times.ttf");
        prot.setTypeface(font);
        carb.setTypeface(font);

        fabAdd.setOnClickListener(this);
        fabLimpar.setOnClickListener(this);
        fabWpp.setOnClickListener(this);
        fabMail.setOnClickListener(this);

        getSupportActionBar().setTitle("Refeições");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        List<String> proteinas = new ArrayList<>();
        proteinas.add("");
        proteinas.add("Filé de Peito de Frango");
        proteinas.add("Patinho Moido");
        proteinas.add("Alcatara");
        proteinas.add("Filé de Carne");
        proteinas.add("Salmão Grelhado");
        proteinas.add("Filé de Tilápia");
        proteinas.add("Filé de Aruanã");
        proteinas.add("Merluza");
        proteinas.add("Dourado");
        proteinas.add("Claras de Ovos");
        proteinas.add("Ovos Inteiros");

        List<String> carboidratos = new ArrayList<>();
        carboidratos.add("");
        carboidratos.add("Batata Doce");
        carboidratos.add("Cara");
        carboidratos.add("Macaxeira");
        carboidratos.add("Inhãme");
        carboidratos.add("Arroz Integral");
        carboidratos.add("Macarrão Integral");
        carboidratos.add("Macarrão Normal");
        carboidratos.add("Arroz Normal");
        carboidratos.add("Pão Integral");
        carboidratos.add("Aveia");


        List<String> qts = new ArrayList<>();
        qts.add("");
        qts.add("100g");
        qts.add("200g");
        qts.add("300g");
        qts.add("120g");
        qts.add("150g");
        qts.add("180g");
        qts.add("250g");
        qts.add("220g");
        qts.add("280g");

        ArrayAdapter<String> proteinasAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, proteinas);
        ArrayAdapter<String> carbosAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, carboidratos);
        ArrayAdapter<String> quantidades = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, qts);

        spnProteinas.setAdapter(proteinasAdapter);
        spnCarboidratos.setAdapter(carbosAdapter);
        spnQtdCarboidratos.setAdapter(quantidades);
        spnQtdProteinas.setAdapter(quantidades);

        refs = new ArrayList<>();
        adapter = new DietaAdapter(refs, this);
        adapter.refeicoes(refs);
        lista_dietas.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.fab_add_refeicao:
                    refs.add("Refeição " + i + ": \n" + spnProteinas.getSelectedItem().toString() + " - " + spnQtdProteinas.getSelectedItem().toString() + "\n"
                            + spnCarboidratos.getSelectedItem().toString() + " - " + spnQtdCarboidratos.getSelectedItem().toString());
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
        text.append("DIETA: \n\n");
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

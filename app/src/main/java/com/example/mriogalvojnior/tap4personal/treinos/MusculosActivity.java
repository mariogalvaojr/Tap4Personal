package com.example.mriogalvojnior.tap4personal.treinos;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mriogalvojnior.tap4personal.OptionsActivity;
import com.example.mriogalvojnior.tap4personal.R;

public class MusculosActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout peitoral, dorsal, biceps, triceps, abdomen, gluteos, panturrilhas, quads, femoral, delts;
    private TextView tPeitoral, tDorsal, tBiceps, tTriceps, tQuads, tFemoral, tDelts, tAbdomen, tGluteos, tPants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musculos);

        getSupportActionBar().setTitle("Grupos Musculares");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        peitoral = (LinearLayout) findViewById(R.id.ll_peitoral);
        dorsal = (LinearLayout) findViewById(R.id.ll_dorsal);
        biceps = (LinearLayout) findViewById(R.id.ll_biceps);
        triceps = (LinearLayout) findViewById(R.id.ll_triceps);
        quads = (LinearLayout) findViewById(R.id.ll_quads);
        femoral = (LinearLayout) findViewById(R.id.ll_femoral);
        abdomen = (LinearLayout) findViewById(R.id.ll_abdomen);
        gluteos = (LinearLayout) findViewById(R.id.ll_gluts);
        panturrilhas = (LinearLayout) findViewById(R.id.ll_pants);
        delts = (LinearLayout) findViewById(R.id.ll_delts);

        tPeitoral = (TextView) findViewById(R.id.txt_peitoral);
        tDorsal = (TextView) findViewById(R.id.txt_dorsal);
        tBiceps = (TextView) findViewById(R.id.txt_biceps);
        tTriceps = (TextView) findViewById(R.id.txt_triceps);
        tQuads = (TextView) findViewById(R.id.txt_quads);
        tFemoral = (TextView) findViewById(R.id.txt_femoral);
        tDelts = (TextView) findViewById(R.id.txt_delts);
        tAbdomen = (TextView) findViewById(R.id.txt_abdomen);
        tGluteos = (TextView) findViewById(R.id.txt_gluts);
        tPants = (TextView) findViewById(R.id.txt_pants);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "roboto.ttf");

        tPeitoral.setTypeface(typeface);
        tDorsal.setTypeface(typeface);
        tBiceps.setTypeface(typeface);
        tTriceps.setTypeface(typeface);
        tQuads.setTypeface(typeface);
        tFemoral.setTypeface(typeface);
        tDelts.setTypeface(typeface);
        tAbdomen.setTypeface(typeface);
        tGluteos.setTypeface(typeface);
        tPeitoral.setTypeface(typeface);
        tPants.setTypeface(typeface);


        peitoral.setOnClickListener(this);
        dorsal.setOnClickListener(this);
        quads.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                startActivity(new Intent(this, OptionsActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_peitoral:
                startActivity(new Intent(this, GrupoMuscularActivity.class));
                break;
            case R.id.ll_dorsal:
                startActivity(new Intent(this, DorsalActivity.class));
                break;
            case R.id.ll_quads:
                startActivity(new Intent(this, QuadricepsActivity.class));
                break;
        }
    }
}

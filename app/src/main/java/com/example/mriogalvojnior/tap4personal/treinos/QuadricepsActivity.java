package com.example.mriogalvojnior.tap4personal.treinos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mriogalvojnior.tap4personal.R;
import com.example.mriogalvojnior.tap4personal.treinos.adaptertreinos.DorsalAdapter;
import com.example.mriogalvojnior.tap4personal.treinos.adaptertreinos.QuadricepsAdapter;
import com.viewpagerindicator.PageIndicator;

import java.util.List;


public class QuadricepsActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager pager;
    private PageIndicator indicator;
    private QuadricepsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_muscular);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Exercícios de Quadriceps");

        pager = (ViewPager) findViewById(R.id.viewPager);
        indicator = (PageIndicator) findViewById(R.id.indicator);
        adapter = new QuadricepsAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_comp, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_comp:
                compartilharTreino();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void compartilharTreino() {
        StringBuilder text = new StringBuilder("");
        List<String> list = adapter.itensShare();
        int i = 1;
        text.append("TREINO DE QUADRICEPS: \n\n");
        for (String p : list) {

            text.append(i + ". " + p + "\n");

            i++;

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            waIntent.setPackage("com.whatsapp");
            waIntent.putExtra(Intent.EXTRA_TEXT, text.toString());
            startActivity(Intent.createChooser(waIntent, "Share with"));
        }
    }
}

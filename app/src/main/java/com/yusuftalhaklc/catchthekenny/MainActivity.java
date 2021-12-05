package com.yusuftalhaklc.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView scoreText;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText = findViewById(R.id.scoreText);
        final ImageButton kenny = (ImageButton) findViewById(R.id.kenny);
        final DisplayMetrics displaymetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Random rand = new Random();
                        final float dx = (rand.nextFloat() * displaymetrics.widthPixels);
                        final float dy = (rand.nextFloat() * displaymetrics.heightPixels);
                        final Timer timer = new Timer();
                        kenny.animate()
                                .x(dx)
                                .y(dy)
                                .setDuration(0)
                                .start();
                    }
                });
            }
        }, 0, 750);
    }
    public void catchedKenny(View view){
        score++;
        scoreText.setText("Score : "+score);
    }
}

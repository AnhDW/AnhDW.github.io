package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView tvScore,tvScoreOver,tvBestScore;
    public static RelativeLayout rlGameOver;
    public static Button btnStart;
    private GameView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(R.layout.activity_main);
        tvScore     = (TextView) findViewById(R.id.tv_score);
        tvBestScore = (TextView) findViewById(R.id.tv_best_score);
        tvScoreOver = (TextView) findViewById(R.id.tv_score_over);
        rlGameOver  = (RelativeLayout) findViewById(R.id.rl_game_over);
        btnStart    = (Button) findViewById(R.id.btn_start);
        gv          = (GameView) findViewById(R.id.gv);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setStart(true);
                tvScore.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.INVISIBLE);
            }
        });
        rlGameOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.VISIBLE);
                rlGameOver.setVisibility(View.INVISIBLE);
                gv.setStart(false);
                gv.reset();
            }
        });

    }
}
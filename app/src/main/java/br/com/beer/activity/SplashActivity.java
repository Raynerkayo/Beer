package br.com.beer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.com.beer.MainActivity;
import br.com.beer.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                carregarMainActivity();
            }
        }, 1500);

    }

    private void carregarMainActivity() {
        Intent intent = new Intent(
                SplashActivity.this, MainActivity.class
        );
        startActivity(intent);
        finish();
    }
}

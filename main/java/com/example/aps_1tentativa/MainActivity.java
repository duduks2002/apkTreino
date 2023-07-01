package com.example.aps_1tentativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int delay = 2000;
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                abrirInicio();
            }
        },delay);
    }

   /*função de mudar tela*/
    private void abrirInicio(){
        Intent intent = new Intent(MainActivity.this , TelaBotoes.class);
        startActivity(intent);
        finish();
    }

}
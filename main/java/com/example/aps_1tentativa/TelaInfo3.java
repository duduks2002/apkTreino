package com.example.aps_1tentativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TelaInfo3 extends AppCompatActivity {

    private ImageView Image;
    private ImageView Image2;
    private ImageButton btn_voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_info3);

        btn_voltar = findViewById(R.id.btn_voltar3);
        btn_voltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                abrirInicio();
            }
        });

       Image = findViewById(R.id.imageViewt3);
       Glide.with(this)
               .load("https://firebasestorage.googleapis.com/v0/b/aps-1tentativa-8ef24.appspot.com/o/nivel_3.2.jpg?alt=media&token=cd6d786d-5ae1-49c0-8a61-ab936f788448")
               .into(Image);

        Image2 = findViewById(R.id.imageViewt3_2);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/aps-1tentativa-8ef24.appspot.com/o/grafic_nvl3.jpg?alt=media&token=9908f631-95f8-4e1b-a626-28c237fdfc52")
                .into(Image2);
    }
    private void abrirInicio() {
        Intent intent = new Intent(TelaInfo3.this , TelaBotoes.class);
        startActivity(intent);
        finish();
    }
}
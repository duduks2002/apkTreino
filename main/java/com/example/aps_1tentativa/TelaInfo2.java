package com.example.aps_1tentativa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class TelaInfo2 extends AppCompatActivity {

    private ImageView Image;
    private ImageButton btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_info2);

        btn_voltar = findViewById(R.id.btn_voltar2);
        btn_voltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                abrirInicio();
            }
        });
    //   StorageReference storageRefeference = FirebaseStorage.getInstance().getReference();

        Image = findViewById(R.id.imageViewt2);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/aps-1tentativa-8ef24.appspot.com/o/nivel_2.2.jpg?alt=media&token=9fa1d802-3a02-4c31-bd78-f88b6aa39e96")
                .into(Image);
    }

    private void abrirInicio() {
        Intent intent = new Intent(TelaInfo2.this , TelaBotoes.class);
        startActivity(intent);
        finish();
    }

}
package com.example.aps_1tentativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class TelaInfos extends AppCompatActivity {

    ImageView rImage;
    ImageView rImage2;
    private ImageButton btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_infos);

        btn_voltar = findViewById(R.id.btn_voltar);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirInicio();
            }
        });

        StorageReference storageRefeference = FirebaseStorage.getInstance().getReference();
        rImage = findViewById(R.id.imageViewt1);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/aps-1tentativa-8ef24.appspot.com/o/nivel_1.2.jpg?alt=media&token=10d06ec7-f12f-44e5-a638-2e50930761e2")
                .into(rImage);

        StorageReference storageRefeference1 = FirebaseStorage.getInstance().getReference();

    }
    private void abrirInicio() {
        Intent intent = new Intent(TelaInfos.this , TelaBotoes.class);
        startActivity(intent);
        finish();
    }
}
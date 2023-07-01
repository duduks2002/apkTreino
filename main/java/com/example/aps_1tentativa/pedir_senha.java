package com.example.aps_1tentativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pedir_senha extends AppCompatActivity {

    private EditText edt_senha;
    private Button btn_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_senha);

        btn_senha = findViewById(R.id.btn_senha);
        btn_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_senha = findViewById(R.id.edt_senha);
                String senha = edt_senha.getText().toString();
            if (senha.equals("1234")){
                    abrirInicio();
                    alert( "Acesso permitido");
                }
            else{
                alert( "ACESSO NEGADO ");}
            }
        });
    }

    private void abrirInicio() {
        Intent intent = new Intent(pedir_senha.this, TelaInfo2.class);
        startActivity(intent);
        finish();
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
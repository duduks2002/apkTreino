package com.example.aps_1tentativa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class TelaBotoes extends AppCompatActivity {

    private Button btn_p1;
    private Button btn_p2;
    private Button btn_p3;
    private EditText senha;
    /*biometria*/
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    ConstraintLayout mMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_botoes);
        btn_p1 = findViewById(R.id.btn_p1);
        btn_p2 = findViewById(R.id.btn_p2);
        btn_p3 = findViewById(R.id.btn_p3);



        btn_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirp1();
            }
        });

        btn_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senha = findViewById(R.id.editTextTextPassword);
                senha.setVisibility(View.VISIBLE);
                String sen = senha.getText().toString();
                if (sen.equals("1234")){
                    abrirp2();
                    alert( "Acesso permitido");
                    if(!sen.equals("1234"))
                        alert( "ACESSO NEGADO ");
                }
                else{

                    alert( "DIGITE A SENHA");}
            }
        });
        /*-------------------------------------------------------------------------------------*/
        btn_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*biometria*/
                setContentView(R.layout.activity_biometria);
                mMainLayout = findViewById(R.id.bio_layout);

                Executor executor= ContextCompat.getMainExecutor(TelaBotoes.this);

                biometricPrompt = new BiometricPrompt(TelaBotoes.this, executor, new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);
                    }

                    @Override
                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);
                        Toast.makeText(getApplicationContext(),"ACESSO PERMITIDO",Toast.LENGTH_SHORT).show();

                        abrirp3();                                                                                  //REDIRECIONAMENTO DA BIOMETRIA
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                    }
                });

                promptInfo= new BiometricPrompt.PromptInfo.Builder().setTitle("Project_APS")
                        .setDescription("Use Digital para acessar").setDeviceCredentialAllowed(true).build();

                biometricPrompt.authenticate(promptInfo);

            }
        });
    }

    private void abrirp1() {
        Intent intent = new Intent(TelaBotoes.this , TelaInfos.class);
        startActivity(intent);
        finish();
    }
    private void abrirp2() {
        Intent intent = new Intent(TelaBotoes.this , TelaInfo2.class);
        startActivity(intent);
        finish();
    }
    private void abrirp3() {
        Intent intent = new Intent(TelaBotoes.this , TelaInfo3.class);
        startActivity(intent);
        finish();
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}
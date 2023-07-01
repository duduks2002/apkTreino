package com.example.aps_1tentativa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class Biometria extends AppCompatActivity {


    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    ConstraintLayout mMainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometria);

        mMainLayout = findViewById(R.id.bio_layout);
        Executor executor= ContextCompat.getMainExecutor(this);

       biometricPrompt = new BiometricPrompt(Biometria.this, executor, new BiometricPrompt.AuthenticationCallback() {
           @Override
           public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
               super.onAuthenticationError(errorCode, errString);
           }

           @Override
           public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
               super.onAuthenticationSucceeded(result);
               Toast.makeText(getApplicationContext(),"ACESSO PERMITIDO",Toast.LENGTH_SHORT).show();

               abrirInicio();                                                                                  //REDIRECIONAMENTO DA BIOMETRIA
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

    private void abrirInicio() {
        Intent intent = new Intent(Biometria.this , TelaInfo3.class);
        startActivity(intent);
        finish();
    }
}
package com.example.a360chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a360chatapp.R;
import com.example.a360chatapp.firebase.FirebaseUtil;

public class SplashScreen extends AppCompatActivity {
    private ImageView imagenLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cargarRecursosVista();
        cargarActivity();
    }
    private void cargarRecursosVista() {
        imagenLogo = findViewById(R.id.logo360chat);
        imagenLogo.setImageResource(R.drawable._60chat);
    }


    private void cargarActivity() {
        new Handler().postDelayed(() -> {
            if (FirebaseUtil.estaUsuarioLogeado()){
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            }else {
                startActivity(new Intent(SplashScreen.this, InicioSesionActivity.class));
            }
            finish();
        }, 2000);
    }
}
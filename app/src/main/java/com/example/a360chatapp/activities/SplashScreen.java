package com.example.a360chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a360chatapp.R;

public class SplashScreen extends AppCompatActivity {
    private ImageView imagenLogo;
    private TextView textoMensajeBienvenida;
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
        cargarImagenLogo();
        aplicarEfectoImagenLogo();
        cargarTextoBienvenidaVisibilidad();
        cargarActivityInicioApp();
    }
    private void cargarRecursosVista() {
        textoMensajeBienvenida = findViewById(R.id.textViewMensajeBienvenida);
        imagenLogo = findViewById(R.id.logo360chat);

    }
    private void cargarImagenLogo() {
        imagenLogo.setImageResource(R.drawable._60chat);
    }

    private void aplicarEfectoImagenLogo() {
        //Primero declaramos las variables que serán los puntos en el eje
        //x e y
        float fromScale = 0.5f,
                toScale = 1.0f,
                pivotX = imagenLogo.getWidth() / 2f,
                pivotY = imagenLogo.getHeight() / 2f;
        //Luego instanciamos el objeto ScaleAnimation con los valores.
        ScaleAnimation escalaAnimacion = new ScaleAnimation(
                fromScale, toScale,
                fromScale, toScale,
                pivotX, pivotY
        );
        animarImagenLogo(escalaAnimacion);
    }

    private void animarImagenLogo(ScaleAnimation escalaAnimacion) {
        escalaAnimacion.setDuration(1500);
        escalaAnimacion.setFillAfter(true);
        imagenLogo.startAnimation(escalaAnimacion);
    }

    private void cargarTextoBienvenidaVisibilidad() {
        new Handler().postDelayed(() ->
                textoMensajeBienvenida.setText("¡Bienvenido a 360 Chat App! ¡Tu aplicacion de mensajería rápida!"), 1500);
    }

    private void cargarActivityInicioApp() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 1650);
    }
}
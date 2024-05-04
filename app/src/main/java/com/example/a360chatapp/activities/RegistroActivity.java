package com.example.a360chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a360chatapp.R;
import com.example.a360chatapp.controllers.EmailController;
import com.example.a360chatapp.controllers.PasswordController;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextRepetirPassword;
    private Button btnRegistrarse;
    private Button btnVolverAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mAuth = FirebaseAuth.getInstance();
        cargarRecursosVista();
        cargarEventosBtn();
    }

    private void cargarRecursosVista(){
        //input
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRepetirPassword = findViewById(R.id.editTextRepetirPassword);
        //botones
        btnRegistrarse = findViewById(R.id.registrarButton);
        btnVolverAtras = findViewById(R.id.volverButton);
    }
    private void cargarEventosBtn() {
        btnRegistrarse.setOnClickListener(this::enviarFormulario);
        btnVolverAtras.setOnClickListener(this::cargarActivityInicioSesion);
    }
    private void enviarFormulario(View v) {
        String emailUsuario = editTextEmail.getText().toString();
        String passwordUsuario = editTextPassword.getText().toString();
        String passwordRepetirUsuario = editTextRepetirPassword.getText().toString();

        if (passwordUsuario.equals(passwordRepetirUsuario) &&
                EmailController.comprobarEmail(emailUsuario) &&
                PasswordController.comprobarPassword(passwordUsuario) &&
                PasswordController.comprobarPassword(passwordRepetirUsuario)) {

            crearNuevoUsuarioAuth( emailUsuario, passwordUsuario);

        } else {
            // mostrarMensajeAlerta("Datos incorrectos, vuelve a introducir los datos correctamente");
        }
    }

    private void cargarActivityInicioSesion(View view) {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, InicioSesionActivity.class);
            startActivity(intent);
            finish();
        }, 1000);
    }
    private void cargarActivityMain() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 1000);
    }
    private void crearNuevoUsuarioAuth(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            cargarActivityMain();
                        } else {
                            // If sign in fails, display a message to the user.
                           // Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                            //        Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }
}
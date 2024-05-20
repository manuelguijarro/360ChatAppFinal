package com.example.a360chatapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.a360chatapp.R;
import com.example.a360chatapp.activities.MainActivity;
import com.example.a360chatapp.activities.SplashScreen;
import com.example.a360chatapp.db.models.Usuario;
import com.example.a360chatapp.firebase.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;


public class PerfilFragment extends Fragment {
    private ImageView imagenPerfil;
    private EditText editTextNombreUsuario;
    private EditText editTextEmailUsuario;
    private ProgressBar progressBarPerfil;
    private Button btnActualizarPerfil;
    private TextView btnCerrarSesion;
    private Usuario usuario;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        cargarRecursosVista(view);
        cargarDatosUsuarioActual();
        cargarEventosBtn();
        return view;



    }

    private void cargarRecursosVista(View view) {
        //Imagen
        imagenPerfil = view.findViewById(R.id.imagen_usuario_perfil);
        //EditText
        editTextNombreUsuario = view.findViewById(R.id.nombre_usuario_perfil);
        editTextEmailUsuario = view.findViewById(R.id.email_usuario_perfil);
        //Boton
        btnActualizarPerfil = view.findViewById(R.id.btn_enviar_datos_perfil);
        //TextView -> Boton
        btnCerrarSesion = view.findViewById(R.id.cerrar_sesion_btn);
        //ProgressBar Perfil
        progressBarPerfil = view.findViewById(R.id.barra_progreso_perfil);
    }
    private void cargarEventosBtn() {
        btnActualizarPerfil.setOnClickListener(this::actualizarPerfilUsuario);
        btnCerrarSesion.setOnClickListener(this::cerrarSesionPerfilUsuario);
    }

    private void actualizarPerfilUsuario(View view) {
        String nuevoNombreUsuario = editTextNombreUsuario.getText().toString().trim();
        if (nuevoNombreUsuario.isEmpty() || 3 > nuevoNombreUsuario.length()){
            editTextNombreUsuario.setError("El nombre de usuario tiene que tener mínimo 3 caracteres");
            return;
        }
        usuario.setNombre(nuevoNombreUsuario);
        setEnProgreso(true);
        FirebaseUtil.obtenerDetallesUsuarioActual().set(usuario).addOnCompleteListener(task -> {
            setEnProgreso(false);
            if (task.isSuccessful()){
                //añadir que el usuario se aa ctualizado correctamente
            }else {
                //añadir que el usuario no se a actualizado correctamnete
            }
        });
    }

    private void cerrarSesionPerfilUsuario(View view){
        FirebaseUtil.cerrarSesion();
        Intent intent = new Intent(getContext(),SplashScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void cargarDatosUsuarioActual(){
        setEnProgreso(true);
        FirebaseUtil.obtenerDetallesUsuarioActual().get().addOnCompleteListener(task -> {
            setEnProgreso(false);
            usuario = task.getResult().toObject(Usuario.class);
            editTextNombreUsuario.setText(usuario.getNombre());
            editTextEmailUsuario.setText(usuario.getEmail());
        });
    }

    private void setEnProgreso(boolean enProgreso){
        if (enProgreso){
            progressBarPerfil.setVisibility(View.VISIBLE);
            btnActualizarPerfil.setVisibility(View.GONE);
        }else {
            progressBarPerfil.setVisibility(View.GONE);
            btnActualizarPerfil.setVisibility(View.VISIBLE);

        }
    }
}
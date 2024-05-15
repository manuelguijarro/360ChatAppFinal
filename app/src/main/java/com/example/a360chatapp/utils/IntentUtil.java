package com.example.a360chatapp.utils;

import android.content.Intent;

import com.example.a360chatapp.db.models.Usuario;

public class IntentUtil {

    public static void enviarUsuarioIntent(Intent intent, Usuario usuario){
        intent.putExtra("nombre",usuario.getNombre());
        intent.putExtra("email",usuario.getEmail());
        intent.putExtra("id",usuario.getId());

    }

    public static Usuario obtenerUsuarioIntent(Intent intent){
        Usuario usuario = new Usuario();
        usuario.setNombre(intent.getStringExtra("nombre"));
        usuario.setEmail(intent.getStringExtra("email"));
        usuario.setId(intent.getStringExtra("id"));

        return usuario;
    }
}

package com.example.a360chatapp.firebase;


import com.example.a360chatapp.db.models.Usuario;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtil {


    public static String obtenerUsuarioUid() {
        String usuarioUid = null;
        try {
            usuarioUid = FirebaseAuth.getInstance().getUid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioUid;
    }
    public static boolean estaUsuarioLogeado(){
        if (null != obtenerUsuarioUid()){
            return true;
        }else {
            return false;
        }
    }
    public static String obtenerUsuarioEmail() {
        String emailUsuario = "";
        try {
            emailUsuario = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emailUsuario;
    }

    public static DocumentReference obtenerDetallesUsuarioActual() {
        DocumentReference referenciaDocumentoUsuario = null;
        try {
            referenciaDocumentoUsuario = FirebaseFirestore.getInstance().collection("users").document(obtenerUsuarioUid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return referenciaDocumentoUsuario;
    }


}

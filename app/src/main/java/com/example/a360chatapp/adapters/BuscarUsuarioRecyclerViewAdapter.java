package com.example.a360chatapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a360chatapp.R;
import com.example.a360chatapp.db.models.Usuario;
import com.example.a360chatapp.firebase.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class BuscarUsuarioRecyclerViewAdapter extends FirestoreRecyclerAdapter<Usuario, BuscarUsuarioRecyclerViewAdapter.UsuarioViewHolder> {

    private Context context;

    public BuscarUsuarioRecyclerViewAdapter(@NonNull FirestoreRecyclerOptions<Usuario> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull UsuarioViewHolder usuarioViewHolder, int i, @NonNull Usuario usuario) {
        usuarioViewHolder.textViewNombreUsuario.setText(usuario.getNombre());
        usuarioViewHolder.textViewEmailUsuario.setText(usuario.getEmail());
        if(usuario.getId().equals(FirebaseUtil.obtenerUsuarioUid())){
            usuarioViewHolder.textViewNombreUsuario.setText(usuario.getNombre()+ "(Yo)");

        }

        usuarioViewHolder.itemView.setOnClickListener(v -> {
            //De aquí iremos al chat activity
        });
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.buscar_usuario_recycler_row, parent, false);
        return new UsuarioViewHolder(view);
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewNombreUsuario;
        private TextView textViewEmailUsuario;
        private ImageView imagenPerfil;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNombreUsuario = itemView.findViewById(R.id.nombre_usuario_text_view);
            textViewEmailUsuario = itemView.findViewById(R.id.email_usuario_text_view);
            imagenPerfil = itemView.findViewById(R.id.perfil_imagen_view);
        }
    }
}

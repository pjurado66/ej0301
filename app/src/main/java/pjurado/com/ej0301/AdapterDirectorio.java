package pjurado.com.ej0301;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



class AdapterDirectorio extends RecyclerView.Adapter<AdapterDirectorio.MyViewHolder>  {

    private ArrayList<Contacto> directorio;
    public AdapterDirectorio(ArrayList directorio){
        this.directorio = directorio;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent,  false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final MyViewHolder h = holder;
        holder.etNombre.setText(directorio.get(position).getNombre());
        holder.etTelefono.setText(directorio.get(position).getTelefono());
        holder.etEmail.setText(directorio.get(position).getEmail());
        holder.ivFoto.setImageResource(directorio.get(position).getFoto());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), IntentActivity.class);
                i.putExtra("persona", directorio.get(position));
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return directorio.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView etNombre;
        public TextView etTelefono;
        public TextView etEmail;
        public ImageView ivFoto;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            etNombre = mView.findViewById(R.id.textViewNombre);
            etTelefono = mView.findViewById(R.id.textViewTelefono);
            etEmail = mView.findViewById(R.id.textViewEmail);
            ivFoto = mView.findViewById(R.id.imageView);
        }
    }
}

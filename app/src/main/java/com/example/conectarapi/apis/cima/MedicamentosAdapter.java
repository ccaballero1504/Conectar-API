package com.example.conectarapi.apis.cima;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.conectarapi.R;

import java.util.List;

public class MedicamentosAdapter extends RecyclerView.Adapter<MedicamentosAdapter.ViewHolder> {

    private List<Medicamentos> listaMedicamentos;

    public MedicamentosAdapter(List<Medicamentos> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medicamento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medicamentos medicamento = listaMedicamentos.get(position);

        holder.tvNombre.setText(medicamento.getNombre());
        holder.tvRegistro.setText("Reg: " + medicamento.getnRegistro());

        // Manejo del booleano comerc
        if (medicamento.isComerc()) {
            holder.tvEstado.setText("Comercializado");
            holder.tvEstado.setTextColor(Color.GREEN);
        } else {
            holder.tvEstado.setText("No comercializado");
            holder.tvEstado.setTextColor(Color.RED);
        }

        String urlImagen = null;
        if(medicamento.getFotos()!=null && !medicamento.getFotos().isEmpty()){
            for (int i = 0; i<medicamento.getFotos().size(); i++){
                urlImagen = medicamento.getFotos().get(i).getUrl();
                break;
            }
            if (urlImagen==null){
                urlImagen = medicamento.getFotos().get(0).getUrl();
            }
        }

        Glide.with(holder.itemView.getContext()).load(urlImagen).centerInside().into(holder.ivMedicamento);
    }

    @Override
    public int getItemCount() {
        return listaMedicamentos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvRegistro, tvEstado;
        ImageView ivMedicamento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvRegistro = itemView.findViewById(R.id.tvRegistro);
            tvEstado = itemView.findViewById(R.id.tvEstado);
            ivMedicamento = itemView.findViewById(R.id.ivMedicamento);
        }
    }
}

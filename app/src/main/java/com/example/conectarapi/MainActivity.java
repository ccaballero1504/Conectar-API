package com.example.conectarapi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import com.example.conectarapi.apis.cima.ConexionCIMA;
import com.example.conectarapi.apis.cima.Medicamentos;
import com.example.conectarapi.apis.cima.MedicamentosAdapter;
import com.example.conectarapi.apis.cima.RespuestaCIMA;
import com.example.conectarapi.apis.cima.RetrofitCIMA;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conectarapi.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// ... tus imports actuales ...

public class MainActivity extends AppCompatActivity {

    Button botonBuscar;
    TextInputEditText texto;
    RecyclerView rvMedicamentos;
    MedicamentosAdapter adapter;
    // Es importante inicializar la lista aquí para que el adapter no reciba un null
    List<Medicamentos> listaMedicamentos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Vinculación de vistas
        botonBuscar = findViewById(R.id.buscar);
        texto = findViewById(R.id.nombre);
        rvMedicamentos = findViewById(R.id.rvMedicamentos);

        // 2. Configuración del RecyclerView
        rvMedicamentos.setLayoutManager(new LinearLayoutManager(this));

        // 3. INICIALIZACIÓN DEL ADAPTER (Esto faltaba)
        // Le pasamos la lista vacía que creamos arriba
        adapter = new MedicamentosAdapter(listaMedicamentos);
        rvMedicamentos.setAdapter(adapter);

        // 4. Evento Click
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreMedicamento = texto.getText().toString().trim();
                if (!nombreMedicamento.isEmpty()) {
                    realizarBusqueda(nombreMedicamento);
                } else {
                    texto.setError("Escribe un nombre");
                }
            }
        });
    }

    private void realizarBusqueda(String nombre) {
        RetrofitCIMA servicio = ConexionCIMA.getApiService();
        Call<RespuestaCIMA> llamada = servicio.buscarMedicamentos(nombre);

        llamada.enqueue(new Callback<RespuestaCIMA>() {
            @Override
            public void onResponse(Call<RespuestaCIMA> call, Response<RespuestaCIMA> response) {
                if(response.isSuccessful() && response.body() != null) {
                    // Aquí extraes la lista del objeto respuesta
                    List<Medicamentos> listaDeApi = response.body().getResultados();

                    if (listaDeApi != null) {
                        listaMedicamentos.clear();
                        listaMedicamentos.addAll(listaDeApi);
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaCIMA> call, Throwable t) {
                Snackbar.make(botonBuscar, "Error: " + t.getMessage(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
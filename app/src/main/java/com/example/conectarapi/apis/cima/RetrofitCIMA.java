package com.example.conectarapi.apis.cima;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitCIMA {

    @GET("medicamentos")
    Call<RespuestaCIMA> buscarMedicamentos(@Query("nombre") String nombreBuscado);

}

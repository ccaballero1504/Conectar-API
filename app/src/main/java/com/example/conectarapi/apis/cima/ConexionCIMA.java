package com.example.conectarapi.apis.cima;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConexionCIMA {

    private static final String URL = "https://cima.aemps.es/cima/rest/";
    private static Retrofit retrofit = null;

    public static RetrofitCIMA getApiService(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(RetrofitCIMA.class);
    }

}

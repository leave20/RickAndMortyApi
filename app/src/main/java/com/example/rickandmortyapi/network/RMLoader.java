package com.example.rickandmortyapi.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RMLoader {

    private static RMApi api;
    private static RMLoader Loader;
    private  final String URL_BASE="https://rickandmortyapi.com/api/";

    public static RMApi getApi() {
        if (Loader==null)
            Loader=new RMLoader();
        return api;
    }

    private RMLoader(){
        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api=retrofit.create(RMApi.class);
    }
}

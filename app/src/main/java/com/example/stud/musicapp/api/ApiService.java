package com.example.stud.musicapp.api;

import retrofit2.Retrofit;

/**
 * Created by W57015 on 2018-04-19.
 */

public class ApiService {

    public static ApiClient getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.theaudiodb.com/api/v1/json/{APIKEY}/")
                .build();

        return retrofit.create(ApiClient.class);
    }



}

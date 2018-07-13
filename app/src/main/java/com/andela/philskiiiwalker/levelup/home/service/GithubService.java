package com.andela.philskiiiwalker.levelup.home.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * This class represents the github service.
 */
public class GithubService {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://api.github.com/";

    // Create logger
    private static HttpLoggingInterceptor interceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    // Create OkHttp Client
    private static OkHttpClient client =
            new OkHttpClient.Builder().addInterceptor(interceptor).build();


    /**
     * This method creates a new instance of the API interface.
     * @return The API interface
     */
    public static GithubAPI getAPI() {

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(GithubAPI.class);
    }
}
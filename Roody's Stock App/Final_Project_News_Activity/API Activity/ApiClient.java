package com.fau_cop4655_Z23572422.mystockapppoc;

// Import retrofit2 class for the News API request
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    // Use the API from newsapi.org
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static ApiClient apiClient;
    private static Retrofit retrofit;

    private ApiClient(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){
        if (apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }


    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }
}

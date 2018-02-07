package com.dharmendra.redmart.models.apidata;

import com.dharmendra.redmart.models.pojos.ProductDetailsResponse;
import com.dharmendra.redmart.models.pojos.ProductResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dharmendra on 6/1/18.
 */

@Singleton
public class ApiManager implements ApiHelper {

    String BASE_URL = "https://api.redmart.com/v1.6.0/";

    @Inject
    ApiManager(){

    }

    @Singleton
    public ApiRequests getApiRequest() {
        return apiClient().create(ApiRequests.class);
    }

    @Singleton
    Retrofit apiClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


    @Override
    public Call<ProductResponse> getProducts(int page, int size) {
        return getApiRequest().getProducts(page,size);
    }

    @Override
    public Call<ProductDetailsResponse> getProductDetails(int id) {
        return getApiRequest().getProductDetails(id);
    }
}

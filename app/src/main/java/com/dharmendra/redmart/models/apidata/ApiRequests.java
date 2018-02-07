package com.dharmendra.redmart.models.apidata;

import com.dharmendra.redmart.models.pojos.Product;
import com.dharmendra.redmart.models.pojos.ProductDetailsResponse;
import com.dharmendra.redmart.models.pojos.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dharmendra on 6/1/18.
 */

public interface ApiRequests {

    @GET("catalog/search")
    Call<ProductResponse> getProducts(@Query("page") int page,@Query("pageSize") int size);

    @GET("catalog/products/{productId}")
    Call<ProductDetailsResponse> getProductDetails(@Path("productId") int id);

}

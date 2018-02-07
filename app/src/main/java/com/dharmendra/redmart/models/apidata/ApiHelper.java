package com.dharmendra.redmart.models.apidata;

import com.dharmendra.redmart.models.pojos.ProductDetailsResponse;
import com.dharmendra.redmart.models.pojos.ProductResponse;

import retrofit2.Call;

/**
 * Created by dharmendra on 6/1/18.
 */

public interface ApiHelper {

    Call<ProductResponse> getProducts(int page,int size);
    Call<ProductDetailsResponse> getProductDetails(int id);

}

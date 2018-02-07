package com.dharmendra.redmart.uis.main.list;

import android.util.Log;

import com.dharmendra.redmart.models.AppDataManager;
import com.dharmendra.redmart.models.DataHelper;
import com.dharmendra.redmart.models.apidata.ApiHelper;
import com.dharmendra.redmart.models.pojos.ProductResponse;
import com.dharmendra.redmart.uis.base.BaseActivityPresenter;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dharmendra on 6/1/18.
 */

public class ProductFragmentPresenter<V extends ProductListViewInteractor>
        extends BaseActivityPresenter<V> implements ProductListPresenter<V> {

    @Inject
    public ProductFragmentPresenter(ApiHelper dataHelper) {
        super(dataHelper);
    }

    @Override
    public void fetchProductData(int initial,int size) {

        getViewInteractor().showLoader();
        Call<ProductResponse> productsCall = getDataHelper().getProducts(initial,size);
        productsCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                getViewInteractor().dismissLoader();
                if(response.isSuccessful() && response.body()!=null) {
                    getViewInteractor().onProductResult(response.body().getProducts());
                }else{
                    getViewInteractor().showMessage("Unable to load products");
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Log.i("Faild","Failed");
                getViewInteractor().dismissLoader();
                getViewInteractor().showMessage("Failed to fetch data");
            }
        });
    }
}

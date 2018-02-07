package com.dharmendra.redmart.uis.main.details;

import com.dharmendra.redmart.models.DataHelper;
import com.dharmendra.redmart.models.apidata.ApiHelper;
import com.dharmendra.redmart.models.pojos.ProductDetailsResponse;
import com.dharmendra.redmart.uis.base.BaseActivityPresenter;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dharmendra on 6/1/18.
 */

public class ProductDetailsFragmentPresenter<V extends ProductDetailsViewInteractor>
        extends BaseActivityPresenter<V> implements ProductDetailsPresenter<V> {

    @Inject
    public ProductDetailsFragmentPresenter(ApiHelper dataHelper) {
        super(dataHelper);
    }

    @Override
    public void getProductDetails(int id) {
        getViewInteractor().showLoader();

        Call<ProductDetailsResponse> productDetailsCall = getDataHelper().getProductDetails(id);
        productDetailsCall.enqueue(new Callback<ProductDetailsResponse>() {
            @Override
            public void onResponse(Call<ProductDetailsResponse> call, Response<ProductDetailsResponse> response) {
                getViewInteractor().dismissLoader();
                if (response.isSuccessful() && response.body() != null)
                    getViewInteractor().onProductDetails(response.body());
                else getViewInteractor().showMessage("Failed to load data");
            }

            @Override
            public void onFailure(Call<ProductDetailsResponse> call, Throwable t) {
                getViewInteractor().onError("Failed to load data");
            }
        });
    }
}

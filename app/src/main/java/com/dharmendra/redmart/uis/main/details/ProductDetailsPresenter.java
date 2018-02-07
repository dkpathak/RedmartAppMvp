package com.dharmendra.redmart.uis.main.details;

import com.dharmendra.redmart.uis.base.BasePresenter;

/**
 * Created by dharmendra on 6/1/18.
 */

public interface ProductDetailsPresenter<V extends ProductDetailsViewInteractor> extends BasePresenter<V> {

    void getProductDetails(int id);
}

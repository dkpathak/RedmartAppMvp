package com.dharmendra.redmart.uis.main.list;

import com.dharmendra.redmart.uis.base.BasePresenter;

/**
 * Created by dharmendra on 6/1/18.
 */

public interface ProductListPresenter<V extends ProductListViewInteractor> extends BasePresenter<V> {
    void fetchProductData(int start,int size);
}

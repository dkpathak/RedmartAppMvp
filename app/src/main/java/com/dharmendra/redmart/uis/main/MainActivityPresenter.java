package com.dharmendra.redmart.uis.main;

import com.dharmendra.redmart.models.AppDataManager;
import com.dharmendra.redmart.models.DataHelper;
import com.dharmendra.redmart.models.apidata.ApiHelper;
import com.dharmendra.redmart.models.pojos.ProductResponse;
import com.dharmendra.redmart.uis.base.BaseActivityPresenter;
import com.dharmendra.redmart.uis.base.BasePresenter;
import com.dharmendra.redmart.uis.base.ViewInteractor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dharmendra on 6/1/18.
 */

public class MainActivityPresenter<V extends MainViewInteractor> extends BaseActivityPresenter<V>
        implements MainPresenter<V> {

    @Inject
    public MainActivityPresenter(ApiHelper dataHelper) {
        super(dataHelper);
    }

}

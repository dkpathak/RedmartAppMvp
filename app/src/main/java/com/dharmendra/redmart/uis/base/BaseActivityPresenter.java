package com.dharmendra.redmart.uis.base;

import com.dharmendra.redmart.models.AppDataManager;
import com.dharmendra.redmart.models.DataHelper;
import com.dharmendra.redmart.models.apidata.ApiHelper;

import javax.inject.Inject;

/**
 * Created by dharmendra on 6/1/18.
 */

public class BaseActivityPresenter<V extends ViewInteractor> implements BasePresenter<V>{


    private ApiHelper mDataHelper;
    private V mViewInteractor;

    @Inject
    public BaseActivityPresenter(ApiHelper dataHelper) {
        this.mDataHelper = dataHelper;
    }

    @Override
    public void onAttach(V ViewInteractor) {
        this.mViewInteractor = ViewInteractor;
    }

    @Override
    public void onDetach() {
        mViewInteractor = null;
    }


    public ApiHelper getDataHelper() {
        return mDataHelper;
    }

    public V getViewInteractor() {
        return mViewInteractor;
    }
}

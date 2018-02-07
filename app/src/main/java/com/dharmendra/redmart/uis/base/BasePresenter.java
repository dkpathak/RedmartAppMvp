package com.dharmendra.redmart.uis.base;

/**
 * Created by dharmendra on 6/1/18.
 */

public interface BasePresenter<V extends ViewInteractor> {

    void onAttach(V ViewInteractor);
    void onDetach();
}

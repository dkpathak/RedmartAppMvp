package com.dharmendra.redmart.uis.base;

/**
 * Created by dharmendra on 6/1/18.
 */

public interface ViewInteractor {

    void onSuccess();

    void showLoader();

    void dismissLoader();

    void onError(String message);

    void showMessage(String message);

    boolean isConnected();

}

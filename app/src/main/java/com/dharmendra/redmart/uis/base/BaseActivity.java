package com.dharmendra.redmart.uis.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dharmendra.redmart.R;
import com.dharmendra.redmart.RedMartApp;
import com.dharmendra.redmart.dependency.component.ActivityComponent;
import com.dharmendra.redmart.dependency.component.DaggerActivityComponent;
import com.dharmendra.redmart.dependency.module.ActivityModule;
import com.dharmendra.redmart.utility.NetworkUtils;

import butterknife.Unbinder;

/**
 * Created by dharmendra on 6/1/18.
 */

public class BaseActivity extends AppCompatActivity implements ViewInteractor, BaseFragment.Callback {


    private ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((RedMartApp) getApplication()).getApplicationComponent())
                .build();
    }


    public ActivityComponent getmActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void showLoader() {
    }

    @Override
    public void dismissLoader() {
    }

    @Override
    public void onError(String message) {
        Snackbar.make(findViewById(R.id.container), message, BaseTransientBottomBar.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(findViewById(R.id.container), message, BaseTransientBottomBar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null)
            mUnBinder.unbind();
        mUnBinder = null;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public boolean isConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}

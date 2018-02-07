package com.dharmendra.redmart.uis.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.dharmendra.redmart.R;
import com.dharmendra.redmart.dependency.component.ActivityComponent;
import com.dharmendra.redmart.utility.CommonUtils;

import butterknife.Unbinder;

/**
 * Created by dharmendra on 6/1/18.
 */

public abstract class BaseFragment extends Fragment implements ViewInteractor {

    private BaseActivity mActivity;
    private Unbinder mUnBinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }


    @Override
    public void onSuccess() {

    }

    @Override
    public void showLoader() {
        if (getView() != null)
            getView().findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoader() {
        if (getView() != null)
            getView().findViewById(R.id.progressBar).setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }


    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public boolean isConnected() {
        if (mActivity != null) {
            return mActivity.isConnected();
        }
        return false;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }


    public ActivityComponent getActivityComponent() {
        if (mActivity != null) {
            return mActivity.getmActivityComponent();
        }
        return null;
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract void setUp(View view);

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}

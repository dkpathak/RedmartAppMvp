package com.dharmendra.redmart.dependency.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;


import com.dharmendra.redmart.dependency.ActivityContext;
import com.dharmendra.redmart.dependency.PerActivity;
import com.dharmendra.redmart.uis.main.MainActivityPresenter;
import com.dharmendra.redmart.uis.main.MainViewInteractor;
import com.dharmendra.redmart.uis.main.list.ProductFragmentPresenter;
import com.dharmendra.redmart.uis.main.list.ProductListAdapter;
import com.dharmendra.redmart.uis.main.list.ProductListPresenter;
import com.dharmendra.redmart.uis.main.list.ProductListViewInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dharmendra on 17/12/17.
 */

@Module
public class ActivityModule{
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }


    @Provides
    @PerActivity
    MainActivityPresenter<MainViewInteractor> provideMainPresenter(
            MainActivityPresenter<MainViewInteractor> presenter){
        return presenter;
    }

    @Provides
    ProductListPresenter<ProductListViewInteractor> provideProductFragmentPresenter(
            ProductFragmentPresenter<ProductListViewInteractor> presenter){
        return presenter;
    }

    @Provides
    ProductListAdapter provideProductListAdaptor(){
        return new ProductListAdapter();
    }

    @Provides
    GridLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new GridLayoutManager(activity,2);
    }

}

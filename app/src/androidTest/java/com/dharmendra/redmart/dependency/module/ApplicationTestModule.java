package com.dharmendra.redmart.dependency.module;

import android.app.Application;
import android.content.Context;

import com.dharmendra.redmart.dependency.ApplicationContext;
import com.dharmendra.redmart.models.apidata.ApiHelper;
import com.dharmendra.redmart.models.apidata.ApiManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dharmendra on 7/1/18.
 */

@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiManager appApiHelper) {
        return appApiHelper;
    }
}

package com.dharmendra.redmart.dependency.module;

import android.app.Application;
import android.content.Context;

import com.dharmendra.redmart.dependency.ApplicationContext;
import com.dharmendra.redmart.models.AppDataManager;
import com.dharmendra.redmart.models.DataHelper;
import com.dharmendra.redmart.models.apidata.ApiHelper;
import com.dharmendra.redmart.models.apidata.ApiManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dharmendra on 17/12/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
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

//    @Provides
//    @Singleton
//    DataHelper provideDataManager(AppDataManager appDataManager) {
//        return appDataManager;
//    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiManager appApiManager) {
        return appApiManager;
    }


}

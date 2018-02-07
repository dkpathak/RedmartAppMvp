package com.dharmendra.redmart.dependency.component;

import android.app.Application;
import android.content.Context;

import com.dharmendra.redmart.RedMartApp;
import com.dharmendra.redmart.dependency.ApplicationContext;
import com.dharmendra.redmart.dependency.module.ApplicationModule;
import com.dharmendra.redmart.models.DataHelper;
import com.dharmendra.redmart.models.apidata.ApiHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dharmendra on 6/1/18..
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(RedMartApp app);

    @ApplicationContext
    Context context();

    Application application();

    ApiHelper getDataManager();
}

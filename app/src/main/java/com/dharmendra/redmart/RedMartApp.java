package com.dharmendra.redmart;

import android.app.Application;

import com.dharmendra.redmart.dependency.component.ApplicationComponent;
import com.dharmendra.redmart.dependency.component.DaggerApplicationComponent;
import com.dharmendra.redmart.dependency.module.ApplicationModule;

/**
 * Created by dharmendra on 6/1/18.
 */

public class RedMartApp extends Application {

    ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }


    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent mApplicationComponent) {
        this.mApplicationComponent = mApplicationComponent;
    }
}

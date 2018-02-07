package com.dharmendra.redmart.dependency.component;


import com.dharmendra.redmart.dependency.PerActivity;
import com.dharmendra.redmart.dependency.module.ActivityModule;
import com.dharmendra.redmart.uis.main.MainActivity;
import com.dharmendra.redmart.uis.main.details.ProductDetailsFragment;
import com.dharmendra.redmart.uis.main.list.ProductListFragment;

import dagger.Component;

/**
 * Created by dharmendra on 6/1/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(ProductListFragment fragment);
    void inject(ProductDetailsFragment fragment);

}

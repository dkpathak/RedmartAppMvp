package com.dharmendra.redmart.dependency.component;

import com.dharmendra.redmart.dependency.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dharmendra on 7/1/18.
 */

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
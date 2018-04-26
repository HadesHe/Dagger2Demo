package com.example.zhanghehe.dagger2demo.di.component;

import com.example.zhanghehe.dagger2demo.MainActivity;
import com.example.zhanghehe.dagger2demo.di.PerActivity;
import com.example.zhanghehe.dagger2demo.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}

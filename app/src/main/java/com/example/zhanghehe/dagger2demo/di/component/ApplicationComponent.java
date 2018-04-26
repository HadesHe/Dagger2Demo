package com.example.zhanghehe.dagger2demo.di.component;


import android.app.Application;
import android.content.Context;

import com.example.zhanghehe.dagger2demo.DemoApplication;
import com.example.zhanghehe.dagger2demo.MainActivity;
import com.example.zhanghehe.dagger2demo.data.DataManager;
import com.example.zhanghehe.dagger2demo.data.DbHelper;
import com.example.zhanghehe.dagger2demo.data.SharedPrefsHelper;
import com.example.zhanghehe.dagger2demo.di.ApplicationContext;
import com.example.zhanghehe.dagger2demo.di.PerActivity;
import com.example.zhanghehe.dagger2demo.di.module.ActivityModule;
import com.example.zhanghehe.dagger2demo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();
}

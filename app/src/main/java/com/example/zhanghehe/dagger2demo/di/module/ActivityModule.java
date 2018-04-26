package com.example.zhanghehe.dagger2demo.di.module;

import android.app.Activity;
import android.content.Context;


import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity=activity;
    }

    @Provides
    Context provideContext(){
        return mActivity;
    }

    @Provides
    Activity providerActivity(){
        return mActivity;
    }
}

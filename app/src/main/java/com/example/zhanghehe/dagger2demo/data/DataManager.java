package com.example.zhanghehe.dagger2demo.data;

import android.content.Context;

import com.example.zhanghehe.dagger2demo.data.model.User;
import com.example.zhanghehe.dagger2demo.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper){
        mContext=context;
        mDbHelper=dbHelper;
        mSharedPrefsHelper=sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken){
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN,accessToken);
    }

    public String getAccessToken(){
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId){
        return mDbHelper.getUser(userId);
    }

}

package com.example.zhanghehe.dagger2demo;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zhanghehe.dagger2demo.data.DataManager;
import com.example.zhanghehe.dagger2demo.data.model.User;
import com.example.zhanghehe.dagger2demo.di.component.ActivityComponent;
import com.example.zhanghehe.dagger2demo.di.component.DaggerActivityComponent;
import com.example.zhanghehe.dagger2demo.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager mDataManager;
    private TextView mTvUserInfo;
    private TextView mTvAccessToken;
    private ActivityComponent activityComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mTvUserInfo=(TextView)findViewById(R.id.tv_user_info);
        mTvAccessToken=(TextView)findViewById(R.id.tv_access_token);
    }

    private ActivityComponent getActivityComponent() {
        if(activityComponent==null){
            activityComponent= DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASFFKJGKJGNJKGJKGKJGGKGKKGJ");
        String token=mDataManager.getAccessToken();
        if (token != null) {
            mTvAccessToken.setText(token);
        }
    }

    private void getUser() {
        User user=mDataManager.getUser(1L);
        mTvUserInfo.setText(user.toString());
    }

    private void createUser() {
        try {
            mDataManager.createUser(new User("Ali","1367,Gurdan,Haryana,India"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

package com.dharmendra.redmart.uis.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.dharmendra.redmart.R;
import com.dharmendra.redmart.uis.base.BaseActivity;
import com.dharmendra.redmart.uis.base.BaseFragment;
import com.dharmendra.redmart.uis.main.MainActivity;

import butterknife.ButterKnife;

/**
 * Created by dharmendra on 6/1/18.
 */

public class SplashActivity extends BaseActivity {

    private Handler handler;


    //For unit Test
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setUnBinder(ButterKnife.bind(this));
        handler = new Handler();
        handler.postDelayed(launcher,3000);
    }

    Runnable launcher = new Runnable() {
        @Override
        public void run() {
            launchMainActivity();
        }
    };

    private void launchMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(launcher);
    }
}

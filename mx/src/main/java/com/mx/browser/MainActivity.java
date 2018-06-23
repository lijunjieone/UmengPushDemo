package com.mx.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.message.IUmengCallback;
import com.umeng.message.PushAgent;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private Context mContext;

    private Button mAnalyticsButton;
    private Button mPushButton;
    private Button mShareButton;
    private Button mErrorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        initView();
    }

    private void initView() {
//        mAnalyticsButton = (Button) findViewById(R.id.um_analytics_entrance);
//        mAnalyticsButton.setOnClickListener(this);
        mPushButton = (Button) findViewById(R.id.um_push_entrance);
        mPushButton.setOnClickListener(this);
//        mShareButton = (Button) findViewById(R.id.um_share_entrance);
//        mShareButton.setOnClickListener(this);
//        mErrorButton = (Button) findViewById(R.id.um_error_entrance);
//        mErrorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
//            case R.id.um_analytics_entrance:
//                Intent intentCommon = new Intent(MainActivity.this, AnalyticsMainActivity.class);
//                MainActivity.this.startActivity(intentCommon);
//                break;
            case R.id.um_push_entrance:
                PushAgent.getInstance(this).disable(new IUmengCallback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplication(),"disable success!",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(String s, String s1) {
                        Toast.makeText(getApplication(),"disable success!,+1"+s+",s2="+s1,Toast.LENGTH_SHORT).show();
                    }
                });
//                Intent intentAnalytics = new Intent(MainActivity.this, com.mx.browser.push.MainActivity.class);
//                MainActivity.this.startActivity(intentAnalytics);
                break;
//            case R.id.um_share_entrance:
//                Intent intentShare = new Intent(MainActivity.this, HomeActivity.class);
//                MainActivity.this.startActivity(intentShare);
//                break;
//            case R.id.um_error_entrance:
//                Intent intentError = new Intent(MainActivity.this, ErrorActivity.class);
//                MainActivity.this.startActivity(intentError);
//                break;
        }
    }
}


package com.company.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.valueAnimatorBtn)
    Button valueAnimatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.customXmlBtn,R.id.swithBtn,R.id.valueAnimatorBtn,R.id.valueAnimInterpolatorBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.customXmlBtn:
                startActivity(new Intent(this,CustomXMLActivity.class));
                break;
            case R.id.swithBtn:
                startActivity(new Intent(this,CustomCodeActivity.class));
                break;
            case R.id.valueAnimatorBtn:
                startActivity(new Intent(this,ValueAnimationActivity.class));
                break;
            case R.id.valueAnimInterpolatorBtn:
                startActivity(new Intent(this,ValueAnimInterpolatorActivity.class));
                break;

        }


    }


}

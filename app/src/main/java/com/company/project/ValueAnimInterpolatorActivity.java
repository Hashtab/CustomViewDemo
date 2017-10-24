package com.company.project;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lijun
 * 时间: 2017/10/23 16:32
 * 邮箱: lijun@eims.com.cn
 * 描述：自定义插值器(ValueAnimator) demo界面
 */
public class ValueAnimInterpolatorActivity extends AppCompatActivity {

    @Bind(R.id.startAnimBtn)
    Button startAnimBtn;
    @Bind(R.id.cancelAnimBtn)
    Button cancelAnimBtn;
    @Bind(R.id.tv)
    TextView tv;

    private int tvTop;

    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valueanim_interpolator);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        tvTop=tv.getTop();
    }

    private ValueAnimator doOnAnimation(){
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,400);
        valueAnimator.setStartDelay(1000);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(4000);
        valueAnimator.setInterpolator(new BounceInterpolator());

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentVal=(Integer) animation.getAnimatedValue();
                tv.layout(tv.getLeft(),currentVal+tvTop,tv.getRight(),currentVal+tvTop+tv.getHeight());
            }
        });

        return valueAnimator;

    }

    @OnClick({R.id.startAnimBtn, R.id.cancelAnimBtn, R.id.tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.startAnimBtn:
                valueAnimator=doOnAnimation();
                valueAnimator.start();
                break;
            case R.id.cancelAnimBtn:
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.cancel();
                break;
            case R.id.tv:
                break;
        }
    }
}

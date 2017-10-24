package com.company.project;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lijun
 * 时间: 2017/10/23 10:36
 * 邮箱: lijun@eims.com.cn
 * 描述：ValueAnimation Demo
 */
public class ValueAnimationActivity extends AppCompatActivity {

    @Bind(R.id.startAnimBtn)
    Button startAnimBtn;
    @Bind(R.id.cancelAnimBtn)
    Button cancelAnimBtn;
    @Bind(R.id.tv)
    TextView tv;

    private int tvTop;

    private ValueAnimator repeatAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);
        ButterKnife.bind(this);
        initView();
        repeatAnimator=doOnAnimation();
    }

    private void initView(){
        tvTop=tv.getTop();
    }

    private ValueAnimator doOnAnimation(){
//        ValueAnimator repeatAnimator=new ValueAnimator();
//        repeatAnimator.ofInt(0,400);
        ValueAnimator repeatAnimator=ValueAnimator.ofInt(0,400);
        repeatAnimator.setRepeatMode(ValueAnimator.REVERSE);
        repeatAnimator.setRepeatCount(ValueAnimator.INFINITE);
        repeatAnimator.setDuration(4000);

        repeatAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentVal=(int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(),currentVal+tvTop,tv.getRight(),currentVal+tvTop+tv.getHeight());

            }
        });

        return repeatAnimator;

    }

    @OnClick({R.id.startAnimBtn, R.id.cancelAnimBtn, R.id.tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.startAnimBtn:
                //开始动画
//                ValueAnimator newAnimator=repeatAnimator.clone();
//                newAnimator.setStartDelay(1000);
//                newAnimator.start();
                repeatAnimator.start();
                break;
            case R.id.cancelAnimBtn:
                //取消动画
//                repeatAnimator.removeAllUpdateListeners();
                repeatAnimator.cancel();
                break;
            case R.id.tv:
                //点击弹Toast
                Toast.makeText(this,"Hello World!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

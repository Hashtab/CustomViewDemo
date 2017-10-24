package com.company.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lijun
 * 时间: 2017/10/20 15:10
 * 邮箱: lijun@eims.com.cn
 * 描述：代码生成alpha、scale、translate、rotate、set及插值器动画
 */
public class CustomCodeActivity extends AppCompatActivity {
    @Bind(R.id.alphaBtn)
    Button alphaBtn;
    @Bind(R.id.scaleBtn)
    Button scaleBtn;
    @Bind(R.id.rotateBtn)
    Button rotateBtn;
    @Bind(R.id.transBtn)
    Button transBtn;
    @Bind(R.id.setBtn)
    Button setBtn;
    @Bind(R.id.testView)
    View testView;

    private AlphaAnimation alphaAnimation;
    private ScaleAnimation scaleAnimation;
    private RotateAnimation rotateAnimation;
    private TranslateAnimation translateAnimation;
    private AnimationSet animationSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_code);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        alphaAnimation=new AlphaAnimation(1.0f,0.0f);
        scaleAnimation=new ScaleAnimation(0.0f,2.0f,0.0f,2.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation=new RotateAnimation(0.0f,650f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        translateAnimation=new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,80,Animation.ABSOLUTE,0,Animation.ABSOLUTE,80);

        animationSet=new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(translateAnimation);

        animationSet.setDuration(3000);

    }

    @OnClick({R.id.alphaBtn, R.id.scaleBtn, R.id.rotateBtn, R.id.transBtn, R.id.setBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alphaBtn:
                Animation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
                alphaAnimation.setDuration(3000);
                testView.startAnimation(alphaAnimation);
                break;
            case R.id.scaleBtn:
                Animation scaleAnimation=new ScaleAnimation(0.0f,2.0f,0.0f,2.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation.setDuration(3000);
                testView.startAnimation(scaleAnimation);
                break;
            case R.id.rotateBtn:
                Animation rotateAnimation=new RotateAnimation(0.0f,650f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(3000);
                testView.startAnimation(rotateAnimation);
                break;
            case R.id.transBtn:
                Animation translateAnimation=new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,80,Animation.ABSOLUTE,0,Animation.ABSOLUTE,80);
                translateAnimation.setDuration(3000);
                testView.startAnimation(translateAnimation);
                break;
            case R.id.setBtn:
                testView.startAnimation(animationSet);
                break;
        }
    }




}

package com.company.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lijun
 * 时间: 2017/10/23 16:05
 * 邮箱: lijun@eims.com.cn
 * 描述：XML生成alpha、scale、translate、rotate、set及插值器动画
 */
public class CustomXMLActivity extends AppCompatActivity{
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_xml);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.alphaBtn, R.id.scaleBtn, R.id.rotateBtn, R.id.transBtn,R.id.setBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alphaBtn:
                Animation alpha= AnimationUtils.loadAnimation(this,R.anim.alphaanim);
                testView.startAnimation(alpha);
                break;
            case R.id.scaleBtn:
                Animation scale= AnimationUtils.loadAnimation(this,R.anim.scaleanim);
                testView.startAnimation(scale);
                break;
            case R.id.rotateBtn:
                Animation rotate= AnimationUtils.loadAnimation(this,R.anim.rotateanim);
                testView.startAnimation(rotate);
                break;
            case R.id.transBtn:
                Animation translate= AnimationUtils.loadAnimation(this,R.anim.translateanim);
                testView.startAnimation(translate);
                break;
            case R.id.setBtn:
                Animation set=AnimationUtils.loadAnimation(this,R.anim.setanim);
                testView.startAnimation(set);
                break;
        }
    }

}

package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;

public class MainActivity extends AppCompatActivity {

    TextView  mTxt;
    ImageView mImg;
    private Animation mTopInAnim;
    private Animation mTopOutAnim;
    private Toolbar mToolbar;
    private View mView;
    private LinearLayout mLL;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMenuAnim();
        context = this;
        mTxt = findViewById(R.id.txt_hello_world);
        mImg = findViewById(R.id.imageView);
        mToolbar = findViewById(R.id.toolbar_t);
        mView = findViewById(R.id.view_t);
        mLL = findViewById(R.id.ll_t);
        mTxt.setText("abc");
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            Window window = this.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            attributes.flags |= flagTranslucentStatus;
                attributes.flags |= flagTranslucentNavigation;
            window.setAttributes(attributes);
        }
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_HIDE_BAR)
                .init();
        Glide.with(this)
                .load("https://c-ssl.duitang.com/uploads/item/201505/03/20150503221643_sVnGj.jpeg")
                .into(mImg);
    }

    public void showStatus(View view) {
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_SHOW_BAR)
                .statusBarView(R.id.view_t)
                .init();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            Window window = this.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            attributes.flags |= flagTranslucentStatus;
                attributes.flags |= flagTranslucentNavigation;
            window.setAttributes(attributes);
        }
        mLL.setVisibility(View.VISIBLE);
        mLL.startAnimation(mTopInAnim);
    }

    public void goneStatus(View view) {
        mLL.postDelayed(new Runnable() {
            @Override
            public void run() {
                gongStatuss();
            }
        }, 200);
        mLL.setVisibility(View.GONE);
        mLL.startAnimation(mTopOutAnim);
    }

    //初始化菜单动画
    private void initMenuAnim() {
        if (mTopInAnim != null) return;
        mTopInAnim = AnimationUtils.loadAnimation(this, R.anim.slide_top_in);
        mTopOutAnim = AnimationUtils.loadAnimation(this, R.anim.slide_top_out);
        mTopOutAnim.setDuration(200);

    }

    private void gongStatuss(){
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_HIDE_BAR)
                .init();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            Window window = this.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            attributes.flags |= flagTranslucentStatus;
                attributes.flags |= flagTranslucentNavigation;
            window.setAttributes(attributes);
        }
    }
}

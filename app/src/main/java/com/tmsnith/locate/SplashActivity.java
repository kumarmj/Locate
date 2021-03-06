package com.tmsnith.locate;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.Target;

public class SplashActivity extends AppCompatActivity {

    private static  final int TIME_SPLASH=5000;
    private ImageView image_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        image_splash = (ImageView) findViewById(R.id.image_splash);
        Target<GlideDrawable> into = Glide.with(SplashActivity.this).load(R.drawable.icon1).into(image_splash);
        ObjectAnimator flip = ObjectAnimator.ofFloat(image_splash, "rotationY", 360f, 0f);
        flip.setDuration(3000);
        flip.start();

        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,google_signin.class));
                finish();
            }
        },TIME_SPLASH);

    }

}

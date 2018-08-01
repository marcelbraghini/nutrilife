package com.marcel.nutrilife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Declaração da Imagem de Fundo
        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        //Crio a animação
        Animation animation = AnimationUtils.loadAnimation(getApplication(),R.anim.splash_animation);
        imageView.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(getApplicationContext(),Login.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}

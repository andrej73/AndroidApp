package com.example.ahoj;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimatedView extends AppCompatActivity {

    private static class Position {
        float x = 0.0F;
        float y = 0.0F;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        Position pos = new Position();

        ImageView animationView = findViewById(R.id.anim_view);

        calculations.local();

        ObjectAnimator[][] animators = new ObjectAnimator[2][GraphActivity.position.length];

        for (int i = 0; i < GraphActivity.position.length; i++) {

            pos.x = (float) GraphActivity.getPositionX(i);
            pos.y = (float) GraphActivity.getPositionY(i);

            @SuppressLint("Recycle") ObjectAnimator animX =
                    ObjectAnimator.ofFloat(animationView,"X", pos.x);

            animX.setInterpolator(new LinearInterpolator());
            animX.setDuration(25);

            @SuppressLint("Recycle") ObjectAnimator animY =
                    ObjectAnimator.ofFloat(animationView,"Y", -pos.y);

            animY.setInterpolator(new LinearInterpolator());
            animY.setDuration(25);

            animators[0][i] = animX;
            animators[1][i] = animY;
        }

        AnimatorSet animatorSetX = new AnimatorSet();
        AnimatorSet animatorSetY = new AnimatorSet();

        for (int i = 1; i < animators[0].length; i++){
            animatorSetX.play(animators[0][i]).after(animators[0][i-1]);
            animatorSetY.play(animators[1][i]).after(animators[1][i-1]);
        }

        animatorSetX.start();
        animatorSetY.start();
    }
}

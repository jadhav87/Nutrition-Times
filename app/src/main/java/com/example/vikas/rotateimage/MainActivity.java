package com.example.vikas.rotateimage;

import android.app.Fragment;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView bgImg;
    private ImageView imageLogo;
    private ImageView wheel;
    private ImageView angleCircleImg;

    private ImageView leftImageView;
    private ImageView rightImageView;

    private double mCurrAngle = 0;
    private double mPrevAngle = 0;
    ImageView bask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgImg = (ImageView)findViewById(R.id.imageView);
        imageLogo = (ImageView)findViewById(R.id.imageLogo);
        imageLogo.setVisibility(View.GONE);

        leftImageView = (ImageView)findViewById(R.id.leftImageView);
        rightImageView = (ImageView)findViewById(R.id.rightImageView);

        leftImageView.setVisibility(View.GONE);
        rightImageView.setVisibility(View.GONE);

        angleCircleImg = (ImageView)findViewById(R.id.angleCircleImg);
        angleCircleImg.setVisibility(View.GONE);
//        angleCircleImg.setVisibility(View.VISIBLE);

        wheel=(ImageView)findViewById(R.id.imageView_ring);
        wheel.setOnTouchListener(this);

        imageLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,MainFragment.class);
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        final float xc = wheel.getWidth() / 2;
        final float yc = wheel.getHeight() / 2;

        final float x = event.getX();
        final float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
//                wheel.clearAnimation();
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
//                Log.e("Angle",String.valueOf(mCurrAngle));
                break;
            }
            case MotionEvent.ACTION_MOVE: {

                angleCircleImg.setVisibility(View.VISIBLE);

                mPrevAngle = mCurrAngle;
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                animate(mPrevAngle, mCurrAngle, 0);

                System.out.println(mCurrAngle);
                Log.e("Angle",String.valueOf(mCurrAngle));
                break;
            }
            case MotionEvent.ACTION_UP : {

                angleCircleImg.setVisibility(View.GONE);

                if (mCurrAngle > 41 && mCurrAngle < 48){

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            wheel.setAlpha(0);
                            bgImg.setImageResource(R.drawable.image2);
        //                  wheel.setVisibility(View.GONE);
                            leftImageView.setVisibility(View.VISIBLE);
                            rightImageView.setVisibility(View.VISIBLE);

                            //-------------------- door open animation ---------------------------//
                            Animation animLeft = new TranslateAnimation(-50.0f, -1000.0f, 0.0f, 0.0f);
                            animLeft.setDuration(4000);
                            animLeft.setFillAfter(true);
                            animLeft.setAnimationListener(new Animation.AnimationListener()
                            {
                                @Override public void onAnimationStart(Animation animation)
                                {
                                }

                                @Override public void onAnimationEnd(Animation animation)
                                {
                                    leftImageView.setVisibility(View.GONE);
                                    rightImageView.setVisibility(View.GONE);

                                    imageLogo.setVisibility(View.VISIBLE);
                                    Animation animFadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
                                    animFadeIn.reset();
                                    imageLogo.clearAnimation();
                                    imageLogo.startAnimation(animFadeIn);

                                }

                                @Override public void onAnimationRepeat(Animation animation)
                                {
                                }
                            });

                            Animation animRight = new TranslateAnimation(50.0f, 1000.0f, 0.0f, 0.0f);
                            animRight.setDuration(4000);
                            animRight.setFillAfter(true);

                            leftImageView.startAnimation(animLeft);
                            rightImageView.startAnimation(animRight);
                        }
                    }, 500);

                }else {
//                    Toast.makeText(getApplicationContext(),"Wrong Password",Toast.LENGTH_LONG).show();
                }

//                mPrevAngle = mCurrAngle = 0;

                Log.e("ACTION_UP","ACTION_UP");
                break;
            }
            /*case MotionEvent.ACTION_BUTTON_RELEASE: {
                Log.e("Release","ACTION_BUTTON_RELEASE");
            }*/
        }

        return true;
    }

    private void animate(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        wheel.startAnimation(rotate);
        System.out.println(mCurrAngle);
    }
}

//W110020242920
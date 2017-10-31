package com.example.vikas.rotateimage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by vikas on 18/08/17.
 */

public class MainFragment extends AppCompatActivity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;
    Fragment fragment;
    int index;
    private ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
        index = 1;
        // Detect touched area
        detector = new SimpleGestureFilter(this,this);

   /*     // get fragment manager
        FragmentManager fm = getFragmentManager();

        // add
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.your_placehodler, new YourFragment());
        // alternatively add it with a tag
        // trx.add(R.id.your_placehodler, new YourFragment(), "detail");
                ft.commit();

        // replace
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.your_placehodler, new YourFragment());
                ft.commit();

        // remove
                Fragment fragment = fm.findFragmentById(R.id.your_placehodler);
                FragmentTransaction ft = fm.beginTransaction();
                ft.remove(fragment);
                ft.commit();*/

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT :
                Log.e("Right",String.valueOf(index));
                if (index != 0){
                    index --;
                    if (index == 0){
                        ft.replace(R.id.fragment, new Page1Fragment());
                    }else if (index == 1){
                        ft.replace(R.id.fragment, new Page2Fragment());
                    }else if (index == 2){
                        ft.replace(R.id.fragment, new Page3Fragment());
                    }else if (index == 3){
                        ft.replace(R.id.fragment, new Page4Fragment());
                    }else if (index == 4){
                        ft.replace(R.id.fragment, new Page5Fragment());
                    }else if (index == 5){
                        ft.replace(R.id.fragment, new Page6Fragment());
                    }else if (index == 6){
                        ft.replace(R.id.fragment, new Page7Fragment());
                    }else if (index == 7){
                        ft.replace(R.id.fragment, new Page8Fragment());
                    }else if (index == 8){
                        ft.replace(R.id.fragment, new Page9Fragment());
                    }else if (index == 9){
                        ft.replace(R.id.fragment, new Page10Fragment());
                    }
                    ft.commit();
                }
                break;
            case SimpleGestureFilter.SWIPE_LEFT :
                if (index <= 9){

                    if (index == 0){
                        ft.replace(R.id.fragment, new Page1Fragment());
                        index ++;
                    }else if (index == 1){
                        Log.e("index one",String.valueOf(index));
                        ft.replace(R.id.fragment, new Page2Fragment());
                        index ++;
                    }else if (index == 2){
                        Log.e("index two",String.valueOf(index));
                        ft.replace(R.id.fragment, new Page3Fragment());
                        index ++;
                    }else if (index == 3){
                        Log.e("index three",String.valueOf(index));
                        ft.replace(R.id.fragment, new Page4Fragment());
                        index ++;
                    }else if (index == 4){
                        ft.replace(R.id.fragment, new Page5Fragment());
                        index ++;
                    }else if (index == 5){
                        ft.replace(R.id.fragment, new Page6Fragment());
                        index ++;
                    }else if (index == 6){
                        ft.replace(R.id.fragment, new Page7Fragment());
                        index ++;
                    }else if (index == 7){
                        ft.replace(R.id.fragment, new Page8Fragment());
                        index ++;
                    }else if (index == 8){
                        ft.replace(R.id.fragment, new Page9Fragment());
                        index ++;
                    }else if (index == 9){
                        ft.replace(R.id.fragment, new Page10Fragment());
                    }
                    ft.commit();
                    Log.e("Left",String.valueOf(index));
                }
                break;
            case SimpleGestureFilter.SWIPE_DOWN :  Log.e("SWIPE_DOWN","SWIPE_DOWN");
                break;
            case SimpleGestureFilter.SWIPE_UP :    Log.e("SWIPE_UP","SWIPE_UP");
                break;

        }

    }

    @Override
    public void onDoubleTap() {

    }

    public void gotoNext(){

    }
}

package com.example.vikas.rotateimage;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.emrekose.pinchzoom.Touch;

/**
 * Created by vikas on 18/08/17.
 */

public class Page1Fragment extends Fragment{

    ImageView pinchZoomImg;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page1,
                container, false);

        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        pinchZoomImg = (ImageView) view.findViewById(R.id.pg1_img);
//        pinchZoomImg.setOnTouchListener(new Touch());
    }
    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

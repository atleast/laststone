package com.atleast.laststone;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        float density = dm.density;
        float scaleDensity = dm.scaledDensity;
        int densityDPI = dm.densityDpi;
        float xDPI = dm.xdpi;
        float yDPI = dm.ydpi;


//        WindowManager wm = this.getWindowManager();
//        int width = wm.getDefaultDisplay().getWidth();
//        int height = wm.getDefaultDisplay().getHeight();

        System.out.println("Window width = " + width + " and height = " + height + " Density = " + density + " and DensityDPI = " + densityDPI + " xDPI = " + xDPI + " and yDPI = " + yDPI);

//        if( (width == 480) && (height == 800) ){
//
//            setContentView(R.layout.activity_startup_3_5);
//            System.out.println("Screen ratio: 3:5 (width == 480) && (height == 800)");
//
//        }else if((width == 640) && (height == 960)){
//
//            setContentView(R.layout.activity_startup_2_3);
//            System.out.println("Screen ratio: 2:3 (width == 640) && (height == 960)");
//
//        }else{
//
//            setContentView(R.layout.activity_startup_9_16);
//            System.out.println("Screen ratio: 9:16 (width == 1080) && (height == 1920)");
//
//        }

        //Creating layouts in code
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(200, 300);
        LinearLayout.LayoutParams textViewLP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams textViewLP1 = new LinearLayout.LayoutParams(240, 240);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
//        ll.setOrientation(LinearLayout.VERTICAL);

//        TextView myTextView = new TextView(this);
//        myTextView.setBackgroundColor(Color.blue(255));
//        myTextView.setText("Hello, I am created in code^_^");

        ImageButton imageButton1 = new ImageButton(this);
        imageButton1.setImageResource(R.drawable.laststone);
        ImageButton imageButton2 = new ImageButton(this);
        imageButton2.setImageResource(R.drawable.laststone);
        ImageButton imageButton3 = new ImageButton(this);
        imageButton3.setImageResource(R.drawable.laststone);

//        ll.addView(myTextView, textViewLP1);
        ll.addView(imageButton1, textViewLP1);
        ll.addView(imageButton2, textViewLP1);
        ll.addView(imageButton3, textViewLP1);

//        this.addContentView(ll,lp);
        this.setContentView(ll,lp);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }
}

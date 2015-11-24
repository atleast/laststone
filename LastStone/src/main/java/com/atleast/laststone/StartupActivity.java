package com.atleast.laststone;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

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

        if( (width == 480) && (height == 800) ){

            setContentView(R.layout.activity_startup_3_5);
            System.out.println("Screen ratio: 3:5 (width == 480) && (height == 800)");

        }else if((width == 640) && (height == 960)){

            setContentView(R.layout.activity_startup_2_3);
            System.out.println("Screen ratio: 2:3 (width == 640) && (height == 960)");

        }else{

            setContentView(R.layout.activity_startup_9_16);
            System.out.println("Screen ratio: 9:16 (width == 1080) && (height == 1920)");

        }


        final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final View contentView = findViewById(R.id.fullscreen_content);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }
}

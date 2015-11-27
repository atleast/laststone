package com.atleast.laststone;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StartupActivity extends Activity {

    public  LinearLayout viewLinearLayout;
    public List<ImageButton> stones;
    public int stoneStatus[];
    public int removedNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取屏幕分辨率等信息
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        float density = dm.density;
        float scaleDensity = dm.scaledDensity;
        int densityDPI = dm.densityDpi;
        float xDPI = dm.xdpi;
        float yDPI = dm.ydpi;

        //已过期的方法，不建议使用
//        WindowManager wm = this.getWindowManager();
//        int width = wm.getDefaultDisplay().getWidth();
//        int height = wm.getDefaultDisplay().getHeight();

        System.out.println("Window width = " + width + " and height = " + height + " Density = " + density + " and DensityDPI = " + densityDPI + " xDPI = " + xDPI + " and yDPI = " + yDPI);

        //根据不同的屏幕分辨率，设置不同的页面布局
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
        //New LinearLayoutParams for container view and subviews
        LinearLayout.LayoutParams viewLinearLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams buttonLinearLayoutParams = new LinearLayout.LayoutParams(getFitWidth(120),getFitHeight(120));
        buttonLinearLayoutParams.setMargins(getFitWidth(20),getFitHeight(300),getFitWidth(10),getFitHeight(30));
/*
        //Create subview TextView
        TextView myTextView = new TextView(this);
        myTextView.setBackgroundColor(Color.blue(255));
        myTextView.setText("Hello, I am created in code^_^");

        //Create subview ImageButtono
        ImageButton imageButton1 = new ImageButton(this);
        imageButton1.setImageResource(R.drawable.laststone);
        ImageButton imageButton2 = new ImageButton(this);
        imageButton2.setImageResource(R.drawable.laststone);
        ImageButton imageButton3 = new ImageButton(this);
        imageButton3.setImageResource(R.drawable.laststone);

        //New LinearLayout
        LinearLayout viewLinearLayout = new LinearLayout(this);
        viewLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        //Add subviews
        viewLinearLayout.addView(imageButton1, buttonLinearLayoutParams);
        viewLinearLayout.addView(myTextView, buttonLinearLayoutParams);
        viewLinearLayout.addView(imageButton2, buttonLinearLayoutParams);
        viewLinearLayout.addView(imageButton3, buttonLinearLayoutParams);
*/
        //New LinearLayout
        viewLinearLayout = new LinearLayout(this);
        viewLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        //Init array
        stones = new ArrayList<ImageButton>();
        stoneStatus = new int[6];

        //Init value
        for(int i = 0; i < 6; i++) {

            ImageButton stone = new ImageButton(this);
            stone.setImageResource(R.drawable.stone_0);
            stone.setId(i);
            stones.add(i, stone);
            stoneStatus[i] = 0;

            stones.get(i).setOnClickListener(btnClicked);
            viewLinearLayout.addView(stones.get(i), buttonLinearLayoutParams);

        }

        //Remove button
//        LinearLayout.LayoutParams removeButtonLinearLayoutParams = new LinearLayout.LayoutParams(getFitWidth(400),getFitHeight(120));
//        removeButtonLinearLayoutParams.setMargins(getFitWidth(340), getFitHeight(1500), getFitWidth(10), getFitHeight(30));

        ImageButton removeButton = new ImageButton(this);
        removeButton.setImageResource(R.drawable.laststone);
        removeButton.setOnClickListener(removeStone);
        viewLinearLayout.addView(removeButton, buttonLinearLayoutParams);

        //SetContentView
        this.setContentView(viewLinearLayout,viewLinearLayoutParams);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    int getFitWidth(int width){

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int ScreenWidth = dm.widthPixels;
        return (int) (width * ScreenWidth / 1080);
    }

    int getFitHeight(int height){

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int ScreenHeight = dm.heightPixels;

        return (int) (height * ScreenHeight / 1920);
    }

    View.OnClickListener btnClicked = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            System.out.println("ImageButton " + (view.getId() + 1) + " is clicked!");
            if(stoneStatus[view.getId()] == 0){

                stoneStatus[view.getId()] = 1;
                stones.get(view.getId()).setImageResource(R.drawable.stone_1);

            }else{

                stoneStatus[view.getId()] = 0;
                stones.get(view.getId()).setImageResource(R.drawable.stone_0);
            }
        }
    };

    View.OnClickListener removeStone = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            System.out.println("Removed button is clicked!");
            removedNum = 0;

            for(int i = 0; i < stoneStatus.length; i++){

                if(stoneStatus[i] == 1){
                    viewLinearLayout.removeView(stones.get(i));
                    removedNum++;
                }

            }

            if (removedNum == stoneStatus.length) {

                System.out.println("All stones are removed!");
            }

        }
    };
}

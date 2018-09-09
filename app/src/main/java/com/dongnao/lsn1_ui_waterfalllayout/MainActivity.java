package com.dongnao.lsn1_ui_waterfalllayout;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends com.lythonliu.LinkAppCompatActivity {
    private static int IMG_COUNT = 5;

    @Override
    public String getAppName(){
        return BuildConfig.APP_NAME;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WaterfallLayout waterfallLayout = ((WaterfallLayout)findViewById(R.id.waterfallLayout));
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addView(waterfallLayout);
            }
        });
    }

    public void addView(WaterfallLayout waterfallLayout) {


        Random random = new Random();
        Integer num = Math.abs(random.nextInt());
        WaterfallLayout.LayoutParams layoutParams = new WaterfallLayout.LayoutParams(
                WaterfallLayout.LayoutParams.MATCH_PARENT,
                WaterfallLayout.LayoutParams.MATCH_PARENT);
        /*WaterfallLayout.LayoutParams layoutParams = new WaterfallLayout.LayoutParams(
                100,
                100);*/
        ImageView imageView = new ImageView(this);
        if (num % IMG_COUNT == 0) {
            imageView.setImageResource(R.drawable.pic_1);
        } else if (num % IMG_COUNT == 1) {
            imageView.setImageResource(R.drawable.pic_2);
        } else if (num % IMG_COUNT == 2) {
            imageView.setImageResource(R.drawable.pic_3);
        } else if (num % IMG_COUNT == 3) {
            imageView.setImageResource(R.drawable.pic_4);
        } else if (num % IMG_COUNT == 4) {
            imageView.setImageResource(R.drawable.pic_5);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        waterfallLayout.addView(imageView, layoutParams);

        waterfallLayout.setOnItemClickListener(
                new WaterfallLayout.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int index) {
                        Toast.makeText(MainActivity.this, "item=" + index, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

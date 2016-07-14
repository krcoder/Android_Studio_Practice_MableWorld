package com.example.a90424.mableworld;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button but1;
    ImageView imageView;
    TextView textView,textView3;
    Matrix matrix;
    Bitmap myImg;
    Bitmap rotated;
    int roll,a;
    ImageView i1,i2,i3,i4,i5,i6,i7,i8;
    Toast toast;
    Handler handler = new Handler();

    int count=0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = (Button) findViewById(R.id.button2);
        but1.setOnClickListener(this);
        imageView = (ImageView)findViewById(R.id.imageView9);
        textView = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        matrix = new Matrix();
        myImg = BitmapFactory.decodeResource(getResources(), R.drawable.roll);
        i1 = (ImageView)findViewById(R.id.imageView1);
        i2 = (ImageView)findViewById(R.id.imageView2);
        i3 = (ImageView)findViewById(R.id.imageView3);
        i4 = (ImageView)findViewById(R.id.imageView4);
        i5 = (ImageView)findViewById(R.id.imageView5);
        i6 = (ImageView)findViewById(R.id.imageView6);
        i7 = (ImageView)findViewById(R.id.imageView7);
        i8 = (ImageView)findViewById(R.id.imageView8);


    }


    public void move(){
        //gi
    }
    @Override
    public void onClick(View view) {

        int b,i;

        matrix.postRotate(60);
        rotated = Bitmap.createBitmap(myImg, 0, 0, myImg.getWidth(), myImg.getHeight(), matrix, true);

        imageView.setImageBitmap(rotated);

        a = (int)(Math.random()*6)+1;
        textView.setText("주사위 ["+a+"] 나왔습니다");

        for(i=0;i<a;i++) {

            roll++;

            if (roll > 8) {
                roll = roll - 8;
            }

            i1.setImageResource(R.drawable.a1);
            i2.setImageResource(R.drawable.a2);
            i3.setImageResource(R.drawable.a3);
            i4.setImageResource(R.drawable.a4);
            i5.setImageResource(R.drawable.a5);
            i6.setImageResource(R.drawable.a6);
            i7.setImageResource(R.drawable.a7);
            i8.setImageResource(R.drawable.a8);


            switch (roll) {

                case 1:
                    i1.setImageResource(R.drawable.a1a);

                    break;
                case 2:
                    i2.setImageResource(R.drawable.a2a);

                    break;
                case 3:
                    i3.setImageResource(R.drawable.a3a);

                    break;
                case 4:
                    i4.setImageResource(R.drawable.a4a);

                    break;
                case 5:
                    i5.setImageResource(R.drawable.a5a);

                    break;
                case 6:
                    i6.setImageResource(R.drawable.a6a);

                    break;
                case 7:
                    i7.setImageResource(R.drawable.a7a);

                    break;
                case 8:
                    i8.setImageResource(R.drawable.a8a);

                    break;
            }

            handler.postDelayed(new Runnable() {

                public void run() {
                    move();
                }
            }, 500);
        }
        textView3.setText(a+"칸 이동하여 ["+roll+"]번 입니다");

    }
}

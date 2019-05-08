package com.test.oxiwyle;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class MainActivity extends AppCompatActivity {

    public ImageView imageView;
    Bitmap TheBitmap;
    public ImageView firstbutton;
    public ImageView twobutton;
    public ImageView threebutton;
    public ImageView fourbutton;
    public ImageView fivebutton;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        Glide.with(this).load(R.drawable.bg_main_2160x3840).into(imageView);


        firstbutton = (ImageView) findViewById(R.id.firstbutton);
        twobutton = (ImageView) findViewById(R.id.twobutton);
        threebutton = (ImageView) findViewById(R.id.threebutton);
        fourbutton = (ImageView) findViewById(R.id.fourbutton);
        fivebutton = (ImageView) findViewById(R.id.fivebutton);


        TheBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.first1);

        firstbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int eventPadTouch = event.getAction();
               /* int iY = 0;
                int iX = 0;*/

                int iX;
                int iY;

                 iX = (int) event.getX();
                 iY = (int) event.getY();

                switch (eventPadTouch) {

                    case MotionEvent.ACTION_DOWN:
                        if (iX>=0 & iY>=0 & iX<TheBitmap.getWidth() & iY<TheBitmap.getHeight()) {
                            // ** Makes sure that X and Y are not less than 0, and no more than the height and width of the image.
                            if (TheBitmap.getPixel(iX,iY)!=0) {
                                // * A non-alpha area was clicked, do something

                                Toast.makeText(MainActivity.this, "111111111111111", Toast.LENGTH_SHORT).show();
                                firstbutton.setImageResource(R.drawable.first2);


                            }

                        }
                        return true;




                }
                return false;

            }

        });



    }


}

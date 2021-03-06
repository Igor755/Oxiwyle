package com.test.oxiwyle;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    public ImageView imageView;
    public ImageView firstbutton;
    public ImageView twobutton;
    public ImageView threebutton;
    public ImageView fourbutton;
    public ImageView fivebutton;
    public TextView textView;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        Glide.with(this).load(R.drawable.bg_main_2160x3840).into(imageView);

        Typeface tf = Typeface.createFromAsset(getAssets(),
                "cyrillic_old.ttf");


        firstbutton = (ImageView) findViewById(R.id.firstbutton);
        twobutton = (ImageView) findViewById(R.id.twobutton);
        threebutton = (ImageView) findViewById(R.id.threebutton);
        fourbutton = (ImageView) findViewById(R.id.fourbutton);
        fivebutton = (ImageView) findViewById(R.id.fivebutton);
        textView = (TextView) findViewById(R.id.textview);

        textView.setTypeface(tf);



        firstbutton.setOnTouchListener(this);
        twobutton.setOnTouchListener(this);
        threebutton.setOnTouchListener(this);
        fourbutton.setOnTouchListener(this);
        fivebutton.setOnTouchListener(this);
    }

    public int getHotspotColor(int hotspotId, int x, int y) {


        ImageView imageView = (ImageView) findViewById(hotspotId);

        if (imageView == null) {
            Log.d("MainActivity", "Hot spot image not found");
            return 0;
        } else {
            imageView.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(imageView.getDrawingCache());
            if (hotspots == null || ((x < 1 || y < 1) || (x > hotspots.getWidth() || y > hotspots.getHeight()))) {
                Log.d("MainActivity", "Hot spot bitmap was not created");
                return 0;
            } else {
                imageView.setDrawingCacheEnabled(false);
                return hotspots.getPixel(x, y);
            }
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int eventPadTouch = event.getAction();
        boolean handledHere = false;
        final int evX = (int) event.getX();
        final int evY = (int) event.getY();


        int button = v.getId();
        String name;



                int touchColor1 = getHotspotColor(button, evX, evY);

                switch (eventPadTouch) {

                    case MotionEvent.ACTION_DOWN: {

                        ////&& Color.alpha(touchColor1) != Color.TRANSPARENT
                        ////проверяем на прозрачность 80% = 204

                        if (touchColor1 != 0 && Color.alpha(touchColor1)> 204) {
                            handledHere = true;
                            if (v.getId() == R.id.firstbutton){
                                firstbutton.setImageResource(R.drawable.first2);
                                Alert(name = "1");

                            }else if (v.getId() == R.id.twobutton){
                                twobutton.setImageResource(R.drawable.two2);
                                Alert(name = "2");

                            }else if (v.getId() == R.id.threebutton){
                                threebutton.setImageResource(R.drawable.three2);
                                Alert(name = "3");

                            }else if (v.getId() == R.id.fourbutton){
                                fourbutton.setImageResource(R.drawable.four2);
                                Alert(name = "4");

                            }else if (v.getId() == R.id.fivebutton){
                                fivebutton.setImageResource(R.drawable.five2);
                                Alert(name = "5");
                            }
                        }
                        break;

                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {

                        handledHere = true;
                        if (v.getId() == R.id.firstbutton) {
                            firstbutton.setImageResource(R.drawable.first1);
                        }else if (v.getId() == R.id.twobutton){
                            twobutton.setImageResource(R.drawable.two1);
                        }else if (v.getId() == R.id.threebutton){
                            threebutton.setImageResource(R.drawable.three1);
                        }else if (v.getId() == R.id.fourbutton){
                            fourbutton.setImageResource(R.drawable.four1);
                        }else if (v.getId() == R.id.fivebutton){
                            fivebutton.setImageResource(R.drawable.five1);
                        }
                        break;
                    }
                    default:
                        handledHere = false;
                        break;
                }
        return handledHere;
        }


        public void Alert(String name){

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.number)
                    .setMessage(MainActivity.this.getString(R.string.button) + " "  + name)
                    .setIcon(R.drawable.alarm)
                    .setCancelable(false)
                    .setNegativeButton(R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

        }


}

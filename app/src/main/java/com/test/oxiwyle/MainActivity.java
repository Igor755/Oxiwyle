package com.test.oxiwyle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

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

        firstbutton.setOnTouchListener(this);
        twobutton.setOnTouchListener(this);
        threebutton.setOnTouchListener(this);
        fourbutton.setOnTouchListener(this);
        fivebutton.setOnTouchListener(this);
    }

    public int getHotspotColor(int hotspotId, int x, int y) {


        ImageView imageView = (ImageView) findViewById(hotspotId);

       // if (imageView == R.id.firstbutton) {}
        if (imageView == null) {
            //if (IConstants.debug)
            Log.d("MainActivity", "Hot spot image not found");
            return 0;
        } else {
            imageView.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(imageView.getDrawingCache());
            if (hotspots == null || ((x < 1 || y < 1) || (x > hotspots.getWidth() || y > hotspots.getHeight()))) {
                //if (IConstants.debug)
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
                        if (touchColor1 != 0 && Color.alpha(touchColor1) != Color.TRANSPARENT) {
                            handledHere = true;
                            if (v.getId() == R.id.firstbutton){
                                Toast.makeText(MainActivity.this, "111111111111111", Toast.LENGTH_SHORT).show();
                                firstbutton.setImageResource(R.drawable.first2);
                                 Alert(name = "1");

                            }else if (v.getId() == R.id.twobutton){
                                Toast.makeText(MainActivity.this, "2222222222222222", Toast.LENGTH_SHORT).show();
                                twobutton.setImageResource(R.drawable.two2);
                             //   Alert(name = "2");

                            }else if (v.getId() == R.id.threebutton){
                                Toast.makeText(MainActivity.this, "3333333333333333", Toast.LENGTH_SHORT).show();
                                threebutton.setImageResource(R.drawable.three2);
                             //   Alert(name = "3");

                            }else if (v.getId() == R.id.fourbutton){
                                Toast.makeText(MainActivity.this, "444444444444444444444", Toast.LENGTH_SHORT).show();
                                fourbutton.setImageResource(R.drawable.four2);
                             //   Alert(name = "4");

                            }else if (v.getId() == R.id.fivebutton){
                                Toast.makeText(MainActivity.this, "5555555555555555555555", Toast.LENGTH_SHORT).show();
                                fivebutton.setImageResource(R.drawable.five2);
                               // Alert(name = "5");

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
            builder.setTitle("Номер кнопки")
                    .setMessage("КНОПКА НОМЕР: " + name)
                    .setIcon(R.drawable.alarm)
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

        }


}

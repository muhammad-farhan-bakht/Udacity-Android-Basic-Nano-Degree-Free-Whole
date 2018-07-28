package com.example.farhan.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        changeImage();

        // TODO: Find a reference to the TextView in the layout. Change the text.
        changeText();
    }

    /**
     * Method to chane the Image on Button Click.
     */
    private void changeImage() {
        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        imageView.setImageResource(R.drawable.after_cookie);
    }

    /**
     * Method to chane the text on Button Click.
     */
    private void changeText() {
        TextView textview = (TextView) findViewById(R.id.status_text_view);
        textview.setText("I' am so full");
    }
}
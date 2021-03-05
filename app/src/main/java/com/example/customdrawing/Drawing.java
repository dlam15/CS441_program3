package com.example.customdrawing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class Drawing extends AppCompatActivity {
    private int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            choice = extras.getInt("COLOR");
        }

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        Flower flower = new Flower(getApplicationContext(), choice);
        layout.addView(flower);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                flower.draw(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button home = (Button) findViewById(R.id.button2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drawing.this, MainActivity.class);
                startActivity(intent);
                finish ();
            }
        });
    }
}
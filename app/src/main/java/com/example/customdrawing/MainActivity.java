package com.example.customdrawing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int[] possible = {Color.RED, Color.BLUE, Color.MAGENTA, 0xFFEDE904, 0xFF8240BA, 0xFFEA6C0C, Color.CYAN,};
    private int choice = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button drawing = (Button) findViewById(R.id.drawBtn);
        drawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Drawing.class);
                intent.putExtra("COLOR", choice);
                startActivity(intent);
                finish ();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.colorPicker);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        ((TextView) parent.getChildAt(0)).setTextSize(20);
        choice = possible[pos];
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
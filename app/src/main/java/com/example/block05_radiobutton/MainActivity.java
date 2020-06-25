package com.example.block05_radiobutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        setContentView(R.layout.activity_main);
        final ConstraintLayout layout=(ConstraintLayout) findViewById(R.id.layout);

        if(preferences.contains("colorId"))
        {
            layout.setBackgroundColor(preferences.getInt("colorId",0));
        }

        RadioGroup radioGroup_colors =(RadioGroup) findViewById(R.id.radioGroup_colors);
        radioGroup_colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int colorCode = 0;
                switch (checkedId) {
                    case R.id.radioBlue:
                        colorCode = Color.BLUE;
                        break;
                    case R.id.radioMagenta:
                        colorCode = Color.MAGENTA;
                        break;
                    case R.id.radioYello:
                        colorCode = Color.YELLOW;
                        break;
                }
                layout.setBackgroundColor(colorCode);
                editor.putInt("colorId", colorCode);
                editor.commit();
            }
        });
    }
}
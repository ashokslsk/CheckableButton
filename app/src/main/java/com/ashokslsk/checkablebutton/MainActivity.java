package com.ashokslsk.checkablebutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.dunst.check.CheckableButton;
import com.dunst.check.CheckableImageButton;

public class MainActivity extends AppCompatActivity {

    com.dunst.check.CheckableButton mClickCheck1;
    com.dunst.check.CheckableImageButton mClickCheck2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClickCheck1 = (CheckableButton) findViewById(R.id.button1);
        mClickCheck2 = (CheckableImageButton) findViewById(R.id.button2);

        mClickCheck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Checked= "Button Unchecked";
                if(mClickCheck1.isChecked()){
                    Checked = "Button Checked";
                }
                Toast.makeText(MainActivity.this, Checked, Toast.LENGTH_SHORT).show();
            }
        });

        mClickCheck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Checked= "ImageButton Unchecked";
                if(mClickCheck2.isChecked()){
                    Checked = "ImageButton Checked";
                }
                Toast.makeText(MainActivity.this, Checked, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

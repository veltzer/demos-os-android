package com.example.myapplication;

import static com.example.myapplication.Constants.DATA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("App", "Button1 was clicked");
                Intent i = new Intent(
                        view.getContext(),
                        Activity2.class
                );
                EditText et=(EditText)findViewById(R.id.edit1);
                i.putExtra(DATA, et.getText().toString());
                startActivity(i);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        String s=getIntent().getStringExtra(DATA);
        EditText et=(EditText)findViewById(R.id.edit1);
        et.setText(s);
    }
}

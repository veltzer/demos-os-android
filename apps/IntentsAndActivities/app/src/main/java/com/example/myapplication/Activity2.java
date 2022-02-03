package com.example.myapplication;

import static com.example.myapplication.Constants.DATA;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button b=(Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("App", "Button2 was clicked");
                Intent i = new Intent(
                        view.getContext(),
                        Activity1.class
                );
                EditText et=(EditText)findViewById(R.id.edit2);
                i.putExtra(DATA, et.getText().toString());
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String s=getIntent().getStringExtra(DATA);
        EditText et=(EditText)findViewById(R.id.edit2);
        et.setText(s);
    }
}

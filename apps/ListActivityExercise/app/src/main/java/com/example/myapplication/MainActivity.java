package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] strings = { "Socrates", "Plato", "Aristotle" };
        @SuppressLint("ResourceType") ArrayAdapter<String> a = new ArrayAdapter<String>(
                this,
                R.layout.simple_list_item,
                strings
        );
        Log.i("MyApp","Hello to all the students");
        setListAdapter(a);
    }
}

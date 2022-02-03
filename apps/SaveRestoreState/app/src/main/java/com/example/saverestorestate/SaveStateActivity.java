package com.example.saverestorestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.EditText;

public class SaveStateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_state);
        Log.i("App", "OnCreate");
        // SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        //String t = sharedPref.getString("data", "default value");
        //EditText et=(EditText)findViewById(R.id.edittext);
        //et.setText(t);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("App", "OnRestoreInstanceState");
        String t = savedInstanceState.getString("data", "default value");
        EditText et=(EditText)findViewById(R.id.edittext);
        et.setText(t);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i("App", "OnSaveInstanceState");
        EditText et=(EditText)findViewById(R.id.edittext);
        String t = et.getText().toString();

        outState.putString("data", t);

        //SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putString("data", t);
        //editor.commit();
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        Log.i("App", "OnSaveInstanceState");
        EditText et=(EditText)findViewById(R.id.edittext);
        String t = et.getText().toString();

        outPersistentState.putString("data", t);
        super.onSaveInstanceState(outState, outPersistentState);
    }
}

package com.example.asynctaskexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public class MyAsyncTask extends AsyncTask<Integer, Void, Integer> {
        @Override
        protected Integer doInBackground(Integer... integers) {
            Integer sum = 0;
            for(int i=0; i<integers[0]; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                sum += i;
            }
            return sum;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            TextView tv = (TextView)MainActivity.this.findViewById(R.id.result);
            tv.setText(integer.toString());
            Button b = (Button) MainActivity.this.findViewById(R.id.run_button);
            b.setEnabled(true);
        }
    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.i("App", "Running task");
            EditText et = (EditText) findViewById(R.id.data);
            Integer data = Integer.parseInt(et.getText().toString());
            Button b = (Button) view;
            b.setEnabled(false);
            // now we need to run the ASyncTask...
            MyAsyncTask mat = new MyAsyncTask();
            mat.execute(data);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.run_button);
        b.setOnClickListener(new MyClickListener());
    }
}

package com.example.contentproviderexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ListActivity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(
                this.getBaseContext(),
                Manifest.permission.READ_CONTACTS
        ) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{ Manifest.permission.READ_CONTACTS },
                    79);
        }

        String[] from = {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME
                //ContactsContract.CommonDataKinds.Organization.COMPANY
        };
        int[] to = new int[]{
                R.id.id,
                R.id.name
        };

        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                //ContactsContract.CommonDataKinds.Organization.COMPANY
        };
        Cursor results = getContentResolver().query(
                uri,
                projection,
                null,
                null,
                null
        );

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.item,
                results,
                from,
                to
        );

        setListAdapter(adapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}

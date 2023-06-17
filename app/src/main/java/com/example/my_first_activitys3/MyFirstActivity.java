package com.example.my_first_activitys3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class MyFirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylayoutfirst);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "¡Primer Activity!", Toast.LENGTH_SHORT).show();

        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("https://es-la.facebook.com"));
        //startActivity(intent);
        Intent intent = new Intent(this, MySecondActivity.class);
        startActivity(intent);
    }

}

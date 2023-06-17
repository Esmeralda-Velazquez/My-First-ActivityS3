package com.example.my_first_activitys3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MyFirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylayoutfirst);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "¡Bienvenido de vuelta!", Toast.LENGTH_SHORT).show();
    }

}

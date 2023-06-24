package com.example.my_first_activitys3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.content.res.ColorStateList;
import android.widget.RadioButton;

public class MyFirstActivity extends Activity {
    private ListView listView;
    private MyCustomAdapter adapter;
    private int counter = 0;
    private TextView counterTextView;
    private Button incrementButton;
    private CheckBox checkBox;
    private RadioButton radioButton3;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylayoutfirst);
        listView = findViewById(R.id.listView);
        String[] datos = {"A", "B", "C"};
        adapter = new MyCustomAdapter(this, datos);
        listView.setAdapter(adapter);

        counterTextView = findViewById(R.id.counterTextView);
        incrementButton = findViewById(R.id.incrementButton);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                updateCounter();
            }
        });

        // Agregar EditText
        final EditText editTextTexto = findViewById(R.id.editTextTexto);
        final EditText editTextNumero = findViewById(R.id.editTextNumero);
        final EditText editTextTelefono = findViewById(R.id.editTextTelefono);
        final EditText editTextContraseña = findViewById(R.id.editTextContraseña);
        final EditText editTextEmail = findViewById(R.id.editTextEmail);

        radioButton3 = findViewById(R.id.radioButton3);
        checkBox = findViewById(R.id.checkBox);
        sendButton = findViewById(R.id.sendButton);
        sendButton.setEnabled(false); // Inicialmente deshabilitado

        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean isRadioButton3Checked = radioButton3.isChecked();
                sendButton.setEnabled(isRadioButton3Checked && isChecked);
                if (isChecked) {
                    sendButton.setBackgroundTintList(null); // Restaurar el color original
                } else {
                    int disabledColor = getResources().getColor(R.color.gray); // Cambiar "gray" por el nombre de tu color gris
                    sendButton.setBackgroundTintList(ColorStateList.valueOf(disabledColor));
                }
            }
        };

        radioButton3.setOnCheckedChangeListener(checkedChangeListener);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editTextTexto.getText().toString();
                String numero = editTextNumero.getText().toString();
                String telefono = editTextTelefono.getText().toString();
                String contraseña = editTextContraseña.getText().toString();
                String email = editTextEmail.getText().toString();

                Log.d("EditTextValues", "Texto: " + texto);
                Log.d("EditTextValues", "Número: " + numero);
                Log.d("EditTextValues", "Teléfono: " + telefono);
                Log.d("EditTextValues", "Contraseña: " + contraseña);
                Log.d("EditTextValues", "Email: " + email);
            }
        });
    }

    private void updateCounter() {
        counterTextView.setText("Counter: " + counter);
        Log.d("Etiqueta", "Este es un mensaje de depuración");
    }
}

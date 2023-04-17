package com.example.myapplicationejemplosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(preferences.getString("nombre", ""));
        et2.setText(preferences.getString("e-mail", ""));
        et3.setText(preferences.getString("dirección", ""));
    }

    public void guardar(View view) {


        if (et1.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo Nombre no puede estar vacío", Toast.LENGTH_LONG).show();

        } if (et2.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo E-mail no puede estar vacío", Toast.LENGTH_LONG).show();

        } if (et3.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo Dirección no puede estar vacío", Toast.LENGTH_LONG).show();

        } else{

            SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor Obj_editor = preferences.edit();
            Obj_editor.putString("nombre", et1.getText().toString());
            Obj_editor.putString("e-mail", et2.getText().toString());
            Obj_editor.putString("dirección", et3.getText().toString());
            Obj_editor.commit();
            Toast.makeText(this, "Formulario completo", Toast.LENGTH_LONG).show();
        }


    }
}
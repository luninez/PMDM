package com.example.lbenitez.intentsmultiple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button numRecogido;
    Button numAnterior;
    EditText pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada);

        pantalla = findViewById(R.id.editText);

    }

    public void numPulsado(View view) {
        numRecogido = ((Button)view).getText().toString();

            numAnterior = pantalla.getText().toString();
            pantalla.setText(numAnterior + numRecogido);
        }

    }

}

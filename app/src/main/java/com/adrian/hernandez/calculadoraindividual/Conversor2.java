package com.adrian.hernandez.calculadoraindividual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Conversor2 extends AppCompatActivity {

    private EditText editTextX;
    private EditText editTextTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor2);
        editTextX = findViewById(R.id.editTextNumberXC2);
        editTextTotal = findViewById(R.id.editTextNumberTotalC2);
        editTextX.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus)
                {
                    realizaOperacion();
                }
            }
        });

    }

    private void realizaOperacion()
    {
        int total = 0;
        if(editTextX.getText().toString() != null)
        {
            if( isEntero(editTextX.getText().toString()))
            {
                total = getEntero( editTextX.getText().toString())*1000;
            }
        }


        editTextTotal.setText(String.format("%d", total), TextView.BufferType.SPANNABLE);
        editTextTotal.setEnabled(false);
    }

    private int getEntero(String entero){
        {
            try
            {
                return Integer.parseInt(entero);
            }
            catch(NumberFormatException ex)
            {
                ex.printStackTrace();
            }
            return 0;
        }

    }

    private boolean isEntero(String entero)
    {
        try
        {
            if(entero == null || entero.length() == 0)
            {
                return false;
            }
            Integer.parseInt(entero);
            return true;
        }
        catch (NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
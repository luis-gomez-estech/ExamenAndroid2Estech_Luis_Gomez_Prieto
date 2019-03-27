package com.example.alumno_fp.examenandroid2estech_luis_gomez_prieto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    TextView resultados;

    private ArrayList<String> datos; // Declaro el arrayLst que va a contener los sitios

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resultados = (TextView)findViewById(R.id.resultados);


        String resultFinal = getIntent().getStringExtra("datos");
        resultados.setText(resultFinal);




    }
}

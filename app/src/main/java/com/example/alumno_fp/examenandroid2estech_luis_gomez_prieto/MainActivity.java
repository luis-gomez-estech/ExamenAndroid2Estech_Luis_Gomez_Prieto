package com.example.alumno_fp.examenandroid2estech_luis_gomez_prieto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> datos; // Declaro el arrayLst que va a contener los sitios
    private ListView lista; // declaro la lista
    private ArrayAdapter<String> adaptador1; //Declaro el adaptador necesario cuando tenemos listas para actualizarla

    //Enviar el valor de este String a otra activty
   // final String pruebaString = "Esto es una prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos= new ArrayList<>();

        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);

        lista= findViewById(R.id.listaFinal); // A la lista declarada le digo su id

        Button button = (Button)findViewById(R.id.botonValida);

        button.setOnClickListener(new View.OnClickListener() {

            // y lo que va a hacer es que cuando le demos a click  a va poner en Toast el valor de cada EditToast, tambien alertar si no esta relleno, si la edad en menor,
            // o si toodo esta correcto, nos dirá que la inscripcion se ha realizado con exito

            @Override
            public void onClick(View view) {

                ///// OBTENEMOS VALOR DEL NOMBRE

                EditText nombre = (EditText)findViewById(R.id.nombre);

                String valorNombre = nombre.getText().toString();

                ///// OBTENEMOS VALOR DE LA EDAD

                EditText edad = (EditText)findViewById(R.id.edad);

                //Si la edad  NO(!) tiene ninguna letra ("") entonces es true (?), por tanto, sera igual a la edad cnvertido a String, y a su vez convertido a int.

                int numeroIngresado = !edad.getText().toString().equals("") ? Integer.parseInt(edad.getText().toString()) : -1;


                    // y ahora voy comprobando que campo se va rellenando y avisando sino se rellena tanto en el Toast com en cada campo

                    if (isEmpty(valorNombre)) {
                        nombre.setError("Rellene este campo");
                        Toast.makeText(getApplicationContext(), "Debe rellenar el campo nombree", Toast.LENGTH_LONG).show();

                    }
                    // y aqui valido si tiene mas de 18 años, si no lo es marca error y no deja inscribirse
                    else if (numeroIngresado < 0||numeroIngresado>150){
                        edad.setError("Edad menor de la permitida");
                        Toast.makeText(getApplicationContext(), "Introduce una entre 0 y 150", Toast.LENGTH_SHORT).show();

                    }  else {
                        Toast.makeText(getApplicationContext(), "Datos correctos", Toast.LENGTH_LONG).show();

                        datos.add(valorNombre);

                        lista.setAdapter(adaptador1); //Aqui le digo que el adaptador1 actualice la lista

                    }
                }

        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                // Con esto vamos a la actividad 2
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                intent.putExtra("datos", datos);
                startActivity(intent);
            }
        });





    }

}






package com.example.grupos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Football extends AppCompatActivity {

    //inicialización de la lista de datos de ejemplo
    private ListView as;
    private EditText ft0;
    private EditText ft1;
    private EditText ft2;
    private EditText ft3;
    private EditText ft4;
    private EditText ft5;
    private EditText ft6;
    private EditText ft7;
    private EditText ft8;
    private EditText ft9;
    private int i;
    private ArrayList<String> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);

        ft0 = (EditText) findViewById(R.id.player);

        ft0.setGravity(Gravity.CENTER);

        ft1 = (EditText) findViewById(R.id.player9);

        ft1.setGravity(Gravity.CENTER);

        ft2 = (EditText) findViewById(R.id.player10);

        ft2.setGravity(Gravity.CENTER);

        ft3 = (EditText) findViewById(R.id.player12);

        ft3.setGravity(Gravity.CENTER);

        ft4 = (EditText) findViewById(R.id.player13);

        ft4.setGravity(Gravity.CENTER);

        ft5 = (EditText) findViewById(R.id.player14);

        ft5.setGravity(Gravity.CENTER);

        ft6 = (EditText) findViewById(R.id.player15);

        ft6.setGravity(Gravity.CENTER);

        ft7 = (EditText) findViewById(R.id.player16);

        ft7.setGravity(Gravity.CENTER);

        ft8 = (EditText) findViewById(R.id.player17);

        ft8.setGravity(Gravity.CENTER);

        ft9 = (EditText) findViewById(R.id.player18);

        ft9.setGravity(Gravity.CENTER);

        i = Integer.valueOf(getIntent().getStringExtra("cant"));


        if (i <= 2){

            ft4.setVisibility(View.INVISIBLE);
            ft5.setVisibility(View.INVISIBLE);

        }

        if (i <= 3){

            ft6.setVisibility(View.INVISIBLE);
            ft7.setVisibility(View.INVISIBLE);

        }

        if (i <= 4){

            ft8.setVisibility(View.INVISIBLE);
            ft9.setVisibility(View.INVISIBLE);

        }

       players = new ArrayList<String>();
    }



    public void actionfive(View view){

        String nm1 = ft0.getText().toString();
        String nm2 = ft1.getText().toString();
        String nm3 = ft2.getText().toString();
        String nm4 = ft3.getText().toString();
        boolean continuar = true;
        if(i>2) { // si son mas de 2 por equipo
            String nm5 = ft4.getText().toString();
            String nm6 = ft5.getText().toString();
            if(nm5.equals("")||nm6.equals("")){ //si alguno es vacio
                Toast.makeText(this,"No pueden haber campos vacios", Toast.LENGTH_LONG).show();
                continuar = false;
            }
            else{
                players.add(nm5); //los aniado a la lista
                players.add(nm6);
            }
        }
        if(i>3) { //son mas que 3
            String nm7 = ft6.getText().toString();
            String nm8 = ft7.getText().toString();

            if(nm8.equals("")||nm7.equals("")){ //si alguno es vacio
                Toast.makeText(this,"No pueden haber campos vacios", Toast.LENGTH_LONG).show();
                continuar = false;
            }
            else{
                players.add(nm7);//los aniado a la lista
                players.add(nm8);
            }
        }
        if (i>4) {  //si son mas que 4
            String nm9 = ft8.getText().toString();
            String nm10 = ft9.getText().toString();
            if(nm9.equals("")||nm10.equals("")){ //si alguno es vacio
                Toast.makeText(this,"No pueden haber campos vacios", Toast.LENGTH_LONG).show();
                continuar = false;
            }
            else{
                players.add(nm9);//los aniado a la lista
                players.add(nm10);

            }
        }

        if(nm1.equals("")||nm2.equals("")||nm3.equals("")||nm4.equals("")){

            Toast.makeText(this,"No pueden haber campos vacios", Toast.LENGTH_LONG).show();
            continuar = false;
        }
        else {
            players.add(nm1);
            players.add(nm2);
            players.add(nm3);
            players.add(nm4);

            if (continuar) {
                Intent inten = new Intent(this, Grupoformadoft.class);
                inten.putStringArrayListExtra("players", players);
                inten.putExtra("cant", String.valueOf(i));
                startActivity(inten);
            }
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        ft0.setText("");
        ft1.setText("");
        ft2.setText("");
        ft3.setText("");
        ft4.setText("");
        ft5.setText("");
        ft6.setText("");
        ft7.setText("");
        ft8.setText("");
        ft9.setText("");
        players = new ArrayList<String>();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }


}

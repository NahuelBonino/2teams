package com.example.grupos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Grupoformadoft extends AppCompatActivity {

    public ArrayList<String> playe;
    public ArrayList<String> play2;
    public ListView l1;
    public ListView l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupoformadoft);

        //obtengos las listas que se muestran
        l1 = (ListView) findViewById(R.id.lista1);
        l2 = (ListView) findViewById(R.id.lista2);
        l1.setAdapter(null);
        l2.setAdapter(null);

        int cantidad_players = Integer.valueOf(getIntent().getStringExtra("cant"));
        playe = getIntent().getStringArrayListExtra("players");

        play2 = new ArrayList<String>();

        //divido aleatoriamente en dos arreglos  de 5 elementos
        int cont = 0;
        while(cont<cantidad_players){
           Random rand = new Random();
           int randi = rand.nextInt(playe.size());
           String nom = playe.get(randi);
           playe.remove(randi);
           play2.add(nom);
           cont++;
        }
        //creo los adapters para los listviews
        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playe);

        ArrayAdapter<String> ad2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,play2);

        l1.setAdapter(ad1);

        l2.setAdapter(ad2);

    }


}

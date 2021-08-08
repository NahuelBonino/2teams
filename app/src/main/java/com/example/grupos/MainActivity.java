package com.example.grupos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = (Spinner)findViewById(R.id.spinner);
        ArrayList<String> num = new ArrayList<String>();
        num.add("5");
        num.add("4");
        num.add("3");
        num.add("2");
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,num);
        s.setAdapter(ad);
    }

    public void action(View view){

            Intent inte2 = new Intent(this, Football.class);
            inte2.putExtra("cant",s.getSelectedItem().toString());
            startActivity(inte2);

    }

}

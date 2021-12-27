package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {

    EditText nom,classs;
    Button Modifier, Supprimer;
    int position;
    params p=new params();
    HashMap<String,String> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nom=findViewById(R.id.nom);
        classs=findViewById(R.id.classs);
        Modifier=findViewById(R.id.Modifier);
        Supprimer=findViewById(R.id.Supprimer);

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            position=extras.getInt("i");

        }
        m =  p.values.get(position);
        nom.setText(m.get("nom"));
        classs.setText(m.get("classs"));

        Modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.put("nom",nom.getText().toString());
                m.put("classs",classs.getText().toString());
                Intent i = new Intent(getApplicationContext(),StudentsActivity.class);
                startActivity(i);
                finish();

            }
        });

        Supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.values.remove(position);
                Intent i = new Intent(getApplicationContext(),StudentsActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
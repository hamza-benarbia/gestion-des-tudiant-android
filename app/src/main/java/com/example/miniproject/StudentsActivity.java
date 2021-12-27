package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class StudentsActivity extends AppCompatActivity {
     ListView lst;
     String nom,classs;
     HashMap<String,String> map;
     params p= new params();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        lst=findViewById(R.id.lst);

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            nom=extras.getString("nom");
            classs=extras.getString("classs");
            map= new HashMap<String,String>();
            map.put("nom",nom);
            map.put("classs",classs);
            p.values.add(map);

        }
        SimpleAdapter adapter = new SimpleAdapter(StudentsActivity.this,p.values,R.layout.item,
                new String[]{"nom","classs"},
                new int[]{R.id.nom,R.id.classs}
                );
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent k= new Intent(getApplicationContext(),DetailActivity.class);
                k.putExtra("i",i);
                startActivity(k);

            }
        });

    }
}
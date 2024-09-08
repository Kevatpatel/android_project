package com.example.quickmeds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Homeactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        SharedPreferences sp=getSharedPreferences("sp_pref", Context.MODE_PRIVATE);
        String username=sp.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+username , Toast.LENGTH_SHORT).show();

        CardView exit=findViewById(R.id.cardexit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sp.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(Homeactivity.this,loginactivity.class));
            }
        });

        CardView finddoctor =findViewById(R.id.cardfinddoctor);
        finddoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homeactivity.this,FindDoctor.class));
            }
        });

        CardView Labtest =findViewById(R.id.cardlabtest);
        Labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homeactivity.this,labtestactivity.class));
            }
        });

    }
}
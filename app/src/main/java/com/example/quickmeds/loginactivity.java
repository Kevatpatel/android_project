package com.example.quickmeds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginactivity extends AppCompatActivity {
    EditText user,pass;
    Button btn;
    TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
         user=(EditText) findViewById(R.id.userlogin);
         pass= (EditText) findViewById(R.id.userpass);
         btn=(Button) findViewById(R.id.btn);
         tv=(TextView) findViewById(R.id.textregister);

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String username = user.getText().toString();
                 String password = pass.getText().toString();
                 Database db=new Database(getApplicationContext(),"healthcare",null,1);
                 if (username.length() == 0 || password.length() == 0) {
                     Toast.makeText(getApplicationContext(), "please fill all the details", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     if (db.login(username, password) == 1) {
                         Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                         SharedPreferences sp=getSharedPreferences("sp_pref", Context.MODE_PRIVATE);
                         SharedPreferences.Editor editor=sp.edit();
                         editor.putString("username",username);
                         editor.apply();
                         startActivity(new Intent(loginactivity.this,Homeactivity.class));
                     }
                     else
                     {
                         Toast.makeText(getApplicationContext(),"Invalid username and password",Toast.LENGTH_SHORT).show();
                     }
                 }
             }
         });

         tv.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(loginactivity.this,MainActivity.class));
             }
         });


    }
}
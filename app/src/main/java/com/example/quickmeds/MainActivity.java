package com.example.quickmeds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
   EditText reguser,regemail,regpass,regconfirmpass;
   Button btn;
   TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        reguser=findViewById(R.id.textviewappfullname);
        regemail=findViewById(R.id.textviewappaddress);
        regpass=findViewById(R.id.textviewappcontact);
        regconfirmpass=findViewById(R.id.textviewappfees);
        tv = findViewById(R.id.textregister);
        btn = findViewById(R.id.btnappbook);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username=reguser.getText().toString();
                String email=regemail.getText().toString();
                String password=regpass.getText().toString();
                String confirmpassword=regconfirmpass.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
               if(username.length()==0 || email.length()==0|| password.length()==0||confirmpassword.length()==0)
               {
                   Toast.makeText(getApplicationContext(),"please fill all the details",Toast.LENGTH_SHORT).show();
               }
               else {
                   if(password.compareTo(confirmpassword)==0)
                   {
                       if(isValid(password))
                       {
                           db.register(username,email,password);
                           Toast.makeText(getApplicationContext(),"Registration successful",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(MainActivity.this,loginactivity.class));
                       }
                       else {
                           Toast.makeText(getApplicationContext(),"password must contain at least 8 characters,having letter,digit and special symbol",Toast.LENGTH_SHORT).show();
                       }
                   }
                   else {
                       Toast.makeText(getApplicationContext(),"password and confirm password doesn't match",Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
    tv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this , loginactivity.class));
        }
    });
    }
    public static boolean isValid(String passwordhere)
    {
        int f1=0,f2=0,f3=0;
        if(passwordhere.length()<8)
        {
            return false;
        }
        else {
            for(int p=0;p<passwordhere.length();p++)
            {
                if(Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for(int r=0;r<passwordhere.length();r++)
            {
                if(Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for(int s=0;s<passwordhere.length();s++)
            {
                char c=passwordhere.charAt(s);
                if(c>=33 && c<=46 || c==64)
                {
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
            {
                return true;
            }
            else {
                return false;
            }

        }
    }
}
package com.example.quickmeds;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {
     private String[][] doctor_details1=
    {
        {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No:9898756865","600"},
            {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile No:9898756862","900"},
            {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 25yrs","Mobile No:8898756865","300"},
            {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchad","Exp : 35yrs","Mobile No:9798756865","500"},
            {"Doctor Name : Ashok pande","Hospital Address : Katral","Exp : 15yrs","Mobile No:7898756865","800"},
    };
    private String[][] doctor_details2=
            {
                    {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No:9898756865","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile No:9898756862","900"},
                    {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 25yrs","Mobile No:8898756865","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchad","Exp : 35yrs","Mobile No:9798756865","500"},
                    {"Doctor Name : Ashok pande","Hospital Address : Katral","Exp : 15yrs","Mobile No:7898756865","800"},
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No:9898756865","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile No:9898756862","900"},
                    {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 25yrs","Mobile No:8898756865","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchad","Exp : 35yrs","Mobile No:9798756865","500"},
                    {"Doctor Name : Ashok pande","Hospital Address : Katral","Exp : 15yrs","Mobile No:7898756865","800"},
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No:9898756865","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile No:9898756862","900"},
                    {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 25yrs","Mobile No:8898756865","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchad","Exp : 35yrs","Mobile No:9798756865","500"},
                    {"Doctor Name : Ashok pande","Hospital Address : Katral","Exp : 15yrs","Mobile No:7898756865","800"},
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No:9898756865","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile No:9898756862","900"},
                    {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 25yrs","Mobile No:8898756865","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchad","Exp : 35yrs","Mobile No:9798756865","500"},
                    {"Doctor Name : Ashok pande","Hospital Address : Katral","Exp : 15yrs","Mobile No:7898756865","800"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    HashMap<String,String>item;
    SimpleAdapter sa;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText("title");

        if(title.compareTo("FAMILY PHYSICIAN")==0)
        {
            doctor_details=doctor_details1;
        }
        if(title.compareTo("DIETICIAN")==0)
        {
            doctor_details=doctor_details2;
        }
        if(title.compareTo("DENTIST")==0)
        {
            doctor_details=doctor_details3;
        }
        if(title.compareTo("SURGEON")==0)
        {
            doctor_details=doctor_details4;
        }
        if(title.compareTo("CARDIOLOGIST")==0)
        {
            doctor_details=doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetails.this,FindDoctor.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);

        }
    }
}
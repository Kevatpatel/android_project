package com.example.quickmeds;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        btn=findViewById(R.id.buttonltback);

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
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons fees:"+doctor_details[i][4]+"/-");
             list.add(item);


        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listviewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetails.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}

package com.example.quickmeds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class labtestactivity extends AppCompatActivity {

    private String [][] packages={
            {"package1 : Full Body Checkup","","","","999"},
            {"package2 : Blood Glucose Fasting","","","","299"},
            {"package3 : Covid-19 Antibody","","","","899"},
            {"package4 : Thyroid Check","","","","499"},
            {"package5 : Immunity Check","","","","699"},

    };
    private String[] package_details={
             "Blood Glucose Fasting\n"+
             "HbAIc\n"+
             "Iron Studies\n"+
             "Kidney Function Test\n"+
             "LDH Lactate Dehydrogenase,Serum\n"+
             "Lipid Profile\n"+
             "Liver Function Test",
            "Blood Glucose Fasting",
            "Covid-19 Antibody - Ig9",
            "Thyroid Profile-Total (T3,T4 & TSH Ultra-Sensitive)",
            "Complete Hemogram\n"+
                    "CRP (C Reactive Protein) Quantitative,Serum\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "Vitamin D Total-25 Hydroxy\n"+
                    "Liver Function Test\n"+
                    "Lipid Profile"

    };
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    Button btngototcart,btnback;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtestactivity);
        btngototcart=findViewById(R.id.buttonltgotocart);
        btnback=findViewById(R.id.buttonltback);
        listview=findViewById(R.id.listviewlt);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(labtestactivity.this,Homeactivity.class));
            }
        });

        list=new ArrayList<>();
        for(int i=0;i<packages.length;i++)
        {
            item=new HashMap<String ,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listview.setAdapter(sa);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(labtestactivity.this,labtestdetail.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);

            }
        });
    }
}
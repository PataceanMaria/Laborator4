package com.example.secondappwithlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private android.widget.ListView ListView;
    private Button addBtn;
    private Button deltebtn;
    private EditText itemEdt;
    private ArrayList<String> lngList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView = findViewById(R.id.ListView);
        addBtn = findViewById(R.id.idBtnAdd);
        deltebtn=findViewById(R.id.Deletebtn);
        itemEdt = findViewById(R.id.idEdtItemName);
        lngList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lngList);
        ListView.setAdapter(adapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemEdt.getText().toString();
                if (!item.isEmpty()) {
                    lngList.add(item);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, item+" added to the list", Toast.LENGTH_LONG).show();
                }

            }
        });
        deltebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemEdt.getText().toString();
                    if(lngList.size()>0)
                    {
                        if(!itemEdt.getText().toString().isEmpty())
                        {
                            lngList.remove(itemEdt.getText().toString());
                            adapter.notifyDataSetChanged();
                            Toast.makeText(MainActivity.this, item+" was deleted from list", Toast.LENGTH_LONG).show();
                        }
                    }
            }
        });



    }

    }

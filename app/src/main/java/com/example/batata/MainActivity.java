package com.example.batata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{


    ArrayAdapter arrayAdapter;
    ArrayList<String> strings;
    EditText editText;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main_activity);


        ListView listView = findViewById(R.id.myListViewer);

        Button button = findViewById(R.id.addToListButton);

        editText = findViewById(R.id.myTextBoxtoAdd);


        strings = new ArrayList<>();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,strings);

        listView.setAdapter(arrayAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                listItem.toString();
            }
        });





    }

    public void updateList(View view) {
        if(!String.valueOf(editText.getText()).equals("") && !String.valueOf(editText.getText()).equals(null)){
            strings.add(String.valueOf(editText.getText()));
            arrayAdapter.notifyDataSetChanged();
        }
    }
}

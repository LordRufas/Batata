package com.example.batata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main_activity);


        ListView listView = findViewById(R.id.myListViewer);

        Button button = findViewById(R.id.addToListButton);


        ArrayList<String> strings = new ArrayList<>();
        strings.add("html");
        strings.add("java");
        strings.add("kotlin");
        strings.add("python");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,strings);

        listView.setAdapter(arrayAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                listItem.toString();
                Log.d("List", "User tapped the " + listItem.toString() + " at position " + position );
                
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                strings.add("aa");
                Log.d("BUTTONS", "User tapped the Supabutton");
                arrayAdapter.notifyDataSetChanged();
            }
        });





    }
}

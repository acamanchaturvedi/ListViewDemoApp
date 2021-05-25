package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    public void  generateTable(int timetableNumber)
    {
        ArrayList<String> content=new ArrayList<>();
        for(int i=1;i<=100;i++)
        {
            String message=Integer.toString(timetableNumber)+" X "+Integer.toString(i)+" = "+Integer.toString(i*timetableNumber);
            content.add(message);
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,content);
        list.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Multiplication Tables");
        list = findViewById(R.id.listView);
        generateTable(1);
        SeekBar value = findViewById(R.id.seekBar);
        value.setMax(100);
        value.setMin(0);
        value.setProgress(1);
        value.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                generateTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

    }
}
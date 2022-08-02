package com.example.tables20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablesListView;
    public void generateTimesTables(int timesTablesNumber){
        ArrayList<String> timesTablesContent=new ArrayList<String>();
        for(int j=1;j<=10;j++){
            timesTablesContent.add(Integer.toString(j*timesTablesNumber));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTablesContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timesTablesSeekBar=findViewById(R.id.timesTablesSeekBar);
        timesTablesListView=findViewById(R.id.timesTablesListView);
        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);
        generateTimesTables(10);
        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timesTablesNumber;
                if(i<min){
                    timesTablesNumber=min;
                    timesTablesSeekBar.setProgress(min);
                }else{
                    timesTablesNumber=i;
                }
                Log.i("SeekBar value",Integer.toString(i));
                generateTimesTables(timesTablesNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
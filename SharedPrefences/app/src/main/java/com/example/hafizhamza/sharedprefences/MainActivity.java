package com.example.hafizhamza.sharedprefences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.hafizhamza.sharedprefences", Context.MODE_PRIVATE);
        ArrayList<String> Friends=new ArrayList<>();
        Friends.add("HARIS");
        Friends.add("RAGAM");
        Friends.add("JAMEEL");
        try {
            sharedPreferences.edit().putString("Friends",ObjectSerializer.serialize(Friends)).apply();
            Log.i("Friend",ObjectSerializer.serialize(Friends));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> NEW=new ArrayList<>();
        try {
            NEW=(ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("Friends",ObjectSerializer.serialize(new ArrayList<String>())));
       Log.i("NEW",NEW.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  sharedPreferences.edit().putString("UserName","Hafiz").apply();
        String a=sharedPreferences.getString("UserName","");
        Log.i("UserName",a);
    }
}

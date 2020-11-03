package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStream;

public class write extends AppCompatActivity {

    OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }

    private String encrypt(String entry, String key){
        int keyLength = key.length();
        int keyCounter = 0;
        StringBuilder cypherBuild = new StringBuilder();
        int[] keyVals = new int[keyLength];

        //Split key into list of ascii numbers
        for (int i=0; i==keyLength-1; i++){
            keyVals[i] = (int)(key.charAt(i));
        }

        //Encrypt each character
        for (int i=0; i==entry.length()-1; i++){
            cypherBuild.append((char)((int)(entry.charAt(i))+keyVals[keyCounter]));
            if (keyCounter >= keyLength-1){
                keyCounter = 0;
            }
            else{
                keyCounter ++;
            }
        }
        return cypherBuild.toString();
    }

    public void writeFile(String filename, String content){
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
            Toast.makeText(write.this, "File Saved Successfully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch(Exception e) {e.printStackTrace();Toast.makeText(write.this, "Something went wrong :(", Toast.LENGTH_SHORT).show();}
    }

    public void saveButton(View view){
        TextView entryText = findViewById(R.id.entryText);
        TextView titleText = findViewById(R.id.titleText);
        String title = titleText.getText().toString();
        String entry = entryText.getText().toString();

        if (title.equals("") || entry.equals("")){
            Toast.makeText(write.this, "You must enter a title and content to save.", Toast.LENGTH_SHORT).show();
        }

        else{

        }
    }

}

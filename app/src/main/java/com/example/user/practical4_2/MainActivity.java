package com.example.user.practical4_2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    String filename = "myfile";
    TextView textViewOutput;
    EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = (EditText)findViewById(R.id.editTextInput);
        textViewOutput = (TextView)findViewById(R.id.textViewOutput);
    }



    public void saveFile(View v) {
        FileOutputStream outputStream;
        try {
            String input = editTextInput.getText().toString();
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(input.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retrieveFile(View v){
        FileInputStream inputStream;
        StringBuilder output= new StringBuilder();
        try{
            inputStream = openFileInput(filename);
            int content;
            while((content=inputStream.read())!=-1){
                output.append((char)content);
            }
            textViewOutput.setText(output);
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

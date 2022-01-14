package com.myloginsystem.filesandstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.textView);
    }

    public void readFile(View v){


        try {
            //Write on file using Stream object
            PrintStream output = new PrintStream(openFileOutput("abc.txt", MODE_PRIVATE));
            output.println("Hello, world!");
            output.println("How are you?");
            output.close();

            //Read from file
            InputStream is=openFileInput("abc.txt");
            Scanner scan = new Scanner(is);
            String allText = "";   // read entire file

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                allText += line;
            }

            text.setText(allText);
            scan.close();
        }catch (Exception ioEx){ }

    }

    public void getFiles(View view) {

        String [] files=this.fileList();
        String fileNames="";
        for (String file:files){

            fileNames+=file+"\n";

        }
        text.setText(fileNames);

        File directory=getFilesDir();

        for (File f:directory.listFiles()){
            //f.getName(); Store this name into list or array
        }

        File file=new File(directory,"abcd.txt");
        if(file.exists()){

            try{
                FileInputStream fis=new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String line;
                StringBuilder content=new StringBuilder();
                while ((line=reader.readLine())!=null){
                    content.append(line+System.lineSeparator());
                }
         //       text.setText(content.toString());
            }
            catch (Exception ex){}
        }
    }


    public void readByScanner(){
        Scanner scanner=new Scanner(getResources().openRawResource(R.raw.abc));
    }

    public void getGalleryImages(View v){

        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            Toast.makeText(this, "Extrenal storage Available for WRITING", Toast.LENGTH_SHORT).show();
        }

        if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())){
            Toast.makeText(this, "Extrenal storage Available for READING", Toast.LENGTH_SHORT).show();
        }

    }
}
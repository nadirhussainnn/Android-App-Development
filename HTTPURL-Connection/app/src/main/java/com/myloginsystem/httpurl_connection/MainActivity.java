package com.myloginsystem.httpurl_connection;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Boolean isInternetAvailable=false;

    String url="https://randomuser.me/api/";

    String my_get_api="http://192.168.146.1:5000/api/getAllUsers";
    String my_post_api="http://192.168.146.1:5000/api/login";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.usersData);

        connectToServer();
    }

    public void connectToServer(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networks=connectivityManager.getAllNetworkInfo();

        for(NetworkInfo net: networks){
            if(net.isConnected()){
                isInternetAvailable=true;
            }
        }
    }

    public void getHttpURLConnectionData(View view) {

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        HttpOperations operations=(String link)->{

                            String data;
                            String completeData="";

                            if(isInternetAvailable){
                                try {
                                    URL u=new URL(url);
                                    HttpURLConnection connection=(HttpURLConnection) u.openConnection();

                                    connection.connect();
                                    InputStream is=connection.getInputStream();
                                    BufferedReader reader=new BufferedReader(new InputStreamReader(is));

                                    while ((data=reader.readLine())!=null){
                                        completeData+=data+"\n";

                                    }
                                }catch (Exception ex){}
                            }
                            return completeData;
                        };
                        textView.setText(operations.getData(url));
                    }
                });
            }
        });
        thread.start();
    }

    public void postHttpURLConnectionData(View view) {

    }

    public void useVolleyGET(View view){

        //step1. Create a request queue, define it's type
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

        //step2: Create a request, we create request on basis of response we received. Response can be string, json etc
        //StringRequest
        //ImageRequest

        StringRequest stringRequest=new StringRequest(Request.Method.GET, my_get_api,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {   //Bcz we have used StringRequest, response is String here
//                textView.setText(response);
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        requestQueue.add(stringRequest);
    }

    public void useVolleyPOST(View view){

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, my_post_api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {   //Bcz we have used StringRequest, response is String here
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String,String> map=new HashMap<>();
                map.put("Name","Nadir");
                return map;
            }
        };
        requestQueue.add(stringRequest);

    }
}
package com.myloginsystem.workmanager;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class UploadWorker extends Worker {

    String my_get_api="https://randomuser.me/api/"; //Use post API rather

    public UploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        downloadData();
        return Result.success();
    }
    public void downloadData(){

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        //USE POST method rather, just for test we use GET here
        StringRequest stringRequest=new StringRequest(Request.Method.GET, my_get_api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        requestQueue.add(stringRequest);
    }
}
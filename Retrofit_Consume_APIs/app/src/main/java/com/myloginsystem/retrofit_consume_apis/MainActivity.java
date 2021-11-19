package com.myloginsystem.retrofit_consume_apis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wessam.library.NetworkChecker;
import com.wessam.library.NoInternetLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<RecycleItemModel> users;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    Adapter adapter;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog=new ProgressDialog(this);

        Boolean isConnected=NetworkChecker.isNetworkConnected(this);
        if(isConnected){
            initData();
        }
        else{
            new NoInternetLayout.Builder(this, R.layout.activity_main)
                    .animate()
                    .mainTitle("Wah re wah ustad")
                    .secondaryText("Net khol putr")
                    .buttonText("Try kares wari");
        }
    }

    private void initData() {

        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading Data ....");
        progressDialog.show();
        users = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://jsonplaceholder.typicode.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceholderAPI api=retrofit.create(JSONPlaceholderAPI.class);
        Call<List<Users>> usersList=api.getUsers();

        usersList.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if(!response.isSuccessful()){
                    getActionBar().setTitle(""+response.code());
                    return;
                }
                List<Users> listOfUsers=response.body();
                Toast.makeText(MainActivity.this, ""+listOfUsers.size(), Toast.LENGTH_SHORT).show();
                for(Users u: listOfUsers){
                        users.add(new RecycleItemModel(R.drawable.b, u.getUserName(), u.getEmail(), u.getId()+": 20PM"));
                }
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                    recyclerView = findViewById(R.id.recycleView);
                    layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new Adapter(users);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                getActionBar().setTitle(""+t.getMessage());
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }
        });
    }
}
package com.myloginsystem.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<RecycleItemModel> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        initData();
        initRecycleView();

    }

    private void initData() {
        userList=new ArrayList<>();
//        URL url;
//        try {
//            url = new URL("https://randomuser.me/api/");
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//            Toast.makeText(this, ""+in.toString(), Toast.LENGTH_SHORT).show();

            userList.add(new RecycleItemModel(R.drawable.a, "Music Tracks Website","Jet: Excellent","11/15/21"));
            userList.add(new RecycleItemModel(R.drawable.b, "Noman Aijaz","Ok man disans tho","10:20 AM"));
            userList.add(new RecycleItemModel(R.drawable.c, "Mr. Bean","Have a movie ahead","12:20 PM"));
            userList.add(new RecycleItemModel(R.drawable.d, "Zeeshan SIBA","Notes ta send kar HCI ja","1:07 PM"));
            userList.add(new RecycleItemModel(R.drawable.e, "KS SIBA","Laptop off aa","1:11 PM"));
            userList.add(new RecycleItemModel(R.drawable.f, "Nageeta","\uD83D\uDE04","4:17 PM"));
            userList.add(new RecycleItemModel(R.drawable.a, "Sain Rizwan","Yar lab5 kaee thi?","5:09 PM"));
            userList.add(new RecycleItemModel(R.drawable.b, "Hans Raj","Received","5:21 PM"));
            userList.add(new RecycleItemModel(R.drawable.c, "BSCS(Batch2018)","Happy birthday X","8:37 PM"));


//        }catch (Exception ex){
//            Log.e("ex", ex.getMessage());
//        }
    }

    private void initRecycleView(){
        recyclerView=findViewById(R.id.recycleView);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
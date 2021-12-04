package com.myloginsystem.material_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    MaterialToolbar topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomAppBar=findViewById(R.id.bottomAppBar);

        getSupportActionBar().hide();
        topbar=findViewById(R.id.topAppBar);

        topbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this, topbar);
                popupMenu.getMenuInflater().inflate(R.menu.top_menu,popupMenu.getMenu());
                popupMenu.show();
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu=new PopupMenu(MainActivity.this, bottomAppBar);
                popupMenu.getMenuInflater().inflate(R.menu.bottom_menu,popupMenu.getMenu());

                popupMenu.show();
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.search:

                        //Display serachbar
                        break;
                    case R.id.floatingAddBtn:
                        //Allow to add something
                        break;

                    case R.id.more:
                        //Show more items
                        break;

                    default:
                        return false;
                }
                return false;
            }
        });
    }
}
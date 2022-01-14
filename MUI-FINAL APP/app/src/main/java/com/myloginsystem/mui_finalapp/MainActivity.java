package com.myloginsystem.mui_finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar appbar;
    BottomNavigationView bottomNavigationBar;
    NavigationView drawerNavigationBar;
    DrawerLayout drawer;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appbar=findViewById(R.id.topAppBar);
        bottomNavigationBar=findViewById(R.id.bottomNavigationBar);
        drawer=findViewById(R.id.drawer);
        drawerNavigationBar=findViewById(R.id.drawerNavigation);
btn=findViewById(R.id.transBtn);
//btn.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//
//        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
//                .addSharedElement(v,"kujhbhi")
//                .replace(R.id.fragmentContainer,new CartFragment(),CartFragment.class.getSimpleName())
//                .addToBackStack(null)
//                .commit();
//    }
//});

        drawerNavigationBar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();

                switch (id) {
                    case R.id.whatsappItem:
                        Intent intent=new Intent(getApplicationContext(), WhatsappActivity.class);
                        startActivity(intent);
                        break;

                    default:
                        return false;
                }
                    return false;
            }
        });

        bottomNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

                switch (id){
                    case R.id.homeItem:
                        transaction.replace(R.id.fragmentContainer,new DashboardFragment());
                        transaction.commit();
                        break;

                    case R.id.musicItem:
                        transaction.replace(R.id.fragmentContainer,new MusicFragment());
                        transaction.commit();
                        break;

                    case R.id.galleryItem:

                        transaction.replace(R.id.fragmentContainer,new GalleryFragment());
                        transaction.commit();
                        break;

                    default:
                        return false;
                }

                return false;
            }
        });
        appbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.open();
            }
        });

        appbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.cartItem:

                        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragmentContainer,new CartFragment());
                        transaction.commit();
                        break;

                    default:
                        return false;
                }
                return false;
            }
        });
    }

}
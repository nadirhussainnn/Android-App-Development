package com.myloginsystem.fragments_starter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

         FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
         FragmentManager manager=getSupportFragmentManager();
        //we need to put same fragment manager i.e androidx and android are two different
        // androidx is used
        //        FragmentTransaction transaction=manager.beginTransaction();

        switch (id){
            case R.id.frag1:
                Fragment1 f1=new Fragment1();
                transaction.replace(R.id.container, f1);// because fragment is available
                //transaction.add(ID of Container, FragmentObject, "String");  //when we want to add fragment in our placeholder i.e FrameLayout
                transaction.commit();
                break;
            case R.id.frag2:
                Fragment2 f2=new Fragment2();
                transaction.replace(R.id.container, f2);
                transaction.commit();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.myloginsystem.mid2_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class FloatingContextMenu extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_context_menu);
        imageView=findViewById(R.id.floatingImage);

        registerForContextMenu(imageView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.floating_action_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.floatingMenuItem1:
                imageView.setRotationX(imageView.getRotationX()+10);
                break;
            case R.id.floatingMenuItem2:
                imageView.setRotationY(imageView.getRotationY()+10);
                break;

            default:
                return super.onContextItemSelected(item);

        }
        return super.onContextItemSelected(item);
    }
}
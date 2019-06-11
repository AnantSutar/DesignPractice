package com.example.hp.designpractice;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Development developement_frag;
    Design design_frag;
    Marking marking_frag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        developement_frag = new Development();
        design_frag = new Design();
        marking_frag = new Marking();

        BottomNavigationView nav = findViewById(R.id.nav);
        final FrameLayout content = findViewById(R.id.content_layout);
//change
        change_Fragment(developement_frag);

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.developement:
                        change_Fragment(developement_frag);
                        Animation a = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(a);
                        return true;
                    case R.id.design:
                        change_Fragment(design_frag);
                        Animation b = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(b);
                        return true;
                        case R.id.marking:
                        change_Fragment(marking_frag);
                        Animation c = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(c);
                        return true;
                   default:
                       return false;
                }
             
            }
        });
    }

    private void change_Fragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction3 .replace(R.id.content_layout,fragment);
        fragmentTransaction3.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.developement:
                Toast.makeText(MainActivity.this, "Developement", Toast.LENGTH_SHORT).show();
                break;
            case R.id.design:
                Toast.makeText(MainActivity.this, "Design", Toast.LENGTH_SHORT).show();
                break;
            case R.id.marking:
                Toast.makeText(MainActivity.this, "Marking", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

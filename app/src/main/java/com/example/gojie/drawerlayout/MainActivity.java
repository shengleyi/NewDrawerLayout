package com.example.gojie.drawerlayout;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.gojie.drawerlayout.R.id.drawer;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    private TextView tv_cen;


    private ListView listView;
    private String strings[] = {"三毛","三毛"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);

        initView();
    }

    private void initView(){
        drawerLayout = (DrawerLayout)findViewById(drawer);
        tv_cen = (TextView)findViewById(R.id.tv_center);
        viewPager = (ViewPager)findViewById(R.id.viewpager);

        tv_cen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });

        MyFragmentPagerAdapter adapter= new MyFragmentPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);

        listView = (ListView)drawerLayout.findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,strings));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,strings[position],Toast.LENGTH_LONG).show();
            }
        });

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


    }

    private void toggle(){
        int drawerLockMode = drawerLayout.getDrawerLockMode(GravityCompat.START);
        if(drawerLayout.isDrawerVisible(GravityCompat.START)&&(drawerLockMode!= DrawerLayout.LOCK_MODE_LOCKED_OPEN)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if(drawerLockMode!=DrawerLayout.LOCK_MODE_LOCKED_CLOSED){
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }
}

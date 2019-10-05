package com.ternakkita.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ternakkita.R;
import com.ternakkita.fragment.FragmentHome;
import com.ternakkita.fragment.FragmentSetting;
import com.ternakkita.fragment.FragmentTransaksi;

public class cls_landingPage extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_home:
                    FragmentHome fragmentHome = new FragmentHome();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content,fragmentHome);
                    fragmentTransaction.commit();
                    return true;
                case R.id.action_transaction:
                    FragmentTransaksi fragmentTransaksi = new FragmentTransaksi();
                    FragmentTransaction ft_transaksi = getSupportFragmentManager().beginTransaction();
                    ft_transaksi.replace(R.id.content,fragmentTransaksi);
                    ft_transaksi.commit();
                    return true;
                case R.id.action_setting:
                    FragmentSetting fragmentSetting = new FragmentSetting();
                    FragmentTransaction ft_setting = getSupportFragmentManager().beginTransaction();
                    ft_setting.replace(R.id.content,fragmentSetting);
                    ft_setting.commit();
                    return true;
            }
            return false;
        }
    };




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_landingpage);



        // bottom navigation
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.btm_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // First bottom navigation
        FragmentHome fragmentHome = new FragmentHome();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content,fragmentHome);
        fragmentTransaction.commit();
    }

}


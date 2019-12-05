package com.example.tablayout1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> mTitle;
    List<Fragment> mFragment;

    TabLayout mytab;
    ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytab = (TabLayout) findViewById(R.id.mytab);
//        mytab.addTab(mytab.newTab().setText("选项卡一").setIcon(R.mipmap.ic_launcher_round));
//        mytab.addTab(mytab.newTab().setText("选项卡二").setIcon(R.mipmap.ic_launcher_round));
//        mytab.addTab(mytab.newTab().setText("选项卡三").setIcon(R.mipmap.ic_launcher_round));
//        mytab.addTab(mytab.newTab().setText("选项卡四").setIcon(R.mipmap.ic_launcher_round));
//        mytab.addTab(mytab.newTab().setText("选项卡五").setIcon(R.mipmap.ic_launcher_round));
//        mytab.addTab(mytab.newTab().setText("选项卡六").setIcon(R.mipmap.ic_launcher_round));
//        mytab.addTab(mytab.newTab().setText("选项卡七").setIcon(R.mipmap.ic_launcher_round));

        mTitle = new ArrayList<String>();
        mTitle.add("选项卡一");
        mTitle.add("选项卡二");
        mTitle.add("选项卡三");
        mTitle.add("选项卡四");

        mFragment = new ArrayList<Fragment>();
        Fragment fm1 = new FragmentOne();
        Fragment fm2 = new FragmentTwo();
        Fragment fm3 = new FragmentThree();
        Fragment fm4 = new FragmentFour();
        mFragment.add(fm1);
        mFragment.add(fm2);
        mFragment.add(fm3);
        mFragment.add(fm4);

        viewpager = (ViewPager)findViewById(R.id.viewpager);

        viewpager.setOffscreenPageLimit(2);

        MyViewPagerAdapter mvpa = new MyViewPagerAdapter(getSupportFragmentManager());

        viewpager.setAdapter(mvpa);

        mytab.setupWithViewPager(viewpager);

        mytab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this,"你切换到了"+tab.getText(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

        public MyViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        public Fragment getItem(int positoin) {
            return mFragment.get(positoin);
        }

        public int getCount() {
            return mFragment.size();
        }

        public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
        }
    }
}

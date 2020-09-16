package com.telephone.coursetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class UserGuide extends AppCompatActivity {
    private ActionBar mActionBar;
    UserGuideAdapter userGuideAdapter;
    private ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guide);
        this.setTitle(R.string.user_guide);
        viewPager = (ViewPager2) findViewById(R.id.viewpage);
        final androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.user_guide);
        userGuideAdapter = new UserGuideAdapter();
        viewPager.setAdapter(userGuideAdapter);
    }


}




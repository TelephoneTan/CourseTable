package com.telephone.coursetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class WhiteListAdapter extends RecyclerView.Adapter<WhiteListAdapter.ViewHolder> {
    private List<String> mData;
    private List<String> cData;
    private LayoutInflater mInflater;
    private ViewPager2 viewPager2;
    private String whichpage;
    View view;


    public WhiteListAdapter(Context context, List<String> data, List<String> data1, ViewPager2 viewPager2, String whichpage) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.cData = data1;
        this.viewPager2 = viewPager2;
        this.whichpage=whichpage;
    }

    @NonNull
    @Override
    public WhiteListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       switch (whichpage){
           case "wiko":view = mInflater.inflate(R.layout.wiko_userguide_page, parent, false);break;
           case "huawei":view = mInflater.inflate(R.layout.huawei_userguide_page, parent, false);break;
           case "oneplus":view = mInflater.inflate(R.layout.oneplus_userguide_page, parent, false);break;
           case "samsung":  view = mInflater.inflate(R.layout.sansumg_userguide_page, parent, false);break;
           case "xiaomi":view = mInflater.inflate(R.layout.xiaomi_userguide_page, parent, false);break;
           case "asus":view = mInflater.inflate(R.layout.asus_userguide_page, parent, false);break;
           case "htc":view = mInflater.inflate(R.layout.htc_userguide_page, parent, false);break;
           case "lenovo":view = mInflater.inflate(R.layout.lenovo_userguide_page, parent, false);break;
           case "meizu":view = mInflater.inflate(R.layout.meizu_userguide_page, parent, false);break;
           case "nokia":view = mInflater.inflate(R.layout.nokia_userguide_page, parent, false);break;
           case "oppo":view = mInflater.inflate(R.layout.oppo_userguide_page, parent, false);break;
           case "sony":view = mInflater.inflate(R.layout.sony_userguide_page, parent, false);break;
           case "common":view = mInflater.inflate(R.layout.common_userguide_page, parent, false);break;
       }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WhiteListAdapter.ViewHolder holder, int position) {
        String animal = mData.get(position);
        String animal1 = cData.get(position);
        holder.myTextView.setText(animal);
        holder.myTextView2.setText(animal1);
        if(animal1.length()<120) {
            holder.myTextView2.setPadding(0, 10 , 0, 0);
            holder.myTextView2.setTextSize(20);
            holder.myTextView2.setLineSpacing(70, 0);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        TextView myTextView2;


        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textView2);
            myTextView2 = itemView.findViewById(R.id.textView3);

        }
    }
}


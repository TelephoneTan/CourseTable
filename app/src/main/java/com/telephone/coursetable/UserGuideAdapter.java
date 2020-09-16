package com.telephone.coursetable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserGuideAdapter extends RecyclerView.Adapter<UserGuideAdapter.ViewPagerViewHolder> {
    private ImageView[] mImageViews;
    private List<Integer> imgIdArray = new ArrayList<>();
    {
        imgIdArray.add(R.drawable.page0);
        imgIdArray.add(R.drawable.page1);
        imgIdArray.add(R.drawable.page2);
        imgIdArray.add(R.drawable.page3);
        imgIdArray.add(R.drawable.page4);
        imgIdArray.add(R.drawable.userguide_xiaobujian);
        imgIdArray.add(R.drawable.userguide_noclass);
        imgIdArray.add(R.drawable.userguide_hasclass);
    }
    private List<String> title = new ArrayList<>();
    {
        title.add("登录页面");
        title.add("课程表页面");
        title.add("个人信息及各功能页面");
        title.add("修改上课时间页面");
        title.add("更改学期周数页面");
        title.add("GUET课程表小部件");
        title.add("GUET课程表小部件");
        title.add("GUET课程表小部件");
}
    @NonNull
    @Override
    public UserGuideAdapter.ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.userguider_item, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserGuideAdapter.ViewPagerViewHolder holder, int position) {
        if(position==imgIdArray.size()){
            holder.textView3.setText("b");
            String S =String.valueOf(position+1)+"/"+String.valueOf(imgIdArray.size()+1);
            holder.textView2.setText(S);
            holder.imageView.setVisibility(View.GONE);
            holder.textView.setVisibility(View.GONE);
        }
        else {
            holder.imageView.setImageResource(imgIdArray.get(position));
            holder.textView.setText(title.get(position));
            String S =String.valueOf(position+1)+"/"+String.valueOf(imgIdArray.size()+1);
            holder.textView2.setText(S);
        }
    }

    @Override
    public int getItemCount() {
        return imgIdArray.size()+1;
    }

    public class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        public ViewPagerViewHolder(@NonNull View itemView){
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.pageinfo);
            textView2 = itemView.findViewById(R.id.pagenum);
            textView3 = itemView.findViewById(R.id.hugetextview);
        }
    }
}

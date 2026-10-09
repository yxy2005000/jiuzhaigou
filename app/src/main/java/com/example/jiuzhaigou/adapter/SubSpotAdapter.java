package com.example.jiuzhaigou.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.activity.SubSpotDetailActivity;
import com.example.jiuzhaigou.entity.SubSpot;
import java.util.List;

public class SubSpotAdapter extends RecyclerView.Adapter<SubSpotAdapter.ViewHolder> {

    private final Context context;
    private final List<SubSpot> subSpotList;

    public SubSpotAdapter(Context context, List<SubSpot> subSpotList) {
        this.context = context;
        this.subSpotList = subSpotList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sub_spot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubSpot subSpot = subSpotList.get(position);

        // 绑定 小景点图片 + 名称
        holder.ivSubImg.setImageResource(subSpot.getImgRes());
        holder.tvSubName.setText(subSpot.getName());

        // 点击跳转到详情页
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, SubSpotDetailActivity.class);
            // 传整个对象
            intent.putExtra("subSpot", subSpot);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return subSpotList.size();
    }

    // 条目控件
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSubImg;
        TextView tvSubName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSubImg = itemView.findViewById(R.id.iv_sub_img);
            tvSubName = itemView.findViewById(R.id.tv_sub_name);
        }
    }
}
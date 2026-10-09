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
import com.example.jiuzhaigou.activity.SubSpotListActivity;
import com.example.jiuzhaigou.entity.Spot;
import java.util.List;
import android.os.Bundle;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.ViewHolder> {
    private Context context;
    private List<Spot> list;

    public SpotAdapter(Context context, List<Spot> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_spot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Spot spot = list.get(position);
        holder.tvName.setText(spot.getName());
        holder.tvDesc.setText(spot.getDesc());
        holder.ivCover.setImageResource(spot.getCoverImgRes());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, SubSpotListActivity.class);
            // 用 Bundle 把数据传过去
            Bundle bundle = new Bundle();
            bundle.putString("spot_name", spot.getName());
            bundle.putString("spot_desc", spot.getDesc());
            // 注意：List 不能直接传，我们只传名字，在目标页再根据名字拿数据
            intent.putExtras(bundle);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDesc;
        ImageView ivCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.iv_spot_cover);
            tvName = itemView.findViewById(R.id.tv_spot_name);
            tvDesc = itemView.findViewById(R.id.tv_spot_desc);
        }
    }
}
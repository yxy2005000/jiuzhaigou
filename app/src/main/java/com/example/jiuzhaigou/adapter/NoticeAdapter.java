package com.example.jiuzhaigou.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.activity.NoticeDetailActivity;
import com.example.jiuzhaigou.entity.Notice;
import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {
    private Context context;
    private List<Notice> list;

    public NoticeAdapter(Context context, List<Notice> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_notice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notice notice = list.get(position);

        // 只显示这4个！
        holder.tvTitle.setText(notice.getTitle());
        holder.tvAuthor.setText("作者：" + notice.getAuthor());
        holder.tvType.setText("分类：" + notice.getType());
        holder.tvDate.setText(notice.getDate());

        // 点击跳转详情
        holder.itemView.setOnClickListener(v -> {
            NoticeDetailActivity.notice = list.get(position);
            context.startActivity(new Intent(context, NoticeDetailActivity.class));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAuthor, tvType, tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvType = itemView.findViewById(R.id.tv_type);
            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }
}
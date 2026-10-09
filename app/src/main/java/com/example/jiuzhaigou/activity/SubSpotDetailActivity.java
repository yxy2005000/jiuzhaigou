package com.example.jiuzhaigou.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.adapter.CommentAdapter;
import com.example.jiuzhaigou.entity.SubSpot;
import com.google.gson.Gson;

public class SubSpotDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_spot_detail);

        ImageView ivDetailImg = findViewById(R.id.iv_detail_img);
        TextView tvDetailName = findViewById(R.id.tv_detail_name);
        TextView tvDetailDesc = findViewById(R.id.tv_detail_desc);
        RecyclerView rvComments = findViewById(R.id.rv_comments);

        // 接收
        SubSpot subSpot = (SubSpot) getIntent().getSerializableExtra("subSpot");

        if (subSpot != null) {
            ivDetailImg.setImageResource(subSpot.getImgRes());
            tvDetailName.setText(subSpot.getName());
            tvDetailDesc.setText(subSpot.getDesc());

            // 留言
            CommentAdapter adapter = new CommentAdapter(this, subSpot.getCommentList());
            rvComments.setLayoutManager(new LinearLayoutManager(this));
            rvComments.setAdapter(adapter);
        }
    }
}
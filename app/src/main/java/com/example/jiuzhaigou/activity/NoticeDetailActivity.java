package com.example.jiuzhaigou.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.entity.Notice;

public class NoticeDetailActivity extends AppCompatActivity {
    public static Notice notice;

    private TextView tvTitle, tvAuthor, tvType, tvDate, tvContent;
    private ImageView ivDetailImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        tvTitle = findViewById(R.id.tv_title);
        tvAuthor = findViewById(R.id.tv_author);
        tvType = findViewById(R.id.tv_type);
        tvDate = findViewById(R.id.tv_date);
        tvContent = findViewById(R.id.tv_content);

        tvTitle.setText(notice.getTitle());
        tvAuthor.setText("作者：" + notice.getAuthor());
        tvType.setText("分类：" + notice.getType());
        tvDate.setText("日期：" + notice.getDate());
        tvContent.setText(notice.getContent());


    }
}
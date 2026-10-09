package com.example.jiuzhaigou.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.adapter.NoticeAdapter;
import com.example.jiuzhaigou.entity.Notice;
import java.util.List;

public class NoticeListActivity extends AppCompatActivity {
    public static List<Notice> noticeAllList;

    private RecyclerView rvAllNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);

        rvAllNotice = findViewById(R.id.rv_all_notice);
        NoticeAdapter adapter = new NoticeAdapter(this, noticeAllList);
        rvAllNotice.setLayoutManager(new LinearLayoutManager(this));
        rvAllNotice.setAdapter(adapter);
    }
}
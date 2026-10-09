package com.example.jiuzhaigou.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jiuzhaigou.R;
import java.util.HashSet;
import java.util.Set;

public class HotelActivity extends AppCompatActivity {

    private Button btnCollectHigh, btnCollectBoutique, btnCollectEconomy;
    private static final String HIGH = "高端酒店";
    private static final String BOUTIQUE = "精品民宿";
    private static final String ECONOMY = "经济型客栈";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        btnCollectHigh = findViewById(R.id.btn_collect_high);
        btnCollectBoutique = findViewById(R.id.btn_collect_boutique);
        btnCollectEconomy = findViewById(R.id.btn_collect_economy);

        initCollectStatus();

        btnCollectHigh.setOnClickListener(v -> toggleCollect(HIGH, btnCollectHigh));
        btnCollectBoutique.setOnClickListener(v -> toggleCollect(BOUTIQUE, btnCollectBoutique));
        btnCollectEconomy.setOnClickListener(v -> toggleCollect(ECONOMY, btnCollectEconomy));
    }

    private void initCollectStatus() {
        SharedPreferences sp = getSharedPreferences("CollectData", MODE_PRIVATE);
        Set<String> collectSet = sp.getStringSet("collectList", new HashSet<>());

        btnCollectHigh.setText(collectSet.contains(HIGH) ? "已收藏" : "收藏高端酒店");
        btnCollectBoutique.setText(collectSet.contains(BOUTIQUE) ? "已收藏" : "收藏精品民宿");
        btnCollectEconomy.setText(collectSet.contains(ECONOMY) ? "已收藏" : "收藏经济型客栈");
    }

    private void toggleCollect(String name, Button btn) {
        SharedPreferences sp = getSharedPreferences("CollectData", MODE_PRIVATE);
        Set<String> collectSet = new HashSet<>(sp.getStringSet("collectList", new HashSet<>()));

        if (collectSet.contains(name)) {
            collectSet.remove(name);
            btn.setText("收藏" + name);
            Toast.makeText(this, "取消收藏：" + name, Toast.LENGTH_SHORT).show();
        } else {
            collectSet.add(name);
            btn.setText("已收藏");
            Toast.makeText(this, "收藏成功：" + name, Toast.LENGTH_SHORT).show();
        }

        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet("collectList", collectSet);
        editor.apply();
    }
}
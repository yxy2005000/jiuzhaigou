package com.example.jiuzhaigou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jiuzhaigou.R;

public class BuyTicketActivity extends AppCompatActivity {

    private EditText etName, etPhone, etIdCard;
    private TextView tvType, tvPrice, tvDate, tvTime, tvTotal;
    private double price;
    private String type, date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etIdCard = findViewById(R.id.et_id_card);
        tvType = findViewById(R.id.tv_type);
        tvPrice = findViewById(R.id.tv_price);
        tvDate = findViewById(R.id.tv_date);
        tvTime = findViewById(R.id.tv_time_slot);
        tvTotal = findViewById(R.id.tv_total);

        type = getIntent().getStringExtra("type");
        price = getIntent().getDoubleExtra("price", 0);
        date = getIntent().getStringExtra("useDate");
        time = getIntent().getStringExtra("timeSlot");

        tvType.setText("票种：" + type);
        tvPrice.setText("单价：¥" + price);
        tvDate.setText("使用日期：" + date);
        tvTime.setText("入园时段：" + time);
        tvTotal.setText("总金额：¥" + price);

        findViewById(R.id.btn_confirm).setOnClickListener(v -> submit());
    }

    private void submit() {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String idCard = etIdCard.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(idCard)) {
            Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
            return;
        }

        // 购票成功 → 返回结果给Fragment
        Intent intent = new Intent();
        intent.putExtra("type", type);
        intent.putExtra("date", date);
        intent.putExtra("time", time);
        setResult(RESULT_OK, intent);

        Toast.makeText(this, "购票成功！\n姓名：" + name + "\n总金额：¥" + price, Toast.LENGTH_LONG).show();
        finish();
    }
}
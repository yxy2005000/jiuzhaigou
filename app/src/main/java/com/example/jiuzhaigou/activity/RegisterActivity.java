package com.example.jiuzhaigou.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jiuzhaigou.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText etNick, etName, etPhone, etCareer, etPwd;
    private RadioGroup rgGender;
    private CheckBox cbHiking, cbPhotography, cbFood;
    private Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNick = findViewById(R.id.et_nick);
        etName = findViewById(R.id.et_name);
        rgGender = findViewById(R.id.rg_gender);
        etPhone = findViewById(R.id.et_phone);
        etCareer = findViewById(R.id.et_career);
        cbHiking = findViewById(R.id.cb_hiking);
        cbPhotography = findViewById(R.id.cb_photography);
        cbFood = findViewById(R.id.cb_food);
        etPwd = findViewById(R.id.et_pwd);
        btnReg = findViewById(R.id.btn_reg);

        btnReg.setOnClickListener(v -> register());
    }

    private void register() {
        String nick = etNick.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String career = etCareer.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();

        // 性别处理
        String gender = "未知";
        if (rgGender.getCheckedRadioButtonId() == R.id.rb_male) {
            gender = "男";
        } else if (rgGender.getCheckedRadioButtonId() == R.id.rb_female) {
            gender = "女";
        }

        // 兴趣拼接
        StringBuilder interest = new StringBuilder();
        if (cbHiking.isChecked()) interest.append("徒步、");
        if (cbPhotography.isChecked()) interest.append("摄影、");
        if (cbFood.isChecked()) interest.append("美食、");
        String interestStr = interest.length() > 0 ? interest.substring(0, interest.length() - 1) : "无";

        // 校验
        if (nick.isEmpty() || name.isEmpty() || phone.isEmpty() || career.isEmpty() || pwd.isEmpty()) {
            Toast.makeText(this, "请完善所有信息", Toast.LENGTH_SHORT).show();
            return;
        }

        // ====================== 关键：保存所有字段 ======================
        SharedPreferences sp = getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nick", nick);       // 昵称
        editor.putString("pwd", pwd);         // 密码（用于登录）
        editor.putString("name", name);       // 姓名
        editor.putString("gender", gender);   // 性别
        editor.putString("phone", phone);     // 手机号
        editor.putString("career", career);   // 职业
        editor.putString("interest", interestStr); // 兴趣
        editor.apply();

        Toast.makeText(this, "注册成功！请登录", Toast.LENGTH_SHORT).show();
        finish();
    }
}
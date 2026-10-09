package com.example.jiuzhaigou.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.fragment.MineFragment;

public class EditInfoActivity extends AppCompatActivity {
    private EditText etNick, etName, etPhone, etCareer, etInterest;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        // 绑定控件
        etNick = findViewById(R.id.et_nick);
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        rgGender = findViewById(R.id.rg_gender);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        etCareer = findViewById(R.id.et_career);
        etInterest = findViewById(R.id.et_interest);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);

        // 初始化：读取原有信息填充到表单
        initOldInfo();

        // 保存按钮点击事件
        btnSave.setOnClickListener(v -> saveEditInfo());

        // 取消按钮点击事件
        btnCancel.setOnClickListener(v -> finish());
    }

    // 读取SharedPreferences中原有信息，填充到编辑表单
    private void initOldInfo() {
        SharedPreferences sp = getSharedPreferences("UserInfo", 0);
        etNick.setText(sp.getString("nick", "游客"));
        etName.setText(sp.getString("name", "张三"));
        String gender = sp.getString("gender", "男");
        if (gender.equals("男")) {
            rbMale.setChecked(true);
        } else {
            rbFemale.setChecked(true);
        }
        etPhone.setText(sp.getString("phone", "13800138000"));
        etCareer.setText(sp.getString("career", "职员"));
        etInterest.setText(sp.getString("interest", "徒步、摄影"));
    }

    // 保存修改后的信息到SharedPreferences
    private void saveEditInfo() {
        // 获取表单输入内容
        String nick = etNick.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String gender = rbMale.isChecked() ? "男" : "女";
        String phone = etPhone.getText().toString().trim();
        String career = etCareer.getText().toString().trim();
        String interest = etInterest.getText().toString().trim();

        // 简单校验（非空）
        if (nick.isEmpty() || name.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "昵称、姓名、手机号不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }

        // 保存到SP
        SharedPreferences sp = getSharedPreferences("UserInfo", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nick", nick);
        editor.putString("name", name);
        editor.putString("gender", gender);
        editor.putString("phone", phone);
        editor.putString("career", career);
        editor.putString("interest", interest);
        editor.apply();

        Toast.makeText(this, "信息修改成功！", Toast.LENGTH_SHORT).show();
        // 返回我的页面并刷新
        Intent intent = new Intent(this, MineFragment.class);
        setResult(RESULT_OK, intent);
        finish();
    }
}
package com.example.jiuzhaigou.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jiuzhaigou.R;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username, et_pwd;
    private Button btn_login;
    private TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);
        btn_login = findViewById(R.id.btn_login);
        tv_register = findViewById(R.id.tv_register);

        // 登录逻辑
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNick = et_username.getText().toString().trim();
                String inputPwd = et_pwd.getText().toString().trim();

                if (inputNick.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "请输入昵称", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (inputPwd.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 读取本地保存的注册信息
                SharedPreferences sp = getSharedPreferences("UserInfo", MODE_PRIVATE);
                String savedNick = sp.getString("nick", "");
                String savedPwd = sp.getString("pwd", "");

                // 支持：默认账号 + 注册账号 都能登录
                final String DEFAULT_USER = "user";
                final String DEFAULT_PWD = "123456";

                if ((inputNick.equals(DEFAULT_USER) && inputPwd.equals(DEFAULT_PWD)) ||
                        (inputNick.equals(savedNick) && inputPwd.equals(savedPwd))) {

                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "昵称或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 去注册
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
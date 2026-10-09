package com.example.jiuzhaigou.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.activity.EditInfoActivity;
import com.example.jiuzhaigou.activity.LoginActivity;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MineFragment extends Fragment {
    private TextView tvUserInfo;
    private Button btnEditInfo, btnLogout;
    private RadioGroup rgTicketType;
    private LinearLayout llTicketList, llMessageList, llCollectList;

    private List<String> ticketList = new ArrayList<String>() {{
        add("九寨沟门票成人票（未使用）-2025-01-01");
        add("九寨沟门儿童票（已使用）-2024-12-01");
        add("九寨沟门票成人票（未使用）-2025-02-01");
    }};
    private List<String> messageList = new ArrayList<String>() {{
        add("景区风景超棒！");
        add("门票兑换很方便");
        add("建议增加休息区");
    }};
    private List<String> collectList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        tvUserInfo = view.findViewById(R.id.tv_user_info);
        btnEditInfo = view.findViewById(R.id.btn_edit_info);
        rgTicketType = view.findViewById(R.id.rg_ticket_type);
        llTicketList = view.findViewById(R.id.ll_ticket_list);
        llMessageList = view.findViewById(R.id.ll_message_list);
        llCollectList = view.findViewById(R.id.ll_collect_list);
        btnLogout = view.findViewById(R.id.btn_logout);

        initUserInfo();
        initTicketList("全部");
        initMessageList();
        initCollectList();

        btnEditInfo.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditInfoActivity.class);
            startActivityForResult(intent, 100);
        });

        rgTicketType.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_all_ticket) {
                initTicketList("全部");
            } else if (checkedId == R.id.rb_used) {
                initTicketList("已使用");
            } else if (checkedId == R.id.rb_unused) {
                initTicketList("未使用");
            }
        });

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        return view;
    }

    // ====================== 关键修复：页面可见时自动刷新收藏 ======================
    @Override
    public void onResume() {
        super.onResume();
        initCollectList(); // 每次回到我的页面，自动刷新收藏
        initUserInfo();    // 同时刷新用户信息
    }

    private void initUserInfo() {
        try {
            SharedPreferences sp = getActivity().getSharedPreferences("UserInfo", 0);
            String nick = sp.getString("nick", "游客");
            String name = sp.getString("name", "张三");
            String gender = sp.getString("gender", "男");
            String phone = sp.getString("phone", "13800138000");
            String career = sp.getString("career", "职员");
            String interest = sp.getString("interest", "徒步、摄影");

            tvUserInfo.setText("昵称：" + nick +
                    "\n姓名：" + name +
                    "\n性别：" + gender +
                    "\n手机号：" + phone +
                    "\n职业：" + career +
                    "\n兴趣：" + interest);
        } catch (Exception e) {
            tvUserInfo.setText("昵称：游客\n姓名：张三\n性别：男\n手机号：13800138000\n职业：职员\n兴趣：徒步、摄影");
        }
    }

    private void initTicketList(String type) {
        llTicketList.removeAllViews();
        for (String ticket : ticketList) {
            if (type.equals("全部") || ticket.contains(type)) {
                LinearLayout itemLayout = new LinearLayout(getContext());
                itemLayout.setOrientation(LinearLayout.HORIZONTAL);
                itemLayout.setPadding(0, 10, 0, 10);

                TextView tvTicket = new TextView(getContext());
                tvTicket.setText(ticket);
                tvTicket.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

                itemLayout.addView(tvTicket);
                llTicketList.addView(itemLayout);
            }
        }
    }

    private void initMessageList() {
        llMessageList.removeAllViews();
        for (int i = 0; i < messageList.size(); i++) {
            int finalI = i;
            LinearLayout itemLayout = new LinearLayout(getContext());
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            itemLayout.setPadding(0, 10, 0, 10);

            TextView tvMsg = new TextView(getContext());
            tvMsg.setText(messageList.get(i));
            tvMsg.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            Button btnDel = new Button(getContext());
            btnDel.setText("删除");
            btnDel.setOnClickListener(v -> {
                messageList.remove(finalI);
                initMessageList();
                Toast.makeText(getContext(), "留言已删除", Toast.LENGTH_SHORT).show();
            });

            itemLayout.addView(tvMsg);
            itemLayout.addView(btnDel);
            llMessageList.addView(itemLayout);
        }
    }

    // ====================== 自动刷新的收藏列表 ======================
    private void initCollectList() {
        SharedPreferences sp = getActivity().getSharedPreferences("CollectData", 0);
        Set<String> collectSet = sp.getStringSet("collectList", new HashSet<>());

        collectList.clear();
        collectList.addAll(collectSet);

        llCollectList.removeAllViews();

        for (int i = 0; i < collectList.size(); i++) {
            int finalI = i;
            LinearLayout itemLayout = new LinearLayout(getContext());
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            itemLayout.setPadding(0, 10, 0, 10);

            TextView tvCollect = new TextView(getContext());
            tvCollect.setText(collectList.get(i));
            tvCollect.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            Button btnCancel = new Button(getContext());
            btnCancel.setText("取消收藏");
            btnCancel.setOnClickListener(v -> {
                String deleted = collectList.get(finalI);
                collectList.remove(finalI);

                SharedPreferences spCollect = getActivity().getSharedPreferences("CollectData", 0);
                SharedPreferences.Editor editor = spCollect.edit();
                Set<String> newSet = new HashSet<>(spCollect.getStringSet("collectList", new HashSet<>()));
                newSet.remove(deleted);
                editor.putStringSet("collectList", newSet);
                editor.apply();

                initCollectList();
                Toast.makeText(getContext(), "已取消收藏", Toast.LENGTH_SHORT).show();
            });

            itemLayout.addView(tvCollect);
            itemLayout.addView(btnCancel);
            llCollectList.addView(itemLayout);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == -1) {
            initUserInfo();
        }
    }
}
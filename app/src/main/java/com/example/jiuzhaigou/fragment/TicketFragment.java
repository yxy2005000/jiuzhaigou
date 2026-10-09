package com.example.jiuzhaigou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.activity.BuyTicketActivity;
import com.example.jiuzhaigou.adapter.TicketAdapter;
import com.example.jiuzhaigou.entity.Ticket;
import java.util.ArrayList;
import java.util.List;

public class TicketFragment extends Fragment {

    private RecyclerView rvTicket;
    private List<Ticket> ticketList;
    private TicketAdapter adapter;
    private Spinner spinnerDate, spinnerTime;
    private String selectedDate = "2026-05-15";
    private String selectedTime = "08:00~10:00";
    private static final int REQUEST_BUY = 1001; // 请求码

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket, container, false);

        spinnerDate = view.findViewById(R.id.spinner_date);
        spinnerTime = view.findViewById(R.id.spinner_time);
        rvTicket = view.findViewById(R.id.rv_ticket);

        initDateSpinner();
        initTimeSpinner();
        initData();

        // 点击购票 → 跳转并等待返回结果
        adapter.setOnBuyClickListener(position -> {
            Ticket ticket = ticketList.get(position);
            if (ticket.getRemain() <= 0) {
                Toast.makeText(getContext(), "票已售罄！", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(getActivity(), BuyTicketActivity.class);
            intent.putExtra("type", ticket.getType());
            intent.putExtra("price", ticket.getPrice());
            intent.putExtra("useDate", selectedDate);
            intent.putExtra("timeSlot", selectedTime);
            startActivityForResult(intent, REQUEST_BUY);
        });

        return view;
    }

    // 接收购票成功返回的结果 → 余票减1
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_BUY && resultCode == getActivity().RESULT_OK && data != null) {
            String type = data.getStringExtra("type");
            String date = data.getStringExtra("date");
            String time = data.getStringExtra("time");

            for (Ticket t : ticketList) {
                // 匹配 票种+日期+时段 → 精确扣减
                if (t.getType().equals(type)
                        && t.getUseDate().equals(date)
                        && t.getTimeSlot().equals(time)) {
                    if (t.getRemain() > 0) {
                        t.setRemain(t.getRemain() - 1);
                    }
                    break;
                }
            }
            adapter.notifyDataSetChanged(); // 刷新列表显示最新余票
        }
    }

    private void initDateSpinner() {
        String[] dates = {"2026-05-18", "2026-05-19", "2026-05-20", "2026-05-21"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, dates);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDate.setAdapter(adapter);
        spinnerDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedDate = (String) parent.getItemAtPosition(position);
                updateRemain();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void initTimeSpinner() {
        String[] times = {"08:00~10:00", "10:00~12:00", "12:00~14:00"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, times);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapter);
        spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTime = (String) parent.getItemAtPosition(position);
                updateRemain();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void initData() {
        ticketList = new ArrayList<>();
        ticketList.add(new Ticket(1, "成人票", 169, selectedDate, selectedTime, 100));
        ticketList.add(new Ticket(2, "学生票", 85, selectedDate, selectedTime, 80));
        ticketList.add(new Ticket(3, "老年票", 0, selectedDate, selectedTime, 120));

        adapter = new TicketAdapter(getActivity(), ticketList);
        rvTicket.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTicket.setAdapter(adapter);
    }

    private void updateRemain() {
        if (ticketList == null) return;
        for (Ticket t : ticketList) {
            t.setUseDate(selectedDate);
            t.setTimeSlot(selectedTime);
            switch (selectedTime) {
                case "08:00~10:00": t.setRemain(100); break;
                case "10:00~12:00": t.setRemain(80); break;
                case "12:00~14:00": t.setRemain(60); break;
            }
        }
        adapter.notifyDataSetChanged();
    }
}
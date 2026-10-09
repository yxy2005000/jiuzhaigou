package com.example.jiuzhaigou.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.entity.Ticket;
import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {
    private Context context;
    private List<Ticket> list;
    private OnBuyClickListener listener;

    public interface OnBuyClickListener {
        void onBuyClick(int position);
    }

    public void setOnBuyClickListener(OnBuyClickListener l) {
        this.listener = l;
    }

    public TicketAdapter(Context context, List<Ticket> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ticket ticket = list.get(position);
        holder.tvType.setText("票种：" + ticket.getType());
        holder.tvPrice.setText("价格：¥" + ticket.getPrice());
        holder.tvTime.setText("时段：" + ticket.getTimeSlot());
        holder.tvRemain.setText("剩余：" + ticket.getRemain() + "张");

        holder.btnBuy.setOnClickListener(v -> {
            if (listener != null) listener.onBuyClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvType, tvPrice, tvTime, tvRemain, btnBuy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tv_type);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvRemain = itemView.findViewById(R.id.tv_remain);
            btnBuy = itemView.findViewById(R.id.btn_buy);
        }
    }
}
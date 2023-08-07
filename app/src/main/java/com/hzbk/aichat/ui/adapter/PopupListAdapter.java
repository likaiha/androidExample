package com.hzbk.aichat.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.entity.SearchLocationBean;

import java.util.List;


/**
 * 首页adapter
 */
public class PopupListAdapter extends RecyclerView.Adapter<PopupListAdapter.ViewHolder> {
    private Context mContext;
    private List<SearchLocationBean.DataData> mDatas;

    public PopupListAdapter(Context context, List<SearchLocationBean.DataData> datas) {
        mDatas = datas;
        mContext = context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_popup_list_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(mDatas.get(position).getTitle());
        holder.province.setText(mDatas.get(position).getProvince() + "-" + mDatas.get(position).getCity() + "-" + mDatas.get(position).getDistrict());
        holder.llClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ItemClickListener != null) {
                    ItemClickListener.onItemClick(position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llClick;
        TextView title, province;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            province = itemView.findViewById(R.id.province);
            llClick = itemView.findViewById(R.id.llClick);
        }
    }


    /**
     * 条目点击监听
     * <br/> it can be used when click the bidding item.
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        ItemClickListener = listener;
    }

    private OnItemClickListener ItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


}

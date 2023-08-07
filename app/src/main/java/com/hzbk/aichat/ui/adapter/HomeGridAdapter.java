package com.hzbk.aichat.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.hzbk.aichat.R;
import com.hzbk.aichat.entity.HomeGoodsVipBean;
import com.hzbk.aichat.util.ImageUtils;

import java.util.List;


/**
 * 首页adapter
 */
public class HomeGridAdapter extends RecyclerView.Adapter<HomeGridAdapter.ViewHolder> {
    private Context mContext;
    private List<HomeGoodsVipBean.DataDTO> mDatas;

    public HomeGridAdapter(Context context, List<HomeGoodsVipBean.DataDTO> datas) {
        mDatas = datas;
        mContext = context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_home_grid_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvName.setText(mDatas.get(position).getTitle());
        holder.virtual_sales.setText(mDatas.get(position).getVirtual_sales() + "人购买");
        holder.tvDiscount_price.setText(mDatas.get(position).getDiscount_price());
//        holder.virtual_sales.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
//        holder.tvDiscount_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        ImageUtils.showImage(mContext, holder.iv_index_img, mDatas.get(position).getLogo());
        holder.llOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ItemClickListener != null) {
                    ItemClickListener.onItemClick(position);
                }
            }
        });
//        holder.ivCoullection.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ItemClickListener != null) {
//                    ItemClickListener.onCoullectionClick(position);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llOnclick;
        ImageView iv_index_img;
        TextView tvName, virtual_sales, tvDiscount_price;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDiscount_price = itemView.findViewById(R.id.tvDiscount_price);
            virtual_sales = itemView.findViewById(R.id.virtual_sales);
            iv_index_img = itemView.findViewById(R.id.iv_index_img);
            llOnclick = itemView.findViewById(R.id.rlOnclick);
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
//        void onPhoneClick(int position);
    }


}

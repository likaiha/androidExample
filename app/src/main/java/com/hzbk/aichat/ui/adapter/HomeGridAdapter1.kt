package com.hzbk.aichat.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hzbk.aichat.R
import com.hzbk.aichat.entity.HomeGoodsVipBean
import com.hzbk.aichat.util.ImageUtils

/**
 * 首页adapter
 */
class HomeGridAdapter1(
    private val mContext: Context,
    private val mDatas: List<HomeGoodsVipBean.DataDTO>
) : RecyclerView.Adapter<HomeGridAdapter1.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(mContext)
            .inflate(R.layout.item_home_grid_layout, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tvName.text = mDatas[position].title
        holder.virtual_sales.text = mDatas[position].virtual_sales + "人购买"
        holder.tvDiscount_price.text = mDatas[position].discount_price
//                holder.virtual_sales.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
//        holder.tvDiscount_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        ImageUtils.showImage(mContext, holder.iv_index_img, mDatas[position].logo)
        holder.llOnclick.setOnClickListener {
            if (ItemClickListener != null) {
                ItemClickListener!!.onItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var llOnclick: LinearLayout = itemView.findViewById(R.id.rlOnclick)
        var iv_index_img: ImageView = itemView.findViewById(R.id.iv_index_img)
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var virtual_sales: TextView = itemView.findViewById(R.id.virtual_sales)
        var tvDiscount_price: TextView = itemView.findViewById(R.id.tvDiscount_price)

    }

    /**
     * 条目点击监听
     * <br></br> it can be used when click the bidding item.
     *
     * @param listener
     */
    fun setOnItemClickListener(listener: OnItemClickListener?) {
        ItemClickListener = listener
    }

    private var ItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int) //        void onPhoneClick(int position);
    }
}
package com.hzbk.aichat.ui.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.hzbk.aichat.R;
import com.hzbk.aichat.entity.AIChatListBean;
import com.hzbk.aichat.util.ImageUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AIChatListAdapter extends BaseQuickAdapter<AIChatListBean.DataData.ListData, BaseViewHolder> {


    public AIChatListAdapter(List<AIChatListBean.DataData.ListData> mData) {
        super(R.layout.item_ai_chat_list, mData);
//        addChildClickViewIds(R.id.rlDetail);
//        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, AIChatListBean.DataData.ListData dataData) {

//        ImageUtils.RoundImage(getContext(), baseViewHolder.getView(R.id.iv_index_img),dataData.getHead_img(), 10);
        RelativeLayout chatting_left = baseViewHolder.getView(R.id.chatting_left);
        ImageView chatting_liv_img = baseViewHolder.getView(R.id.chatting_liv_img);
        TextView chatting_ltv_txt = baseViewHolder.getView(R.id.chatting_ltv_txt);


        RelativeLayout chatting_right = baseViewHolder.getView(R.id.chatting_right);
        ImageView chatting_riv_avatar = baseViewHolder.getView(R.id.chatting_riv_avatar);
        ImageView chatting_riv_img = baseViewHolder.getView(R.id.chatting_riv_img);
        TextView chatting_rtv_txt = baseViewHolder.getView(R.id.chatting_rtv_txt);

        chatting_left.setVisibility(View.GONE);
        chatting_right.setVisibility(View.GONE);
        if (dataData.getDirection().equals("1")) {//自己
            chatting_right.setVisibility(View.VISIBLE);
            chatting_rtv_txt.setVisibility(View.GONE);
            chatting_riv_img.setVisibility(View.GONE);
            ImageUtils.showImage(getContext(), chatting_riv_avatar, dataData.getUserLogo());
            if (dataData.getMessageType().equals("1")) {//文本
                chatting_rtv_txt.setVisibility(View.VISIBLE);
                chatting_rtv_txt.setText(dataData.getMessage());
            }
            if (dataData.getMessageType().equals("2")) {//图片
                chatting_riv_img.setVisibility(View.VISIBLE);
                ImageUtils.showImage(getContext(), chatting_riv_img, dataData.getMessage());
            }

        }

        if (dataData.getDirection().equals("2")) {//对方消息
            chatting_left.setVisibility(View.VISIBLE);
            chatting_liv_img.setVisibility(View.GONE);
            chatting_ltv_txt.setVisibility(View.GONE);
            if (dataData.getMessageType().equals("1")) {
                chatting_ltv_txt.setVisibility(View.VISIBLE);
                chatting_ltv_txt.setText(dataData.getMessage());
            }
            if (dataData.getMessageType().equals("2")) {
                chatting_liv_img.setVisibility(View.VISIBLE);
                ImageUtils.showImage(getContext(), chatting_liv_img, dataData.getMessage());
            }


        }


//        Glide.with(getContext())
//                .load("https://t7.baidu.com/it/u=1415984692,3889465312&fm=193&f=GIF")
//                .into((ImageView) baseViewHolder.getView(R.id.imageView));
//        baseViewHolder.setText(R.id.tv_name, dataData.getName());
//        baseViewHolder.setText(R.id.tv_distance, dataData.getDistance() + "km");

    }
}

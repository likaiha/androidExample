package com.hzbk.aichat.ui.fragment.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.TitleBarFragment;

import com.hzbk.aichat.entity.UserInfoBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;
import com.hzbk.aichat.other.SpBean;
import com.hzbk.aichat.ui.activity.HomeActivity;
import com.hzbk.aichat.ui.fragment.mine.activity.SetUpActivity;
import com.hzbk.aichat.util.GsonUtil;
import com.hzbk.aichat.util.ImageUtils;
import com.hzbk.aichat.util.LogUtils;
import com.hzbk.aichat.util.SPUtils;


import cc.taylorzhang.singleclick.SingleClickUtil;


public class MineFragment extends TitleBarFragment<HomeActivity> {
    private static final String TAG = "MineFragment";
    private final LModule module = new LModule();
    private RelativeLayout rlSetUp, rlInvitation, rlShop, rlOnline;
    private TextView frozen_balance, shopping_points, green_points, mobile, tv_stuName;
    private String shareCode;
    private ImageView iv_head, iv_partner;
    private String mobile1;
    private LinearLayout llOrder_1, llOrder_2, llOrder_3, llOrder_4, llBalance, llGreenPoints, llShoppingPoints;
    private RelativeLayout rlAllOrder;

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void initView() {
        iv_head = findViewById(R.id.iv_head);
        iv_partner = findViewById(R.id.iv_partner);//合伙人
        rlAllOrder = findViewById(R.id.rlAllOrder);
        llOrder_4 = findViewById(R.id.llOrder_4);
        llOrder_3 = findViewById(R.id.llOrder_3);
        llOrder_2 = findViewById(R.id.llOrder_2);
        llOrder_1 = findViewById(R.id.llOrder_1);
        llBalance = findViewById(R.id.llBalance);
        llShoppingPoints = findViewById(R.id.llShoppingPoints);
        llGreenPoints = findViewById(R.id.llGreenPoints);
        shopping_points = findViewById(R.id.shopping_points);
        frozen_balance = findViewById(R.id.frozen_balance);
        green_points = findViewById(R.id.green_points);
        mobile = findViewById(R.id.mobile);
        tv_stuName = findViewById(R.id.tv_stuName);
        rlSetUp = findViewById(R.id.rlSetUp);
        rlInvitation = findViewById(R.id.rlInvitation);
        rlShop = findViewById(R.id.rlShop);
        rlOnline = findViewById(R.id.rlOnline);
        SingleClickUtil.onSingleClick(rlSetUp, v -> {//设置
            startActivity(SetUpActivity.class);
        });
        SingleClickUtil.onSingleClick(llBalance, v -> {//余额
        });
        SingleClickUtil.onSingleClick(llGreenPoints, v -> {//绿色积分
        });
        SingleClickUtil.onSingleClick(llShoppingPoints, v -> {//购物积分
        });
        SingleClickUtil.onSingleClick(rlInvitation, v -> {//我的邀请

        });
        SingleClickUtil.onSingleClick(rlShop, v -> {//我的关注店铺

        });
        SingleClickUtil.onSingleClick(rlOnline, v -> {//客服
        });

        SingleClickUtil.onSingleClick(rlAllOrder, v -> {//全部订单
        });
        SingleClickUtil.onSingleClick(llOrder_1, v -> {//   待付款
        });
        SingleClickUtil.onSingleClick(llOrder_2, v -> {//   待收货
        });
        SingleClickUtil.onSingleClick(llOrder_3, v -> {//   已完成
        });
        SingleClickUtil.onSingleClick(llOrder_4, v -> {//   已取消
        });
    }

    @Override
    protected void initData() {
        GetData();
    }

    @Override
    public void onResume() {
        super.onResume();
        GetData();
        LogUtils.e(TAG, "token   --  " + SPUtils.getInstance().getString(SpBean.Token));
    }

    private void GetData() {
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}

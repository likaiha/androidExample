package com.hzbk.aichat.ui.fragment.sort;


import com.hzbk.aichat.R;
import com.hzbk.aichat.app.TitleBarFragment;
import com.hzbk.aichat.ui.activity.HomeActivity;


public class GroupFragment extends TitleBarFragment<HomeActivity> {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_group;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {


//        SingleClickUtil.onSingleClick(ivGroupItem3, v -> {//股
//        });
    }


    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    public static GroupFragment newInstance() {
        return new GroupFragment();
    }

}

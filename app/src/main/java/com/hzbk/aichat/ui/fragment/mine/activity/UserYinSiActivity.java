package com.hzbk.aichat.ui.fragment.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;

public class UserYinSiActivity extends AppActivity {
    private TextView ysTv;
    public static void start(Context context) {
        Intent intent = new Intent(context, UserYinSiActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_yinsi;
    }

    @Override
    protected void initView() {
        ysTv = findViewById(R.id.ys_tv);
        ysTv.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    protected void initData() {

    }
}

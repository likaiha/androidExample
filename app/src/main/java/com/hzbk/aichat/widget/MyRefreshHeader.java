package com.hzbk.aichat.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.hzbk.aichat.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;


/**
 * Created by leo on 2019/1/25.
 */
public class MyRefreshHeader extends LinearLayout implements RefreshHeader {


    private Context mContext;
    private TextView tv_des;
    private ImageView mAnimationImg;
    private AnimationDrawable refresh_anim;

    public MyRefreshHeader(Context context) {
        super(context);
        initView(context);
    }


    public MyRefreshHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyRefreshHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    /**
     * 获取真实视图（必须返回，不能为null）
     */
    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        start();
    }


    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        stop();
        return 0;
    }


    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {

        switch (newState) {
            case None:
            case PullDownToRefresh:
                tv_des.setText("下拉刷新");
                break;
            case Refreshing:
                tv_des.setText("正在刷新");
                break;
            case ReleaseToRefresh:
                tv_des.setText("释放刷新");
                break;
        }
    }


    private void initView(Context context) {
        this.mContext = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater != null) {
            View view = layoutInflater.inflate(R.layout.base_refresh_head, this);
            tv_des = (TextView) view.findViewById(R.id.tv_des);

            mAnimationImg = (ImageView) view.findViewById(R.id.iv_refresh_anim);
            refresh_anim = (AnimationDrawable) ContextCompat.getDrawable(mContext, R.drawable.progressbar);
            //refresh_anim.setOneShot(true);
            mAnimationImg.setImageDrawable(refresh_anim);
        }
    }

    private void start() {
        tv_des.setText("正在刷新");
        if (refresh_anim != null && !refresh_anim.isRunning()) {
            refresh_anim.start();
        }
    }

    private void stop() {
        tv_des.setText("刷新完成");
        if (refresh_anim != null && refresh_anim.isRunning()) {
            refresh_anim.stop();
        }
    }
}

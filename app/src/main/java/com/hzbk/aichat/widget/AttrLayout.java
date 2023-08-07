package com.hzbk.aichat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.hzbk.aichat.util.UiUtils;

import static android.view.View.MeasureSpec.AT_MOST;

public class AttrLayout extends LinearLayoutManager {
    Context mContext;
    public AttrLayout(Context context) {
        super(context);
        this.mContext =context;
    }

    public AttrLayout(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public AttrLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setMeasuredDimension(Rect childrenBounds, int wSpec, int hSpec) {
        super.setMeasuredDimension(childrenBounds, wSpec, View.MeasureSpec.makeMeasureSpec(UiUtils.dp2px(mContext,246), AT_MOST));
    }
}

package com.hzbk.aichat.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.action.SingleClick;
import com.hzbk.aichat.app.base.BaseDialog;


/**
 * 选择性别
 */
public final class ChoiceSexDialog {

    public static final class Builder extends BaseDialog.Builder<Builder> {
        private final TextView tv_menu_cancel;
        private final LinearLayout ll_man, ll_woman;
        private RadioButton rb_man, rb_woman;

        public Builder(Context context) {
            super(context);

            setContentView(R.layout.dialog_bottom_select_sex);
            setAnimStyle(BaseDialog.ANIM_BOTTOM);
            setCancelable(true);

            rb_man = findViewById(R.id.rb_man);
            ll_man = findViewById(R.id.ll_man);
            rb_woman = findViewById(R.id.rb_woman);
            ll_woman = findViewById(R.id.ll_woman);
            tv_menu_cancel = findViewById(R.id.tv_menu_cancel);
            ll_man.setOnClickListener(this);
            ll_woman.setOnClickListener(this);
            tv_menu_cancel.setOnClickListener(this);
        }

        private OnListener mListener;

        public Builder setListener(OnListener listener) {
            mListener = listener;
            return this;
        }

        /**
         * 设置数量
         */
        public Builder setMan(boolean mBoolean) {
            if (mBoolean) {
                rb_man.setChecked(true);
                rb_woman.setChecked(false);
            } else {
                rb_man.setChecked(false);
                rb_woman.setChecked(true);
            }

            return this;
        }

        @SingleClick
        @Override
        public void onClick(View view) {
            if (view == ll_man) {//
                if (mListener != null) {
                    mListener.onConfirm(true);//
                    rb_man.setChecked(true);
                    rb_woman.setChecked(false);
                    dismiss();
                }
            } else if (view == ll_woman) {
                if (mListener != null) {
                    rb_man.setChecked(false);
                    rb_woman.setChecked(true);
                    mListener.onConfirm(false);//
                    dismiss();
                }
            } else if (view == tv_menu_cancel) {

                dismiss();
            }
        }
    }

    public interface OnListener {

        /**
         * 点击确定时回调
         */
        void onConfirm(boolean mBoolean);

    }


}

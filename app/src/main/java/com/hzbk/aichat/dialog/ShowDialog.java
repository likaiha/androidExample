package com.hzbk.aichat.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.action.SingleClick;
import com.hzbk.aichat.app.base.BaseDialog;


public final class ShowDialog {

    public static final class Builder extends BaseDialog.Builder<Builder> {
        private final TextView btn_exit, btn_enter, tv_note;

        public Builder(Context context) {
            super(context);
            setContentView(R.layout.dialog_show);
            setAnimStyle(BaseDialog.ANIM_BOTTOM);
            setCancelable(true);
            btn_exit = findViewById(R.id.btn_exit);
            btn_enter = findViewById(R.id.btn_enter);
            tv_note = findViewById(R.id.tv_note);
            btn_enter.setOnClickListener(this);
            btn_exit.setOnClickListener(this);
        }

        private OnListener mListener;

        public Builder setListener(OnListener listener) {
            mListener = listener;
            return this;
        }

        public Builder setTitle(String title) {
            tv_note.setText(title);
            return this;
        }


        @SingleClick
        @Override
        public void onClick(View view) {
            if (view == btn_enter) {//
                if (mListener != null) {
                    mListener.onClick();
                    dismiss();
                }
            } else if (view == btn_exit) {
                dismiss();
            }
        }
    }

    public interface OnListener {
        void onClick();

    }


}

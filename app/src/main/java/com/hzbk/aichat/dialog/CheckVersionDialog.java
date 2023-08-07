package com.hzbk.aichat.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.action.SingleClick;
import com.hzbk.aichat.app.base.BaseDialog;


public final class CheckVersionDialog {

    public static final class Builder extends BaseDialog.Builder<Builder> {
        private final TextView tvVersion, btnSure, tvDescription;

        public Builder(Context context) {
            super(context);
            setContentView(R.layout.check_version_show);
            setCancelable(false);
            tvVersion = findViewById(R.id.tvVersion);
            btnSure = findViewById(R.id.btnSure);
            tvDescription = findViewById(R.id.tvDescription);
            btnSure.setOnClickListener(this);
            tvVersion.setOnClickListener(this);
        }

        private OnListener mListener;

        public Builder setListener(OnListener listener) {
            mListener = listener;
            return this;
        }

        public Builder setDescription(String description) {
            tvDescription.setText(description);
            return this;
        }

        public Builder setVersion(String version) {
            tvVersion.setText(version);
            return this;
        }


        @SingleClick
        @Override
        public void onClick(View view) {
            if (view == btnSure) {//
                if (mListener != null) {
                    mListener.onClick();
                    dismiss();
                }
            }
        }
    }

    public interface OnListener {
        void onClick();

    }


}

package com.hzbk.aichat.ui.fragment.home.activity;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.entity.AIChatListBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.ui.adapter.AIChatListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.impl.ScrollBoundaryDeciderAdapter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AIChatActivity extends AppActivity {
    private RecyclerView recyclerView;
    private SmartRefreshLayout normalView;
    private AIChatListAdapter mAdapter;
    private List<AIChatListBean.DataData.ListData> mData = new ArrayList<>();
    private LModule module = new LModule();
    private int page = 1;
    private EditText etMsg;
    private TextView tvSendMsg;
    private ImageView ivAddImg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_aichat;
    }

    @Override
    protected void initView() {
//        ImmersionBar.with(this)
//                .statusBarDarkFont(true)
//                .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
//                .statusBarColor(R.color.color_FF3D4042)
//                .init();


        Objects.requireNonNull(getTitleBar()).setLineVisible(false);
        recyclerView = findViewById(R.id.recycle_view);
        normalView = findViewById(R.id.normal_view);
        etMsg = findViewById(R.id.etMsg);
//        ivAddImg = findViewById(R.id.ivAddImg);
        tvSendMsg = findViewById(R.id.tvSendMsg);
        ivAddImg.setOnClickListener(this);
        tvSendMsg.setOnClickListener(this);
        ClassicsFooter footer = findViewById(R.id.footer);
        View arrow = footer.findViewById(ClassicsFooter.ID_IMAGE_ARROW);
        arrow.setScaleY(-1);//必须设
        setRefresh();
        etMsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    tvSendMsg.setVisibility(View.VISIBLE);
                    ivAddImg.setVisibility(View.GONE);
                } else {
                    ivAddImg.setVisibility(View.VISIBLE);
                    tvSendMsg.setVisibility(View.GONE);
                }

            }
        });
    }

    private void SendMsg(String msg, String messageType) {
//        module.sendMessage(msg, messageType, new MCallback() {
//            @Override
//            public void onSuccess(String response) {
//                LogUtils.e("sendMessage ", "sendMessage  --->   " + response);
//                toast("发送成功");
//                MessageListBean.DataData.ListData addList = new MessageListBean.DataData.ListData();
//
//                addList.setMessageType(messageType);
//                addList.setMessage(getMsg());
//                addList.setDirection("1");
//                addList.setUserLogo(SPUtils.getInstance().getString(SpBean.logo));
//                mData.add(addList);
//                mAdapter.notifyDataSetChanged();
//                etMsg.setText("");
//
//            }
//
//            @Override
//            public void onError(String msg, String status) {
//
//            }
//
//            @Override
//            public void onFailed(Exception e) {
//
//            }
//        });
    }

    /**
     * SmartRefreshLayout刷新加载
     */
    private void setRefresh() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new AIChatListAdapter(mData);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setScaleY(-1);//必须设置
        normalView.setEnableRefresh(false);//必须关闭
        normalView.setEnableAutoLoadMore(true);//必须关闭
        normalView.setEnableNestedScroll(false);//必须关闭
        //软键盘弹出RecyclerView会随之上移
        linearLayoutManager.setStackFromEnd(true);
//        normalView.setStackFromEnd(true);
        normalView.setEnableScrollContentWhenLoaded(true);//必须关闭
        normalView.getLayout().setScaleY(-1);//必须设置
        normalView.setScrollBoundaryDecider(new ScrollBoundaryDeciderAdapter() {
            @Override
            public boolean canLoadMore(View content) {
                return super.canRefresh(content);//必须替换
            }
        });

        //监听加载，而不是监听 刷新
        normalView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        mAdapter.insert(GetData());//加载更多

                        normalView.finishLoadMore();
                    }
                }, 2000);
            }
        });

        normalView.setOnRefreshListener(new OnRefreshListener() {
            //下拉刷新
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
//                page = 1;
//                getData(true, page);
                refreshlayout.finishRefresh(2000);
            }
        });
    }

    private String getMsg() {
        return etMsg.getText().toString().trim();
    }

    @Override
    protected void initData() {
//        module.dialogueList(page + "", new MCallback() {
//            @Override
//            public void onSuccess(String response) {
//                MessageListBean messageListBean = GsonUtil.GsonToBean(response, MessageListBean.class);
//                List<MessageListBean.DataData.ListData> MsgList = messageListBean.getData().getList();
//                if (page == 1) {
//                    mData.addAll(MsgList);
//                } else {
//                    mData.addAll(0, MsgList);
//                }
//                mAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onError(String msg, String status) {
//
//            }
//
//            @Override
//            public void onFailed(Exception e) {
//
//            }
//
//        });
    }
}
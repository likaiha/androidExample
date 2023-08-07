package com.hzbk.aichat.ui.fragment.home;

import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.gongwen.marqueen.SimpleMarqueeView;
import com.hzbk.aichat.R;
import com.hzbk.aichat.app.TitleBarFragment;
import com.hzbk.aichat.dialog.CheckVersionDialog;
import com.hzbk.aichat.entity.CheckVersionBean;
import com.hzbk.aichat.entity.HomeGoodsVipBean;
import com.hzbk.aichat.entity.HomeInformationBean;
import com.hzbk.aichat.http.LModule;
import com.hzbk.aichat.http.MCallback;
import com.hzbk.aichat.ui.activity.HomeActivity;
import com.hzbk.aichat.ui.adapter.HomeGridAdapter;
import com.hzbk.aichat.util.GsonUtil;
import com.hzbk.aichat.util.LogUtils;
import com.hzbk.aichat.util.Utils;
import com.king.app.dialog.AppDialog;
import com.king.app.dialog.AppDialogConfig;
import com.king.app.updater.AppUpdater;
import com.king.app.updater.callback.AppUpdateCallback;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends TitleBarFragment<HomeActivity> implements View.OnClickListener {

    private static final String TAG = " HomeFragment";
    private AppUpdater mAppUpdater;
    private SmartRefreshLayout normalView;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private List<HomeGoodsVipBean.DataDTO> mGridData = new ArrayList<>();
    private HomeGridAdapter mGridAdapter;
    private RecyclerView recycle_grid;
    private LModule module = new LModule();
    private SimpleMarqueeView<String> marqueeView;
    private List<HomeInformationBean> mData = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }


    @Override
    protected void initView() {
        Objects.requireNonNull(getTitleBar()).setLineVisible(false);
        marqueeView = findViewById(R.id.simpleMarqueeView);
        recycle_grid = findViewById(R.id.recycle_grid);

        normalView = findViewById(R.id.normal_view);
        setRefresh();
//        SingleClickUtil.onSingleClick(ll_type_1, v -> {//  VIP专区
//
//        });


    }


    /**
     * SmartRefreshLayout刷新加载
     */
    private void setRefresh() {
        normalView.setOnRefreshListener(new OnRefreshListener() {
            //下拉刷新
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
//                GetData(true, page = 1);
                initGridData("1");
                refreshlayout.finishRefresh(2000);
            }
        });
        normalView.setEnableLoadMore(false);
//        normalView.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                page++;
//                GetData(false, page);
//                refreshLayout.finishLoadMore(2000);
//            }
//        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            if (marqueeView != null) {
                marqueeView.stopFlipping();
            }
        } else {
            if (marqueeView != null) {
                marqueeView.startFlipping();
            }
        }
    }

    @Override
    protected void initData() {
//        GetBanner();
//        initGridData("1");
//        getCheckVersion();
    }

    private void getCheckVersion() {
        module.checkApp(Utils.getVersionCode(getApplication()) + "", new MCallback() {
            @Override
            public void onSuccess(String response) {
                LogUtils.e("checkApp", "checkApp  - getCategoryPostLists-- " + response);
                CheckVersionBean checkVersionBean = GsonUtil.GsonToBean(response, CheckVersionBean.class);
                CheckVersionBean.DataDat data = checkVersionBean.getData();
                down(data.getDownload_url(), data.getDescription(), data.getVersion_num());//下载链接 描述
            }

            @Override
            public void onError(String msg, String status) {

            }

            @Override
            public void onFailed(Exception e) {

            }
        });


    }


    private void down(String downloadUrl, String description, String version_num) {
        new CheckVersionDialog.Builder(getActivity())
                .setVersion("V" + version_num)
                .setDescription(description)
                .setListener(new CheckVersionDialog.OnListener() {
                    @Override
                    public void onClick() {
                        mAppUpdater = new AppUpdater.Builder()
                                .setUrl(downloadUrl)
                                .build(getApplication())
                                .setUpdateCallback(new AppUpdateCallback() {
                                    @Override
                                    public void onStart(String url) {
                                        super.onStart(url);
                                        // 模仿系统自带的横幅通知效果
                                        AppDialogConfig config = new AppDialogConfig(requireActivity(), R.layout.dialog_heads_up);
                                        config.setStyleId(R.style.app_dialog_heads_up)
                                                .setWidthRatio(0.95f)
                                                .setGravity(Gravity.TOP);
                                        AppDialog.INSTANCE.showDialog(getActivity(), config);
                                        new CountDownTimer(2000, 500) {

                                            @Override
                                            public void onTick(long millisUntilFinished) {

                                            }

                                            @Override
                                            public void onFinish() {
                                                AppDialog.INSTANCE.dismissDialog();
                                            }
                                        }.start();
                                    }

                                    @Override
                                    public void onProgress(long progress, long total, boolean isChange) {

                                    }

                                    @Override
                                    public void onFinish(File file) {
//                                        showToast("下载完成");
                                        toast("下载完成");
                                    }
                                });
                        mAppUpdater.start();
                    }
                })
                .show();
    }


    private void initGridData(String type) {
        module.indexProduct(type, new MCallback() {
            @Override
            public void onSuccess(String response) {

                LogUtils.e("HomeFragment", "HomeFragment  - indexProduct-- " + response);
                HomeGoodsVipBean homeGoodsVipBean = GsonUtil.GsonToBean(response, HomeGoodsVipBean.class);
                List<HomeGoodsVipBean.DataDTO> data = homeGoodsVipBean.getData();
                mGridData.clear();
                mGridData.addAll(data);
                mGridAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String msg, String status) {

            }

            @Override
            public void onFailed(Exception e) {

            }
        });

    }

    private void initGridView() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycle_grid.setLayoutManager(layoutManager);
        mGridAdapter = new HomeGridAdapter(getActivity(), mGridData);
//        recycle_grid.addItemDecoration(new ItemGridDecoration(getActivity(), UiUtils.dip2px(4), R.color.color_F4F4F4));
        recycle_grid.setAdapter(mGridAdapter);
        mGridAdapter.setOnItemClickListener(new HomeGridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
    }


    @Override
    public boolean isStatusBarEnabled() {

        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}

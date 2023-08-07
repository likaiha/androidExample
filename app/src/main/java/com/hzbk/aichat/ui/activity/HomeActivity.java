package com.hzbk.aichat.ui.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;
import com.hzbk.aichat.R;
import com.hzbk.aichat.app.AppActivity;
import com.hzbk.aichat.entity.BusHomeEvent;
import com.hzbk.aichat.entity.BusHomePosEvent;
import com.hzbk.aichat.other.AppConfig;
import com.hzbk.aichat.ui.fragment.home.HomeFragment;
import com.hzbk.aichat.ui.fragment.mine.MineFragment;
import com.hzbk.aichat.ui.fragment.sort.GroupFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppActivity {
    private static final String INTENT_KEY_IN_FRAGMENT_INDEX = "fragmentIndex";
    private List<Fragment> mFragmentList = new ArrayList<>();
    private FrameLayout mFlContent;
    private BottomBarLayout mBottomBarLayout;
    private int position = 0;
    //    private LModule module = new LModule();
    private String unreadSize;
    private int lastIndex;
    private int[] mNormalIconIds = new int[]{
            R.mipmap.home_n,
            R.mipmap.group_n,
//            R.mipmap.home_shop_cart_n,
            R.mipmap.mine_n
    };

    public static void start(Context context, int Id) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.putExtra(AppConfig.ID, Id);
        context.startActivity(intent);
    }


    private int[] mSelectedIconIds = new int[]{
            R.mipmap.home_s,
            R.mipmap.group_s,
            R.mipmap.mine_s
    };
    private int[] mTitleIds = new int[]{
            R.string.home_nav_index,
            R.string.home_nav_found,
            R.string.home_nav_me
    };


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        mFlContent = findViewById(R.id.fl_content);
        mBottomBarLayout = findViewById(R.id.bbl);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < mTitleIds.length; i++) {
            //创建item
            BottomBarItem item = createBottomBarItem(i);
            mBottomBarLayout.addItem(item);
//            Fragment homeFragment = createFragment(mTitleIds[i]);
        }

        mFragmentList.add(HomeFragment.newInstance());
        mFragmentList.add(GroupFragment.newInstance());
//        mFragmentList.add(ShopCartFragment.newInstance());
        mFragmentList.add(MineFragment.newInstance());
        setFragmentPosition(0); //默认显示第一页
        initListener();
    }



    private BottomBarItem createBottomBarItem(int i) {
        BottomBarItem item = new BottomBarItem.Builder(this)
                .titleTextBold(false)
                .titleTextSize(12)
                .msgTextSize(11)
                .iconHeight(60)
                .iconWidth(60)
                .titleNormalColor(R.color.color_969696)
                .titleSelectedColor(R.color.color_ae2b2b)
                .marginTop(10)
                //              .openTouchBg(false)
//                              .itemPadding(2)
//                              .unreadNumThreshold(99)
                //              .unreadTextColor(R.color.white)

                //还有很多属性，详情请查看Builder里面的方法
                //There are still many properties, please see the methods in the Builder for details.
                .create(mNormalIconIds[i], mSelectedIconIds[i], getString(mTitleIds[i]));
        return item;
    }

    private void initListener() {
        mBottomBarLayout.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final BottomBarItem bottomBarItem, int previousPosition, final int currentPosition) {
                Log.i("MainActivity", "position: " + currentPosition);
                position = currentPosition;
//                changeFragment(currentPosition);
                setFragmentPosition(currentPosition);
            }
        });
//        mBottomBarLayout.setUnread(0, 20);//设置第一个页签的未读数为20
//        mBottomBarLayout.setUnread(2, unreadSize);
    }

    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = mFragmentList.get(position);
        Fragment lastFragment = mFragmentList.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.fl_content, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }

    private long exitTime = 0;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHomeEvent(BusHomeEvent event) {}

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHomePosEvent(BusHomePosEvent event) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
//                Intent intent2 = new Intent("com.gh.ts.destroy");
//                sendBroadcast(intent2);
//                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // 恢复当前 Fragment 索引位置
        setFragmentPosition(savedInstanceState.getInt(INTENT_KEY_IN_FRAGMENT_INDEX));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setFragmentPosition(lastIndex);
    }

}
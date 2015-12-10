package com.luzhuo.android5widget.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.luzhuo.android5widget.R;
import com.luzhuo.android5widget.adapter.GridAdapter;

/**
 * =================================================
 * 
 * 作者:卢卓
 * 
 * 版本:1.0
 * 
 * 创建日期:2015-12-9 下午10:32:48
 * 
 * 描述:下拉刷新的案例
 * 
 * 修订历史:
 * 
 * 
 * =================================================
 **/
public class SwipeRefreshLayoutDemo extends Activity implements OnRefreshListener {
	private SwipeRefreshLayout refreshLayout;
	private RecyclerView recycler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe);
		initView();
		initData();
	}

	private void initView() {
		refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
		recycler = (RecyclerView) findViewById(R.id.recycler);
	}

	private void initData() {
		// 下拉刷新
        refreshLayout.setOnRefreshListener(this); // 设置刷新监听
        refreshLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.purple); // 进度动画颜色
        refreshLayout.setProgressBackgroundColorSchemeResource(R.color.swipefefresh_bg); // 进度背景颜色
        
        // RecycleView
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new GridAdapter(this,true));
	}

	@Override
	public void onRefresh() {
        refreshLayout.postDelayed(new Runnable() { // 发送延迟消息到消息队列
            @Override
            public void run() {
                refreshLayout.setRefreshing(false); // 是否显示刷新进度;false:不显示
            }
        },3000);
	}
}

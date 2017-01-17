/* Copyright 2015 Luzhuo. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.luzhuo.android50newwidget.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import me.luzhuo.android50newwidget.R;
import me.luzhuo.android50newwidget.adapter.GridAdapter;
import me.luzhuo.android50newwidget.utils.Utils;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2015/12/9 22:32:48
 * <p>
 * Description: 下拉刷新的案例
 * <p>
 * Revision History:
 * <p>
 * Copyright: Copyright 2016 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public class SwipeRefreshLayoutDemo extends AppCompatActivity implements OnRefreshListener {
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
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new GridAdapter(this, true, Utils.IMAGECONTENTS));
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

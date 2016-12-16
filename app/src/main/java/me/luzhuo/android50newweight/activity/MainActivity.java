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
package me.luzhuo.android50newweight.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;

import me.luzhuo.android50newweight.R;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2015/12/6
 * <p>
 * Description: 首页
 * <p>
 * Revision History: 1. 2016.12.16 设置状态栏颜色, 让其更符合MD风格
 * <p>
 * Copyright: Copyright 2016 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public class MainActivity extends AppCompatActivity implements OnClickListener {
	private Toolbar toolbar;
	private CardView toolBar;
	private CardView cardView;
	private CardView recyclerView;
	private CardView swipeRefreshLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}

	private void initView() {
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolBar = (CardView) findViewById(R.id.ToolBar);
		cardView = (CardView) findViewById(R.id.CardView);
		recyclerView = (CardView) findViewById(R.id.RecyclerView);
		swipeRefreshLayout = (CardView) findViewById(R.id.SwipeRefreshLayout);
		
		toolBar.setOnClickListener(this);
		cardView.setOnClickListener(this);
		recyclerView.setOnClickListener(this);
		swipeRefreshLayout.setOnClickListener(this);
	}
	
	private void initData() {
		setSupportActionBar(toolbar);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.ToolBar:
			intent = new Intent(this, ToolBarDemo.class);
			break;
		case R.id.CardView:
			intent = new Intent(this, CardViewDemo.class);
			break;
		case R.id.RecyclerView:
			intent = new Intent(this, RecyclerViewDemo.class);
			break;
		case R.id.SwipeRefreshLayout:
			intent = new Intent(this, SwipeRefreshLayoutDemo.class);
			break;
		}
		startActivity(intent);
	}

}

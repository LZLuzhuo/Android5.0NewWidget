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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import me.luzhuo.android50newweight.R;
import me.luzhuo.android50newweight.adapter.RecycleAdapter;
import me.luzhuo.android50newweight.utils.Utils;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2015/12/6 20:11:26
 * <p>
 * Description:
 * <p>
 * Revision History:
 * 			1. 2016.12.16 修改了 {@code RecycleAdapter.OnItemClickListener} 接口中的方法接收的参数不规范.<br>
 *     		2. 2016.12.16 修改了 {@code RecycleAdapter} 的数据存放位置, 使其更符合日常规范.
 * <p>
 * Copyright: Copyright 2016 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public class RecyclerViewDemo extends AppCompatActivity {
	private RecyclerView recycle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recyclerview);
		initView();
		initData();
	}
	
	private void initView() {
		recycle = (RecyclerView) findViewById(R.id.recycle);
	}

	private void initData() {
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(RecyclerView.VERTICAL);
		recycle.setLayoutManager(layoutManager);
		RecycleAdapter adapter = new RecycleAdapter(this, Utils.TEXTCONTENTS);
		recycle.setAdapter(adapter);
		
		adapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				// 打开子条目演示活动
				Intent intent = new Intent(RecyclerViewDemo.this, RecyclerViewItemDemo.class);
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});
	}
}

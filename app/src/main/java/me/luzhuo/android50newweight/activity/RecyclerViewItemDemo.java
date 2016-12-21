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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import me.luzhuo.android50newweight.R;
import me.luzhuo.android50newweight.adapter.GridAdapter;
import me.luzhuo.android50newweight.adapter.ListAdapter;
import me.luzhuo.android50newweight.adapter.StaggeredGridAdapter;
import me.luzhuo.android50newweight.utils.Utils;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2015/12/7 16:48:50
 * <p>
 * Description: 对纵向/横向列表,纵向/横向网格,纵向/横向瀑布流的演示用的布局,详细代码请{@link RecyclerViewItemDemo}.
 * <p>
 * Revision History: 1. 2016.12.16 修改适配器的数据获取方式, 使其更符合规范.
 * <p>
 * Copyright: Copyright 2016 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public class RecyclerViewItemDemo extends AppCompatActivity {
	private Toolbar recycle_toolbar;
	private int extra;
	private RecyclerView recycle_item;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recyclerview_item);
		extra = getIntent().getIntExtra("position", -1);
		initView();
		initData();
	}

	private void initView() {
		recycle_toolbar = (Toolbar) findViewById(R.id.recycle_item_toolbar);
		recycle_item = (RecyclerView) findViewById(R.id.recycle_item);
	}

	private void initData() {
		if(extra == -1) return;

		// 设置toolbar的标题
		recycle_toolbar.setTitle("RecyclerView--" + Utils.TEXTCONTENTS[extra]);
		
		// 列表布局
		if(extra == 0 || extra == 1){
	        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
	        layoutManager.setOrientation(extra == 1 ? RecyclerView.HORIZONTAL : RecyclerView.VERTICAL);
	        recycle_item.setLayoutManager(layoutManager);
	        recycle_item.setAdapter(new ListAdapter(this, extra == 0 ? true : false, Utils.IMAGECONTENTS));
			return;
		}
		
		// 网格布局
		if(extra == 2 || extra == 3){
			GridLayoutManager layoutManager = new GridLayoutManager(this, 3); //第二个参数是列数
	        layoutManager.setOrientation(extra == 3 ? RecyclerView.HORIZONTAL : RecyclerView.VERTICAL);
	        recycle_item.setLayoutManager(layoutManager);
	        recycle_item.setAdapter(new GridAdapter(this, extra == 2 ? true : false, Utils.IMAGECONTENTS));
	        return;
		}
		
		//瀑布流布局
		if(extra == 4 || extra == 5){
			// 第一个参数:列数;第二个参数排列方式
	        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, extra == 5 ? RecyclerView.HORIZONTAL : RecyclerView.VERTICAL);
	        recycle_item.setLayoutManager(layoutManager);
	        recycle_item.setAdapter(new StaggeredGridAdapter(this, extra == 4 ? true : false, Utils.IMAGECONTENTS));
	        return;
		}
	}
}

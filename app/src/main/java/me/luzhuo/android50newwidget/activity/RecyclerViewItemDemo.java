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

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.luzhuo.android50newwidget.R;
import me.luzhuo.android50newwidget.adapter.BigListAdapter;
import me.luzhuo.android50newwidget.adapter.GridAdapter;
import me.luzhuo.android50newwidget.adapter.HeaderGridAdapter;
import me.luzhuo.android50newwidget.adapter.HeaderListAdapter;
import me.luzhuo.android50newwidget.adapter.HeaderStaggeredGridAdapter;
import me.luzhuo.android50newwidget.adapter.ListAdapter;
import me.luzhuo.android50newwidget.adapter.StaggeredGridAdapter;
import me.luzhuo.android50newwidget.utils.Utils;

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
 * Revision History: 1. 2016.12.16 修改适配器的数据获取方式, 使其更符合规范.<br>
 * 					 2. 2018.9.27 添加自动回位 SnapHelper 代码.
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

		// --- 扩展 ---
		// 自动回位
		if (extra == 6 || extra == 7) {
			LinearLayoutManager layoutManager = new LinearLayoutManager(this);
			layoutManager.setOrientation(RecyclerView.VERTICAL);
			recycle_item.setLayoutManager(layoutManager);
			recycle_item.setAdapter(extra == 6 ? new ListAdapter(this, true, Utils.IMAGECONTENTS) : new BigListAdapter(this, Utils.IMAGECONTENTS));

			// LinearSnapHelper 多页, 居中; PagerSnapHelper 一页, 居中(抖音)
			SnapHelper snapHelper;
			if (extra == 6) snapHelper= new LinearSnapHelper();
			else snapHelper = new PagerSnapHelper();
			snapHelper.attachToRecyclerView(recycle_item);
			return;
		}

		// +Header
		if (extra == 8) {
			// 在 Adapter 设置
			LinearLayoutManager layoutManager = new LinearLayoutManager(this);
			layoutManager.setOrientation(RecyclerView.VERTICAL);
			recycle_item.setLayoutManager(layoutManager);
			recycle_item.setAdapter(new HeaderListAdapter(this, Utils.IMAGECONTENTS));
			return;

		} else if (extra == 9) {
			final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

			// 在此处设置
			layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
				@Override
				public int getSpanSize(int position) {
					return position == 0 ? layoutManager.getSpanCount() : 1; // 第1行占满
				}
			});

			layoutManager.setOrientation(RecyclerView.VERTICAL);
			recycle_item.setLayoutManager(layoutManager);
			recycle_item.setAdapter(new HeaderGridAdapter(this, Utils.IMAGECONTENTS));
			return;

		} else if (extra == 10) {
			// 在 Adapter 设置
			StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
			recycle_item.setLayoutManager(layoutManager);
			recycle_item.setAdapter(new HeaderStaggeredGridAdapter(this, Utils.IMAGECONTENTS));
			return;

		}
	}
}

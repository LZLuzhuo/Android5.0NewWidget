package com.luzhuo.android5widget.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.luzhuo.android5widget.R;
import com.luzhuo.android5widget.adapter.GridAdapter;
import com.luzhuo.android5widget.adapter.ListAdapter;
import com.luzhuo.android5widget.adapter.StaggeredGridAdapter;

/**
 * =================================================
 * 
 * 作者:卢卓
 * 
 * 版本:1.0
 * 
 * 创建日期:2015-12-7 下午4:48:50
 * 
 * 描述:对纵向/横向列表,纵向/横向网格,纵向/横向瀑布流的演示用的布局,详细代码请{@link RecycleViewItem}.
 * 
 * 修订历史:
 * 
 * 
 * =================================================
 **/
public class RecycleViewItemDemo extends FragmentActivity {
	String[] contents = new String[]{"纵向列表","横向列表","纵向网格","横向网格","纵向瀑布流","横向瀑布流"};
	private Toolbar recycle_toolbar;
	private int extra;
	private RecyclerView recycle_item;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycleview_item);
		extra = getIntent().getIntExtra("position", -1);
		initView();
		initData();
	}

	private void initView() {
		recycle_toolbar = (Toolbar) findViewById(R.id.recycle_item_toolbar);
		recycle_item = (RecyclerView) findViewById(R.id.recycle_item);
	}

	private void initData() {
		if(extra == -1)
			return;
		// 设置toolbar的标题
		recycle_toolbar.setTitle("RecyclerView--"+contents[extra]);
		
		// 列表布局
		if(extra == 0 || extra == 1){
	        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
	        layoutManager.setOrientation(extra == 1 ? LinearLayoutManager.HORIZONTAL : LinearLayoutManager.VERTICAL);
	        recycle_item.setLayoutManager(layoutManager);
	        recycle_item.setAdapter(new ListAdapter(this,extra == 0 ? true : false));
			return;
		}
		
		// 网格布局
		if(extra == 2 || extra == 3){
			GridLayoutManager layoutManager = new GridLayoutManager(this, 4); //第二个参数是列数
	        layoutManager.setOrientation(extra==3 ? LinearLayoutManager.HORIZONTAL : LinearLayoutManager.VERTICAL);
	        recycle_item.setLayoutManager(layoutManager);
	        recycle_item.setHasFixedSize(true); // true:不允许Adapter改变RecyclerView的大小
	        recycle_item.setAdapter(new GridAdapter(this));
	        return;
		}
		
		//瀑布流布局
		if(extra == 4 || extra == 5){
			// 第一个参数:列数;第二个参数排列方式
	        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,extra==5 ? LinearLayoutManager.HORIZONTAL : LinearLayoutManager.VERTICAL);
	        recycle_item.setLayoutManager(layoutManager);
	        recycle_item.setAdapter(new StaggeredGridAdapter(this,extra == 4 ? true : false));
	        return;
		}
	}
}

package com.luzhuo.android5widget.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;

import com.luzhuo.android5widget.R;
import com.luzhuo.android5widget.fragment.RecycleViewItem;

/**
 * =================================================
 * 
 * 作者:卢卓
 * 
 * 版本:1.0
 * 
 * 创建日期:2015-12-7 下午4:48:50
 * 
 * 描述:对纵向/横向列表,纵向/横向网格,纵向/横向瀑布流的演示
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
	private RecycleViewItem viewItem;
	private Bundle bundle;
	
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
	}

	private void initData() {
		if(extra == -1)
			return;
		// 设置toolbar的标题
		recycle_toolbar.setTitle("RecyclerView--"+contents[extra]);
		
		// 替换Fragment
		viewItem = new RecycleViewItem();
		bundle = new Bundle();
		bundle.putInt("position", extra);
		viewItem.setArguments(bundle);
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment, viewItem).commit();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		viewItem = null;
		bundle = null;
	}
}

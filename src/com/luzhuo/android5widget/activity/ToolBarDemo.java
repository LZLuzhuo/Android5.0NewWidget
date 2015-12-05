package com.luzhuo.android5widget.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.luzhuo.android5widget.R;

/**
 * =================================================
 * 
 * 作者:卢卓
 * 
 * 版本:1.0
 * 
 * 创建日期:2015-12-5 下午10:54:14
 * 
 * 描述:ToolBar的案例
 * 
 * 修订历史:
 * 
 * 
 * =================================================
 **/
public class ToolBarDemo extends Activity implements OnClickListener {
	private ImageView back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toolbar);
		initView();
	}

	private void initView() {
		back = (ImageView) findViewById(R.id.back);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == back) {
			finish();
		}
	}
}

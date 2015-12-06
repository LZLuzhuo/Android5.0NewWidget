package com.luzhuo.android5widget.activity;

import com.luzhuo.android5widget.R;
import com.luzhuo.android5widget.R.id;
import com.luzhuo.android5widget.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
	private CardView toolBar;
	private CardView cardView;
	private CardView recyclerView;
	private CardView swipeRefreshLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		toolBar = (CardView) findViewById(R.id.ToolBar);
		cardView = (CardView) findViewById(R.id.CardView);
		recyclerView = (CardView) findViewById(R.id.RecyclerView);
		swipeRefreshLayout = (CardView) findViewById(R.id.SwipeRefreshLayout);
		
		toolBar.setOnClickListener(this);
		cardView.setOnClickListener(this);
		recyclerView.setOnClickListener(this);
		swipeRefreshLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.ToolBar:
			intent = new Intent(this, ToolBarDemo.class);
			startActivity(intent);
			break;
		case R.id.CardView:
			intent = new Intent(this, CardViewDemo.class);
			startActivity(intent);
			break;
		case R.id.RecyclerView:
			intent = new Intent(this, RecyclerViewDemo.class);
			startActivity(intent);
			break;
		case R.id.SwipeRefreshLayout:
			System.out.println("SwipeRefreshLayout");
			break;
		}
	}

}

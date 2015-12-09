package com.luzhuo.android5widget.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;

import com.luzhuo.android5widget.R;

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

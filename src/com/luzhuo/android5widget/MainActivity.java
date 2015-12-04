package com.luzhuo.android5widget;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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
		switch (v.getId()) {
		case R.id.ToolBar:
			System.out.println("ToolBar");
			break;
		case R.id.CardView:
			System.out.println("CardView");
			break;
		case R.id.RecyclerView:
			System.out.println("RecyclerView");
			break;
		case R.id.SwipeRefreshLayout:
			System.out.println("SwipeRefreshLayout");
			break;
		}
	}

}

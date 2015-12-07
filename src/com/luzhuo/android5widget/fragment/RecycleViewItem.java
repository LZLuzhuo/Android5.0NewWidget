package com.luzhuo.android5widget.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luzhuo.android5widget.R;

public class RecycleViewItem extends Fragment {
	private int extra = -1;
	private TextView textview;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_recycle_item, null);
		try{
			extra = getArguments().getInt("position");
		}catch(Exception e){
			extra = -1;
		}
		initView(view);
		initData();
		return view;
	}

	private void initView(View view) {
		textview = (TextView) view.findViewById(R.id.textview);
	}

	private void initData() {
		if(extra == -1) return;
		
		textview.setText("extra:"+extra);
		
		
	}
}

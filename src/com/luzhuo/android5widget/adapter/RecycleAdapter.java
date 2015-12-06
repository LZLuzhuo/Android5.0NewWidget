package com.luzhuo.android5widget.adapter;

import com.luzhuo.android5widget.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder>{
	String[] contents = new String[]{"纵向列表","横向列表","纵向网格","横向网格","纵向瀑布流","横向瀑布流"};
	private Context context;

	public RecycleAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle_menu, parent, false);
        return new ListHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		((ListHolder) holder).setData(position);
	}

	@Override
	public int getItemCount() {
		return contents.length;
	}
	
	class ListHolder extends RecyclerView.ViewHolder{
		private TextView content;

		public ListHolder(View itemView) {
			super(itemView);
			content = (TextView) itemView.findViewById(R.id.content);
		}
		
		public void setData(int position) {
			content.setText(contents[position]);
        }
	}
}

package com.luzhuo.android5widget.adapter;

import com.luzhuo.android5widget.R;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder>{
	String[] contents = new String[]{"纵向列表","横向列表","纵向网格","横向网格","纵向瀑布流","横向瀑布流"};
	private Context context;
	private OnItemClickListener onItemClickListener;

	public RecycleAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle_menu, parent, false);
        return new RecyclerHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		((RecyclerHolder) holder).setData(position);
	}

	@Override
	public int getItemCount() {
		return contents.length;
	}
	
	public class RecyclerHolder extends RecyclerView.ViewHolder implements OnClickListener{
		public TextView content;
		private CardView cardview;

		public RecyclerHolder(View itemView) {
			super(itemView);
			content = (TextView) itemView.findViewById(R.id.item_content);
			cardview = (CardView) itemView.findViewById(R.id.item_cardview);
			cardview.setOnClickListener(this);
		}
		
		public void setData(int position) {
			content.setText(contents[position]);
        }

		@Override
		public void onClick(View v) {
			if(onItemClickListener != null) onItemClickListener.onItemClick(this, getLayoutPosition());
		}
	}
	
	public void setOnItemClickListener(OnItemClickListener onItemClickListener){
		this.onItemClickListener = onItemClickListener;
	}
	
    public static interface OnItemClickListener {
        void onItemClick(RecyclerHolder recyclerHolder, int position);
    }
}

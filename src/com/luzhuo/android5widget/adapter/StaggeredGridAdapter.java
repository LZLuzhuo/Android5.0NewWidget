package com.luzhuo.android5widget.adapter;

import static com.luzhuo.android5widget.utils.Utils.contents;

import java.util.Random;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luzhuo.android5widget.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<ViewHolder>  {
	private Context context;
	private boolean isVERTICAL;
	
	public StaggeredGridAdapter(Context context,boolean isVERTICAL) {
		this.context = context;
		this.isVERTICAL= isVERTICAL;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(isVERTICAL ? R.layout.item_staggered : R.layout.item_staggered_h, parent, false);
		return new RecyclerHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		((RecyclerHolder) holder).setData(position);
	}

	@Override
	public int getItemCount() {
		return 1000;
	}

	class RecyclerHolder extends RecyclerView.ViewHolder {
		private TextView text;
		private ImageView image;
		private Random random = new Random();

		public RecyclerHolder(View itemView) {
			super(itemView);
			text = (TextView) itemView.findViewById(R.id.text);
			image = (ImageView) itemView.findViewById(R.id.image);
		}

		public void setData(int position) {
			text.setText("position:"+position);
			image.setImageResource(contents[random.nextInt(contents.length)]);
		}
	}
}

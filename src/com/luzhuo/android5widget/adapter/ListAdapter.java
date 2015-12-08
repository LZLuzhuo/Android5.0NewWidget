package com.luzhuo.android5widget.adapter;

import java.util.Random;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.luzhuo.android5widget.utils.Utils.contents;
import com.luzhuo.android5widget.R;

public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {
	private Context context;
	private boolean isHORIZONTAL;

	public ListAdapter(Context context, boolean isHORIZONTAL) {
		this.context = context;
		this.isHORIZONTAL = isHORIZONTAL;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(isHORIZONTAL ? R.layout.item_list : R.layout.item_list_h, parent, false);
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

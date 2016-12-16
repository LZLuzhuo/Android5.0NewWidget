/* Copyright 2015 Luzhuo. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.luzhuo.android50newweight.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import me.luzhuo.android50newweight.R;

public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder>{
	private String[] contents;
	private Context context;
	private OnItemClickListener onItemClickListener;

	public RecycleAdapter(Context context, String[] contents) {
		this.context = context;
		this.contents = contents;
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
		return contents == null ? 0 : contents.length;
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
			if(onItemClickListener != null) onItemClickListener.onItemClick(getLayoutPosition());
		}
	}
	
	public void setOnItemClickListener(OnItemClickListener onItemClickListener){
		this.onItemClickListener = onItemClickListener;
	}
	
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

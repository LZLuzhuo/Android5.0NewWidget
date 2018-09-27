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
package me.luzhuo.android50newwidget.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import me.luzhuo.android50newwidget.R;
import me.luzhuo.android50newwidget.utils.Utils;

public class HeaderListAdapter extends RecyclerView.Adapter<ViewHolder> {
	private final int TYPE_HEADER = 0x001, TYPE_ITEM = 0x002;
	private Context context;
	private int[] imageContents;

	public HeaderListAdapter(Context context, int[] imageContents) {
		this.context = context;
		this.imageContents = imageContents;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = null;
		// 根据不同类型, 创建不同布局
		switch (viewType){
			case TYPE_HEADER:
				view = LayoutInflater.from(context).inflate(R.layout.item_list_header, parent, false);
				break;
			case TYPE_ITEM:
				view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
				break;
		}
		return new RecyclerHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		((RecyclerHolder) holder).setData(position);
	}

	@Override
	public int getItemCount() {
		// +1 是添加了头部
		// return imageContents == null ? 0 : imageContents.length + 1;
		return imageContents == null ? 0 : 1000;
	}

	@Override
	public int getItemViewType(int position) {
		// 位置为0的话类型为头部，其余为内容
		return position == 0 ? TYPE_HEADER : TYPE_ITEM;
	}

	class RecyclerHolder extends ViewHolder {
		// header
		private ImageView header_image;
		private TextView header_text;

		// item
		private TextView item_text;
		private ImageView item_image;
		private Random random = new Random();

		public RecyclerHolder(View itemView) {
			super(itemView);
			// header
			header_image = itemView.findViewById(R.id.image);
			header_text = itemView.findViewById(R.id.text);

			// item
			item_text = (TextView) itemView.findViewById(R.id.text);
			item_image = (ImageView) itemView.findViewById(R.id.image);
		}

		public void setData(int position) {
			// 头部占用了position 0
			position = position - 1;
			int width = Utils.getDisplayWidth((Activity) context);
			// 获取类型, 根据不同类型设置不同数据
			switch (this.getItemViewType()){
				case TYPE_HEADER:
                    ViewGroup.LayoutParams lp = header_image.getLayoutParams();
					lp.width = width;
					lp.height = width * 2 / 3;
					header_image.setLayoutParams(lp);

					header_image.setImageResource(R.mipmap.background);
					header_text.setText("这是头部");

					break;
				case TYPE_ITEM:
					item_text.setText("position:"+position);
					item_image.setImageResource(imageContents[random.nextInt(imageContents.length)]);

					break;
			}
		}
	}
}

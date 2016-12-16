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
package me.luzhuo.android50newweight.utils;

import android.content.Context;
import android.widget.Toast;

import me.luzhuo.android50newweight.R;

public class Utils {
	/**
	 * 图片资源
	 */
	public static final int[] IMAGECONTENTS = new int[] { R.mipmap.a, R.mipmap.ab, R.mipmap.ac, R.mipmap.ad, R.mipmap.ae, R.mipmap.af, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h,
			R.mipmap.i, R.mipmap.j, R.mipmap.k, R.mipmap.l, R.mipmap.m, R.mipmap.n, R.mipmap.o, R.mipmap.p, R.mipmap.q, R.mipmap.r, R.mipmap.u, R.mipmap.v, R.mipmap.w, R.mipmap.x, R.mipmap.y,
			R.mipmap.z };

	/**
	 * 文本资源
	 */
	public static final String[] TEXTCONTENTS = new String[]{"纵向列表","横向列表","纵向网格","横向网格","纵向瀑布流","横向瀑布流"};

	private static Toast quickToast;
	/**
	 * 快速显示的吐司
	 * @param context
	 * @param msg
	 */
	public static void showQuickToast(Context context, String msg) {
		if(quickToast == null)
			quickToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
		quickToast.setText(msg);
		quickToast.show();
	}
}

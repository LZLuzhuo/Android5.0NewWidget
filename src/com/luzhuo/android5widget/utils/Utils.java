package com.luzhuo.android5widget.utils;

import com.luzhuo.android5widget.R;

import android.content.Context;
import android.widget.Toast;

public class Utils {
	/**
	 * 图片资源
	 */
	public static final int[] contents = new int[] { R.drawable.a, R.drawable.ab, R.drawable.ac, R.drawable.ad, R.drawable.ae, R.drawable.af, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
			R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y,
			R.drawable.z };
	
	private static Toast quickToast;
	/**
	 * 快速显示的吐司
	 * @param mContext
	 * @param msg
	 */
	public static void showQuickToast(Context context, String msg) {
		if(quickToast == null)
			quickToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
		quickToast.setText(msg);
		quickToast.show();
	}
}

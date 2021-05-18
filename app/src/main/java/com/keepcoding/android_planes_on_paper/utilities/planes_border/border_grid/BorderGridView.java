package com.keepcoding.android_planes_on_paper.utilities.planes_border.border_grid;

import com.keepcoding.android_planes_on_paper.utilities.planes_border.BorderEngine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class BorderGridView extends GridView {
	private final Context context;

	// constructors
	public BorderGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;

		BorderGridViewAdaptor gridViewAdaptor = new BorderGridViewAdaptor(context);
		setAdapter(gridViewAdaptor);

		setOnItemClickListener((parent, view, position, id) -> {
			int x = position / 10;
			int y = position % 10;

			BorderEngine.getInstance().setNumber(x, y);
		});
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
	}

	static class BorderGridViewAdaptor extends BaseAdapter {
		private final Context context;
		public BorderGridViewAdaptor(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			return 100;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return BorderEngine.getInstance().getGrid().getItem(position);
		}
	}
}

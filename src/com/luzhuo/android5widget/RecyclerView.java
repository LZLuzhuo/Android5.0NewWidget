/*public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int NO_POSITION = -1;
    public static final long NO_ID = -1;
    public static final int INVALID_TYPE = -1;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_SETTLING = 2;

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() { }
    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate accessibilityDelegate) { }	//XXX未知XXX
    public void setHasFixedSize(boolean hasFixedSize) { } //true:不允许Adapter改变RecyclerView的大小
    public boolean hasFixedSize() { }
    public void setScrollingTouchSlop(int slopConstant) { } //设置touch越界	[TOUCH_SLOP_DEFAULT/TOUCH_SLOP_PAGING]
    public void swapAdapter(Adapter adapter, boolean removeAndRecycleExistingViews) { } // 更换Adapter
    public void setAdapter(Adapter adapter) { } // 更换Adapter
    public Adapter getAdapter() { }
    public void setRecyclerListener(RecyclerListener listener) { } // 设置回收监听
    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener listener) { } // 监听孩子的关联和脱离
    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener listener) { }
    public void clearOnChildAttachStateChangeListeners() { }
    public void setLayoutManager(LayoutManager layout) { } // 设置布局管理者{重要}
    public LayoutManager getLayoutManager() { }
    public RecycledViewPool getRecycledViewPool() { }
    public void setRecycledViewPool(RecycledViewPool pool) { } // 设置回收池
    public void setViewCacheExtension(ViewCacheExtension extension) { } // 扩张缓存/null清除现有缓存
    public void setItemViewCacheSize(int size) { } // 设置条目缓存大小,这些条目不做任何修改直接使用
    public int getScrollState() { } //获取滚动状态 [SCROLL_STATE_IDLE/SCROLL_STATE_DRAGGING/SCROLL_STATE_SETTLING] {重要}
    public void addItemDecoration(ItemDecoration decor, int index) { } // 添加条目的装饰
    public void addItemDecoration(ItemDecoration decor) { }
    public void removeItemDecoration(ItemDecoration decor) { }
    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) { } //设置孩子绘画回调
    public void addOnScrollListener(OnScrollListener listener) { } // 添加滚动监听 {重要}
    public void removeOnScrollListener(OnScrollListener listener) { } // {重要}
    public void clearOnScrollListeners() { }
    public void scrollToPosition(int position) { } // 滚动到某个位置 {重要}
    public void smoothScrollToPosition(int position) { } // 平滑的滚动到某个位置 {重要}
    public void setLayoutFrozen(boolean frozen) { } // true:冻结布局和滚动; false:释放冻结 (冻结后仍可调用scrollToPosition/smoothScrollToPosition) {重要}
    public boolean isLayoutFrozen() { }
    public void smoothScrollBy(int dx, int dy) { }
    public boolean fling(int velocityX, int velocityY) { } // true:在抛(速度快) {重要}
    public void stopScroll() { } // 停止滚动
    public int getMinFlingVelocity() { } // 最小的抛速度
    public int getMaxFlingVelocity() { }
    public void addOnItemTouchListener(OnItemTouchListener listener) { } // 添加条目touch监听
    public void removeOnItemTouchListener(OnItemTouchListener listener) { }
    public boolean isComputingLayout() { } // true:是现在在处理的布局
    public ItemAnimator getItemAnimator() { } // 条目动画/null:没有动画
    public boolean isAnimating() { }
    public void invalidateItemDecorations() { } // 刷新条目装饰
    public ViewHolder getChildViewHolder(View child) { } // 获取孩子的ViewHolder
    public int getChildAdapterPosition(View child) { } //孩子在适配器中的位置
    public int getChildLayoutPosition(View child) { }
    public long getChildItemId(View child) { } // 获取条目id
    public ViewHolder findViewHolderForLayoutPosition(int position) { }
    public ViewHolder findViewHolderForAdapterPosition(int position) { }
    public ViewHolder findViewHolderForItemId(long id) { }
    public View findChildViewUnder(float x, float y) { } //给定的点下找到的最上面的子view
    public void offsetChildrenVertical(int dy) { } // 垂直滚动
    public void onChildAttachedToWindow(View child) { }
    public void onChildDetachedFromWindow(View child) { }
    public void offsetChildrenHorizontal(int dx) { } // 水平滚动
    public boolean hasPendingAdapterUpdates() { } // 是否有未更新的布局
    
    public static class RecycledViewPool { } // 回收池
    public static abstract class Adapter<VH extends ViewHolder> { } // 适配器 {重要}
    public static abstract class LayoutManager { } // 布局管理 {重要}
    public static abstract class ItemDecoration {}
    public static class SimpleOnItemTouchListener implements RecyclerView.OnItemTouchListener { }
    public static abstract class ViewHolder { } // ViewHolder {重要}
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams { } //LayoutParams
    public static abstract class AdapterDataObserver { } // 观察者
    public static abstract class SmoothScroller { } // 滚动类 {重要}
    static class AdapterDataObservable extends Observable<AdapterDataObserver> { } // 观察者
    public static class State {}
    public static abstract class ItemAnimator { } // 条目动画类 {重要}
}
*/
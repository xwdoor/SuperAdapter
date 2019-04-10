package net.xwdoor.superadapter.recyclerviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 适配 RecyclerView 的 SuperAdapter
 */
public class SuperAdapter<T> extends RecyclerView.Adapter<SuperViewHolder> {
    private List<T> mList;
    private IMultipleView<T> mMultipleView;
    private ISingleView mSingleView;
    private IViewItemBindData<T> mItemBindListener;
    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;

    /**
     * 单一布局
     *
     * @param list       需要显示的数据列表
     * @param singleView 布局视图
     */
    public SuperAdapter(List<T> list, ISingleView singleView) {
        mList = list;
        mSingleView = singleView;
    }

    /**
     * 多种布局
     *
     * @param list         需要显示的数据列表
     * @param multipleView 布局显示的监听/回调接口
     */
    public SuperAdapter(List<T> list, IMultipleView<T> multipleView) {
        mList = list;
        mMultipleView = multipleView;
    }

    /**
     * 设置数据
     * @param list  需要显示的数据列表
     */
    public void setData(List<T> list) {
        mList = list;
        notifyDataSetChanged();
    }

    /**
     * 向列表末尾追加数据。
     *
     * @param list 需要追加的数据
     */
    public void appendData(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 获取数据
     */

    public List<T> getData() {
        return mList;
    }

    public T getDataAtPosition(int position) {
        if (mList == null) {
            return null;
        }
        if (position < 0 || position > mList.size() -1) {
            return null;
        }
        return mList.get(position);
    }

    @Override
    public SuperViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final SuperViewHolder viewHolder;
        if (mMultipleView == null) {
            viewHolder = new SuperViewHolder(mSingleView.getLayoutView(viewType));
        } else {
            viewHolder = new SuperViewHolder(mMultipleView.getLayoutView(viewType));
        }
        //在这里设置点击事件，可以复用，不用多次设置
        viewHolder.itemView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(viewHolder.itemView, viewType, viewHolder.getLayoutPosition());
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mItemLongClickListener != null) {
                    mItemLongClickListener.onItemLongClick(v, viewType, viewHolder.getLayoutPosition());
                    return true;
                }
                return false;
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SuperViewHolder holder, int position) {
        if (mItemBindListener != null) {
            mItemBindListener.onItemBindData(holder, getItemViewType(position), position, mList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mMultipleView != null) {
            return mMultipleView.getItemViewType(position, mList.get(position));
        }
        return super.getItemViewType(position);
    }

    public SuperAdapter setItemBindListener(IViewItemBindData<T> itemBindListener) {
        mItemBindListener = itemBindListener;
        return this;
    }

    public SuperAdapter setItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
        return this;
    }

    public SuperAdapter setItemLongClickListener(OnItemLongClickListener listener) {
        this.mItemLongClickListener = listener;
        return this;
    }

    public interface IViewItemBindData<T> {
        /**
         * 当Item的绑定关系发生变化时发生，即当新的Item显示时发生
         *
         * @param holder   用于item的复用
         * @param viewType item布局类型
         * @param position 当前位置
         * @param t        需要显示的数据model
         */
        void onItemBindData(SuperViewHolder holder, int viewType, int position, T t);
    }

    public interface OnItemClickListener {
        /**
         * Item被点击
         *
         * @param itemView 被点击的View
         * @param viewType 被点击的布局类型
         * @param position 被点击的位置
         */
        void onItemClick(View itemView, int viewType, int position);
    }

    public interface OnItemLongClickListener {
        /**
         * Item被长点击，即长按Item
         *
         * @param itemView 被点击的View
         * @param viewType 被点击的布局类型
         * @param position 被点击的位置
         */
        void onItemLongClick(View itemView, int viewType, int position);
    }
}

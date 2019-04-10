package net.xwdoor.superadapter.recyclerviewadapter;

import android.view.View;

/**
 * 用于多种布局的接口
 */
public interface ISingleView{

    /**
     * 根据布局类型得到相应的布局
     *
     * @param viewType 布局类型
     * @return 需要展示的视图
     */
    View getLayoutView(int viewType);
}

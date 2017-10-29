package lzhs.com.library.widget.adapter.recycle;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;

import java.util.List;

import lzhs.com.library.widget.adapter.recycle.base.ItemViewDelegate;
import lzhs.com.library.widget.adapter.recycle.base.ViewHolder;


/**
 * Created by zhy on 16/4/9.
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;


    public void changDatas(List<T> mDatas) {
        this.mDatas.clear();
        addDatas(mDatas);
    }

    public void addDatas(List<T> mDatas) {
        this.mDatas.addAll(mDatas);
        notifyDataSetChanged();
    }


    public CommonAdapter(final Context context, @LayoutRes final int layoutId, List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }


    protected abstract void convert(ViewHolder holder, T t, int position);


}

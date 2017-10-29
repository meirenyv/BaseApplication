package lzhs.com.baseapplication.module.menu.myads.make.delegate;

import android.support.annotation.NonNull;
import android.view.View;

import com.zhy.autolayout.utils.AutoUtils;

import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.myads.make.OnItemSubViewClick;
import lzhs.com.baseapplication.module.menu.myads.make.bean.MakeItemTypeBean;
import lzhs.com.library.widget.adapter.recycle.base.ItemViewDelegate;
import lzhs.com.library.widget.adapter.recycle.base.ViewHolder;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 18:42<br/>
 * 邮箱：1050629507@qq.com
 */
public class MakeItemType02 implements ItemViewDelegate<MakeItemTypeBean> {

    OnItemSubViewClick onItemSubViewClick =null;
    public MakeItemType02(@NonNull OnItemSubViewClick onItemSubViewClick) {
        this.onItemSubViewClick=onItemSubViewClick;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_ads_make_layout01;
    }

    @Override
    public boolean isForViewType(MakeItemTypeBean item, int position) {
        return !item.isLast();
    }

    @Override
    public void convert(ViewHolder holder, MakeItemTypeBean bean, int position) {
        AutoUtils.auto(holder.getConvertView());
         holder.getConvertView().setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 onItemSubViewClick.addNewADS();
             }
         });




    }
}

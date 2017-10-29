package lzhs.com.baseapplication.module.menu.homepage.delegate;

import com.zhy.autolayout.utils.AutoUtils;

import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.homepage.HomePageOnItemSubViewClick;
import lzhs.com.baseapplication.module.menu.homepage.bean.HomePageItemBean;
import lzhs.com.library.widget.adapter.recycle.base.ItemViewDelegate;
import lzhs.com.library.widget.adapter.recycle.base.ViewHolder;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 18:42<br/>
 * 邮箱：1050629507@qq.com
 */
public class HomePageItemType03 implements ItemViewDelegate<HomePageItemBean> {
      HomePageOnItemSubViewClick homePageOnItemSubViewClick=null;
    public HomePageItemType03(HomePageOnItemSubViewClick homePageOnItemSubViewClick) {
        this.homePageOnItemSubViewClick=homePageOnItemSubViewClick;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_home_pager_layout03;
    }

    @Override
    public boolean isForViewType(HomePageItemBean item, int position) {
        return item.getItemType()==2;
    }

    @Override
    public void convert(ViewHolder holder, HomePageItemBean bean, int position) {
        AutoUtils.auto(holder.getConvertView());

    }
}

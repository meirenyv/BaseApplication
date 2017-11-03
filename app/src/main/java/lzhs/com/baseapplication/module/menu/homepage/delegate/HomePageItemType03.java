package lzhs.com.baseapplication.module.menu.homepage.delegate;

import android.view.View;

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
        //我的钱包
        holder.getView(R.id.mLinMywallet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePageOnItemSubViewClick.recharge();
            }
        });
        //我的广告
        holder.getView(R.id.mLinMyads).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePageOnItemSubViewClick.makeADS();
            }
        });
        //我的屏幕
        holder.getView(R.id.mLinMyscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePageOnItemSubViewClick.addScreen();
            }
        });
        //我的购物车
        holder.getView(R.id.mLinMyShoppingCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePageOnItemSubViewClick.cleaning();
            }
        });

    }
}

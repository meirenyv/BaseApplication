package lzhs.com.baseapplication.module.menu.homepage.delegate;

import android.view.View;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;
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
public class HomePageItemType01 implements ItemViewDelegate<HomePageItemBean> {
      HomePageOnItemSubViewClick homePageOnItemSubViewClick=null;
    public HomePageItemType01(HomePageOnItemSubViewClick homePageOnItemSubViewClick) {
        this.homePageOnItemSubViewClick=homePageOnItemSubViewClick;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_home_pager_layout01;
    }

    @Override
    public boolean isForViewType(HomePageItemBean item, int position) {
        return item.getItemType()==0;
    }

    @Override
    public void convert(ViewHolder holder, HomePageItemBean bean, int position) {
        AutoUtils.auto(holder.getConvertView());


        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(holder.getConvertView().getContext(), R.mipmap.ic_guide_2));
        views.add(BGABannerUtil.getItemImageView(holder.getConvertView().getContext(), R.mipmap.ic_guide_3));
        views.add(BGABannerUtil.getItemImageView(holder.getConvertView().getContext(), R.mipmap.ic_guide_1));
        BGABanner mContentBannerg=holder.getView(R.id.mBGABanner);
        mContentBannerg.setData(views);
    }
}

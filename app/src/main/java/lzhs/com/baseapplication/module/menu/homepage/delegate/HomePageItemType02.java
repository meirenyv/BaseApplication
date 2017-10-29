package lzhs.com.baseapplication.module.menu.homepage.delegate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.homepage.HomePageOnItemSubViewClick;
import lzhs.com.baseapplication.module.menu.homepage.bean.HomePageItemBean;
import lzhs.com.baseapplication.module.menu.homepage.delegate.type.HomePageTypeFragment;
import lzhs.com.baseapplication.module.menu.homepage.delegate.type.HomePagerTypeBean;
import lzhs.com.library.base.BaseFragment_V4;
import lzhs.com.library.widget.adapter.recycle.base.ItemViewDelegate;
import lzhs.com.library.widget.adapter.recycle.base.ViewHolder;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 18:42<br/>
 * 邮箱：1050629507@qq.com
 */
public class HomePageItemType02 implements ItemViewDelegate<HomePageItemBean> {
    HomePageOnItemSubViewClick homePageOnItemSubViewClick = null;
    BaseFragment_V4 fragment_v4 = null;

    public HomePageItemType02(BaseFragment_V4 fragment_v4, HomePageOnItemSubViewClick homePageOnItemSubViewClick) {
        this.homePageOnItemSubViewClick = homePageOnItemSubViewClick;
        this.fragment_v4 = fragment_v4;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_home_pager_layout02;
    }

    @Override
    public boolean isForViewType(HomePageItemBean item, int position) {
        return item.getItemType() == 1;
    }

    @Override
    public void convert(ViewHolder holder, HomePageItemBean bean, int position) {
        AutoUtils.auto(holder.getConvertView());

        ViewPager mViewPager = holder.getView(R.id.mViewPager);
        mViewPager.setAdapter(new FragmentPagerAdapter(fragment_v4.getChildFragmentManager()) {
            List<BaseFragment_V4> fragment_v4s=new ArrayList<BaseFragment_V4>();
            {
                for (int i = 0; i < 5; i++) {
                   ArrayList< HomePagerTypeBean> typeBeans=new ArrayList<HomePagerTypeBean>();
                    for (int i1 = 0; i1 < 10; i1++) {
                        typeBeans.add(new HomePagerTypeBean(i1,"name"+i1,i1));
                    }
                    fragment_v4s.add(HomePageTypeFragment.newInstance(typeBeans));
                }
            }

            @Override
            public Fragment getItem(int position) {
                return fragment_v4s.get(position);
            }

            @Override
            public int getCount() {
                return fragment_v4s.size();
            }
        });


    }
}

package lzhs.com.baseapplication.module.menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.homepage.HomePageFragment;
import lzhs.com.baseapplication.module.menu.mine.MineFragment;
import lzhs.com.baseapplication.module.menu.myads.MyAdsFragment;
import lzhs.com.baseapplication.module.menu.myscreen.MyScreenFragment;
import lzhs.com.baseapplication.module.menu.reportforms.ReportFormsFragment;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;
import lzhs.com.library.widget.views.viewpager.ViewPagerFixed;


/**
 * 页面的主菜单页面
 */
public class MenuActivity extends BaseActivity {

    @BindView(R.id.mVPFmain)
    ViewPagerFixed mVPFmain;
    private Fragment homepagefragment=HomePageFragment.newInstance();
    private Fragment myadsfragment=MyAdsFragment.newInstance();
    private Fragment myscreenfragment=MyScreenFragment.newInstance();
    private Fragment reportformsfragment=ReportFormsFragment.newInstance();
    private Fragment minefragment=MineFragment.newInstance();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        //设置沉浸式转台栏
        ActivityUtil.setStatusBarBackground(this);
        initViews();
    }

    private void initViews() {
        // FragmentStatePagerAdapter
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            ArrayList<Fragment> fragments = new ArrayList<>();

            {
                fragments.add(homepagefragment);
                fragments.add(myadsfragment);
                fragments.add(myscreenfragment);
                fragments.add(reportformsfragment);
                fragments.add(minefragment);
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments != null ? fragments.size() : 0;
            }
        };
        mVPFmain.setAdapter(adapter);
        mVPFmain.setOffscreenPageLimit(5);
    }

    @OnClick({R.id.mTabHomePage, R.id.mTabMyAds, R.id.mTabMyScreen, R.id.mTabReportForms, R.id.mTabMine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTabHomePage:
                mVPFmain.setCurrentItem(0);
                break;
            case R.id.mTabMyAds:
                mVPFmain.setCurrentItem(1);
                break;
            case R.id.mTabMyScreen:
                mVPFmain.setCurrentItem(2);
                break;
            case R.id.mTabReportForms:
                mVPFmain.setCurrentItem(3);
                break;
            case R.id.mTabMine:
                mVPFmain.setCurrentItem(4);
                break;
        }
    }
}

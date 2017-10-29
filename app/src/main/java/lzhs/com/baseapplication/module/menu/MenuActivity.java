package lzhs.com.baseapplication.module.menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    @BindView(R.id.mImageHomePage)
    ImageView mImageHomePage;
    @BindView(R.id.mTextHomePage)
    TextView mTextHomePage;
    @BindView(R.id.mImageMyAds)
    ImageView mImageMyAds;
    @BindView(R.id.mTextMyAds)
    TextView mTextMyAds;
    @BindView(R.id.mImageMyScreen)
    ImageView mImageMyScreen;
    @BindView(R.id.mTextMyScreen)
    TextView mTextMyScreen;
    @BindView(R.id.mImageReportForms)
    ImageView mImageReportForms;
    @BindView(R.id.mTextReportForms)
    TextView mTextReportForms;
    @BindView(R.id.mImageMine)
    ImageView mImageMine;
    @BindView(R.id.mTextMine)
    TextView mTextMine;
    private Fragment homepagefragment = HomePageFragment.newInstance();
    private Fragment myadsfragment = MyAdsFragment.newInstance();
    private Fragment myscreenfragment = MyScreenFragment.newInstance();
    private Fragment reportformsfragment = ReportFormsFragment.newInstance();
    private Fragment minefragment = MineFragment.newInstance();


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
                if (mVPFmain.getCurrentItem() != 0)
                    setStarts(0);
                break;
            case R.id.mTabMyAds:
                if (mVPFmain.getCurrentItem() != 1)
                    setStarts(1);
                break;
            case R.id.mTabMyScreen:
                if (mVPFmain.getCurrentItem() != 2)
                    setStarts(2);
                break;
            case R.id.mTabReportForms:
                if (mVPFmain.getCurrentItem() != 3)
                    setStarts(3);
                break;
            case R.id.mTabMine:
                if (mVPFmain.getCurrentItem() != 4)
                    setStarts(4);
                break;
        }
    }


    void setStarts(int id) {
        mImageHomePage.setImageResource(R.mipmap.icon_home_unselected);
        mImageMine.setImageResource(R.mipmap.icon_mine_unselected);
        mImageMyAds.setImageResource(R.mipmap.icon_myads_unselected);
        mImageMyScreen.setImageResource(R.mipmap.icon_myscreen_unselected);
        mImageReportForms.setImageResource(R.mipmap.icon_reportforms_unselected);

        mTextHomePage.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextUnSelected));
        mTextMine.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextUnSelected));
        mTextMyAds.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextUnSelected));
        mTextMyScreen.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextUnSelected));
        mTextReportForms.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextUnSelected));

        mVPFmain.setCurrentItem(id);
        switch (id) {
            case 0:
                mImageHomePage.setImageResource(R.mipmap.icon_home_selected);
                mTextHomePage.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextSelected));
                break;
            case 1:
                mImageMyAds.setImageResource(R.mipmap.icon_myads_selected);
                mTextMyAds.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextSelected));
                break;
            case 2:
                mImageMyScreen.setImageResource(R.mipmap.icon_myscreen_selected);
                mTextMyScreen.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextSelected));
                break;
            case 3:
                mImageReportForms.setImageResource(R.mipmap.icon_reportforms_selected);
                mTextReportForms.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextSelected));
                break;
            case 4:
                mImageMine.setImageResource(R.mipmap.icon_mine_selected);
                mTextMine.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextSelected));
                break;
        }
    }

}

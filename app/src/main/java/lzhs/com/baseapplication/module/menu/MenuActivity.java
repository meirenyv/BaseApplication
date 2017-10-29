package lzhs.com.baseapplication.module.menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
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
public class MenuActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.mVPFmain)
    ViewPagerFixed mVPFmain;
    @BindView(R.id.mRBhomepage)
    RadioButton mRBhomepage;
    @BindView(R.id.mRBmyads)
    RadioButton mRBmyads;
    @BindView(R.id.mRBmyscreen)
    RadioButton mRBmyscreen;
    @BindView(R.id.mRBreportforms)
    RadioButton mRBreportforms;
    @BindView(R.id.mRBmine)
    RadioButton mRBmine;
    private Fragment homepagefragment;
    private Fragment myadsfragment;
    private Fragment myscreenfragment;
    private Fragment reportformsfragment;
    private Fragment minefragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        //设置沉浸式转台栏
        ActivityUtil.setStatusBarBackground(this);
        intiview();
        initviewpager();}

    private void initviewpager() {
       // FragmentStatePagerAdapter
        FragmentPagerAdapter  adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
          ArrayList <Fragment>fragments=new ArrayList<>();
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
                return  fragments != null ? fragments.size() : 0;
            }
        } ;
        mVPFmain.setAdapter(adapter);
        mVPFmain.setOffscreenPageLimit(5);
    }

    private void intiview() {
        mRBhomepage.setOnCheckedChangeListener(this);
        mRBmyads.setOnCheckedChangeListener(this);
        mRBmyscreen.setOnCheckedChangeListener(this);
        mRBreportforms.setOnCheckedChangeListener(this);
        mRBmine.setOnCheckedChangeListener(this);

        homepagefragment = HomePageFragment.newInstance();
        myadsfragment = MyAdsFragment.newInstance();
        myscreenfragment = MyScreenFragment.newInstance();
        reportformsfragment= ReportFormsFragment.newInstance();
        minefragment = MineFragment.newInstance();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b){
            switch (compoundButton.getId()){
                case R.id.mRBhomepage:
                    mVPFmain.setCurrentItem(0);
                    break;
                case R.id.mRBmyads:
                    mVPFmain.setCurrentItem(1);
                    break;

                case R.id.mRBmyscreen:
                    mVPFmain.setCurrentItem(2);
                    break;
                case R.id.mRBreportforms:
                    mVPFmain.setCurrentItem(3);
                    break;

                case R.id.mRBmine:
                    mVPFmain.setCurrentItem(4);
                    break;

            }
        }
    }
}

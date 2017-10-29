package lzhs.com.baseapplication.module.menu.myads;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lzhs.com.baseapplication.R;

/**
 * 我的广告
 */
public class MyAdsFragment extends Fragment {


    public MyAdsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_ads, container, false);
    }
    public static MyAdsFragment newInstance() {
        return new MyAdsFragment();
    }


//    private void initEvents() {
//
//        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                if (tab == mTabLayout.getTabAt(0)) {
//                    one.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher_round));
//                    mViewPager.setCurrentItem(0);
//                } else if (tab == mTabLayout.getTabAt(1)) {
//                    two.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher_round));
//                    mViewPager.setCurrentItem(1);
//                } else if (tab == mTabLayout.getTabAt(2)) {
//                    three.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher_round));
//                    mViewPager.setCurrentItem(2);
//                } else if (tab == mTabLayout.getTabAt(3)) {
//                    four.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher_round));
//                    mViewPager.setCurrentItem(3);
//                } else if (tab == mTabLayout.getTabAt(4)) {
//                    five.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher_round));
//                    mViewPager.setCurrentItem(4);
//                }
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                if (tab == mTabLayout.getTabAt(0))
//                    one.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher));
//                else if (tab == mTabLayout.getTabAt(1))
//                    two.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher));
//                else if (tab == mTabLayout.getTabAt(2))
//                    three.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher));
//                else if (tab == mTabLayout.getTabAt(3))
//                    four.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher));
//                else if (tab == mTabLayout.getTabAt(4))
//                    five.setIcon(ContextCompat.getDrawable(MenuActivity.this, R.mipmap.ic_launcher));
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//    }
//
//    private void initViews() {
//        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//
//            private String[] mTitles = new String[]{"首页", "我的广告", "我的屏幕", "报表", "我"};
//
//            @Override
//            public BaseFragment_V4 getItem(int position) {
//
//                switch (position) {
//                    case 0:
//                        return OneFragment.newInstance(mTitles[position]);
//                    case 1:
//                        return TwoFragment.newInstance(mTitles[position]);
//                    case 2:
//                        return ThreeFragment.newInstance(mTitles[position]);
//                    case 3:
//                        return FourFragment.newInstance(mTitles[position]);
//                    case 4:
//                        return new FiveFragment();
//                }
//
//                return null;
//            }
//
//            @Override
//            public int getCount() {
//                return mTitles.length;
//            }
//
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return mTitles[position];
//            }
//
//        });
//
//        mTabLayout.setupWithViewPager(mViewPager);
//
//        one = mTabLayout.getTabAt(0);
//        two = mTabLayout.getTabAt(1);
//        three = mTabLayout.getTabAt(2);
//        four = mTabLayout.getTabAt(3);
//        five = mTabLayout.getTabAt(4);
//
//        one.setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
//        two.setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
//        three.setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
//        four.setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
//        five.setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
//    }


}

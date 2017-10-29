package lzhs.com.baseapplication.module.menu.myads;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.myads.make.MakeFragment;
import lzhs.com.baseapplication.module.menu.myads.putin.PutInFragment;
import lzhs.com.baseapplication.module.menu.myads.puting.PutingFragment;
import lzhs.com.library.base.BaseFragment_V4;
import lzhs.com.library.widget.views.viewpager.PageTransformer.DepthPageTransformer;

import static android.graphics.Color.WHITE;

/**
 * 我的广告
 */
public class MyAdsFragment extends BaseFragment_V4 {


    @BindView(R.id.mTextMake)
    TextView mTextMake;
    @BindView(R.id.mTabMake)
    CardView mTabMake;
    @BindView(R.id.mTextPutIn)
    TextView mTextPutIn;
    @BindView(R.id.mTabPutIn)
    CardView mTabPutIn;
    @BindView(R.id.mTextPuting)
    TextView mTextPuting;
    @BindView(R.id.mTabPuting)
    CardView mTabPuting;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    Unbinder unbinder;

    public MyAdsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_ads, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViews();

        return view;
    }

    private void initViews() {
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setStarts(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            List<BaseFragment_V4> fragments = new ArrayList<BaseFragment_V4>();
            {
                fragments.add(MakeFragment.newInstance("广告制作"));
                fragments.add(PutInFragment.newInstance("可投放"));
                fragments.add(PutingFragment.newInstance("投放中"));
            }
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mViewPager.setCurrentItem(0);
    }

    public static MyAdsFragment newInstance() {
        return new MyAdsFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mTabMake, R.id.mTabPutIn, R.id.mTabPuting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTabMake:
                if (mViewPager.getCurrentItem() != 0)
                    mViewPager.setCurrentItem(0);
                break;
            case R.id.mTabPutIn:
                if (mViewPager.getCurrentItem() != 1) mViewPager.setCurrentItem(1);

                break;
            case R.id.mTabPuting:
                if (mViewPager.getCurrentItem() != 2)
                    mViewPager.setCurrentItem(2);
                break;
        }
    }

    void setStarts(int id) {
        mTabMake.setCardBackgroundColor(WHITE);
        mTabPutIn.setCardBackgroundColor(WHITE);
        mTabPuting.setCardBackgroundColor(WHITE);

        mTextMake.setTextColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_text_unselect));
        mTextPutIn.setTextColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_text_unselect));
        mTextPuting.setTextColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_text_unselect));
        switch (id) {
            case 0:
                mTabMake.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_tab_select));
                mTextMake.setTextColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_text_select));
                break;
            case 1:
                mTabPutIn.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_tab_select));
                mTextPutIn.setTextColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_text_select));
                break;
            case 2:
                mTabPuting.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_tab_select));
                mTextPuting.setTextColor(ContextCompat.getColor(getContext(), R.color.color_myads_title_text_select));
                break;
        }
    }
}

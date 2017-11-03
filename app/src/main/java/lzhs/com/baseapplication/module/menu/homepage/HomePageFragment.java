package lzhs.com.baseapplication.module.menu.homepage;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.homepage.bean.HomePageItemBean;
import lzhs.com.baseapplication.module.menu.homepage.delegate.HomePageItemType01;
import lzhs.com.baseapplication.module.menu.homepage.delegate.HomePageItemType02;
import lzhs.com.baseapplication.module.menu.homepage.delegate.HomePageItemType03;
import lzhs.com.baseapplication.module.menu.homepage.delegate.authentication.AuthenticationActivity;
import lzhs.com.baseapplication.module.menu.homepage.delegate.type.cleaning.CleaningActivity;
import lzhs.com.baseapplication.module.menu.homepage.delegate.type.recharge.RecargeActivity;
import lzhs.com.baseapplication.module.menu.myads.make.delegate.formework.SomehowScreenActivity;
import lzhs.com.library.base.BaseFragment_V4;
import lzhs.com.library.widget.adapter.recycle.MultiItemTypeAdapter;
import lzhs.com.library.widget.views.TitleBar;

/**
 * 首页
 */
public class HomePageFragment extends BaseFragment_V4 implements  HomePageOnItemSubViewClick {


    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.homeTitleBar)
    TitleBar homeTitleBar;

    Unbinder unbinder;


    List<HomePageItemBean> mDatas=new ArrayList<>();
    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatas.add(new HomePageItemBean(0));
        mDatas.add(new HomePageItemBean(1));
        mDatas.add(new HomePageItemBean(2));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MultiItemTypeAdapter adapter=new MultiItemTypeAdapter(getContext(),mDatas);
        adapter.addItemViewDelegate(0xa1,new HomePageItemType01(this));
        adapter.addItemViewDelegate(0xa2,new HomePageItemType02(this,this));
        adapter.addItemViewDelegate(0xa3,new HomePageItemType03(this));
        mRecyclerView.setAdapter(adapter);
        homeTitleBar.setOnClickToRight(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/11/2
                startActivity(new Intent(getContext(), AuthenticationActivity.class));
            }
        });
    }

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    //制作广告
    @Override
    public void makeADS() {
        startActivity(new Intent(getActivity(),SomehowScreenActivity.class));

    }
    //添加屏幕
    @Override
    public void addScreen() {
        // TODO: 2017/11/3 添加屏幕页面 
    }
    //立即结算
    @Override
    public void cleaning() {
        startActivity(new Intent(getContext(), CleaningActivity.class));
    }
    //充值
    @Override
    public void recharge() {
        startActivity(new Intent(getContext(), RecargeActivity.class));
    }
}

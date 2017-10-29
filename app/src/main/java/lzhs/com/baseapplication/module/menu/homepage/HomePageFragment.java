package lzhs.com.baseapplication.module.menu.homepage;


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
import lzhs.com.library.base.BaseFragment_V4;
import lzhs.com.library.widget.adapter.recycle.MultiItemTypeAdapter;

/**
 * 首页
 */
public class HomePageFragment extends BaseFragment_V4 implements  HomePageOnItemSubViewClick {


    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
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
    }

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

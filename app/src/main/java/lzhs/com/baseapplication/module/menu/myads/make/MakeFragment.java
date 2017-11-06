package lzhs.com.baseapplication.module.menu.myads.make;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.myads.make.bean.MakeItemTypeBean;
import lzhs.com.baseapplication.module.menu.myads.make.delegate.MakeItemType01;
import lzhs.com.baseapplication.module.menu.myads.make.delegate.MakeItemType02;
import lzhs.com.baseapplication.module.menu.myads.make.delegate.formework.SomehowScreenActivity;
import lzhs.com.library.base.BaseFragment_V4;
import lzhs.com.library.widget.adapter.recycle.MultiItemTypeAdapter;


/**
 * 广告制作<br/>s
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 16:44<br/>
 * 邮箱：1050629507@qq.com
 */
public class MakeFragment extends BaseFragment_V4 implements OnItemSubViewClick{


  @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;

    List<MakeItemTypeBean> mDatas = new ArrayList<>();


    public static MakeFragment newInstance(String argument) {
        Bundle bundle = new Bundle();
        MakeFragment makeFragment = new MakeFragment();
        makeFragment.setArguments(bundle);
        return makeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatas.add(new MakeItemTypeBean(true, 0));
        mDatas.add(new MakeItemTypeBean(true, 1));
        mDatas.add(new MakeItemTypeBean(true, 2));
        mDatas.add(new MakeItemTypeBean(true, 3));
        mDatas.add(new MakeItemTypeBean(false, 4));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_make, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        MultiItemTypeAdapter adapter=new MultiItemTypeAdapter(getContext(), mDatas);
        adapter.addItemViewDelegate(0x123,new MakeItemType01(this));
        adapter.addItemViewDelegate(0x1234,new MakeItemType02(this));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void submit() {
        Toast.makeText(getContext(),"你点击了提交按钮",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setting() {

        Toast.makeText(getContext(),"你点击了设置按钮",Toast.LENGTH_LONG).show();
    }

    @Override
    public void addNewADS() {
        startActivity(new Intent(getActivity(),SomehowScreenActivity.class));
        // Toast.makeText(getContext(),"你点击了添加按钮",Toast.LENGTH_LONG).show();
    }


}

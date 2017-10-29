package lzhs.com.baseapplication.module.menu.homepage.delegate.type;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseFragment_V4;
import lzhs.com.library.widget.adapter.recycle.CommonAdapter;
import lzhs.com.library.widget.adapter.recycle.base.ViewHolder;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 22:31<br/>
 * 邮箱：1050629507@qq.com
 */
public class HomePageTypeFragment extends BaseFragment_V4 {

    private static final String VAL_KEY = "val_key";
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;

    public static HomePageTypeFragment newInstance(ArrayList<HomePagerTypeBean> argument) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(VAL_KEY, argument);
        HomePageTypeFragment oneFragment = new HomePageTypeFragment();
        oneFragment.setArguments(bundle);
        return oneFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_home_pager_layout02_type, container, false);
        unbinder = ButterKnife.bind(this, view);

        initViews();
        return view;
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
        List<HomePagerTypeBean> datas = new ArrayList<>();
        ArrayList<HomePagerTypeBean> mDatas = getArguments().getParcelableArrayList(VAL_KEY);
        for (HomePagerTypeBean mData : mDatas) {
            datas.add(mData);
        }
        mRecyclerView.setAdapter(new TypeAdapter(getContext(), R.layout.item_home_page_type_layout, datas));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    static class TypeAdapter extends CommonAdapter<HomePagerTypeBean> {


        public TypeAdapter(Context context, @LayoutRes int layoutId, List<HomePagerTypeBean> mDatas) {
            super(context, layoutId, mDatas);
        }

        @Override
        protected void convert(ViewHolder holder, HomePagerTypeBean item, int position) {
            AutoUtils.auto(holder.getConvertView());
            ImageView mImg=holder.getView(R.id.mImgShow);

            holder.setText(R.id.mTextShow,item.getName());
            holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


        }
    }
}

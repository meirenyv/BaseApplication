package lzhs.com.baseapplication.module.menu.myads.putin;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.myads.make.bean.ShoppingCartBean;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.widget.adapter.recycle.CommonAdapter;
import lzhs.com.library.widget.adapter.recycle.base.ViewHolder;
import lzhs.com.library.widget.views.stateView.MultipleStatusView;

public class ContinueAddActivity extends BaseActivity {

    @BindView(R.id.RBrange)
    RadioButton RBrange;
    @BindView(R.id.RBsort)
    RadioButton RBsort;
    @BindView(R.id.RBorder)
    RadioButton RBorder;
    @BindView(R.id.mRVshopinglist)
    RecyclerView mRVshopinglist;
    @BindView(R.id.mTwinklingRefreshLayout)
    TwinklingRefreshLayout mTwinklingRefreshLayout;
    @BindView(R.id.MultipleStatusViewContent)
    LinearLayout MultipleStatusViewContent;
    @BindView(R.id.mMultipleStatusView)
    MultipleStatusView mMultipleStatusView;
    CommonAdapter mAdapter = null;
    private List<ShoppingCartBean>list=new ArrayList<>();{
        for (int i = 0; i < 10; i++) {
            ShoppingCartBean bean =new ShoppingCartBean();
            bean.setName(String.format("该数据为第%d条数据",i));
            list.add(bean);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_add);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        for (int i = 0; i <5 ; i++) {
            ShoppingCartBean shoppingCartBean=new ShoppingCartBean();
            shoppingCartBean.setName("蓝光.凯丽香江");
            shoppingCartBean.setPrice("22￥");
            shoppingCartBean.setScreens("屏幕组1组(拥有40个屏幕)");
            shoppingCartBean.setDetialOthes("289户");
            shoppingCartBean.setAddress("地址：成都市锦江区翠柳湾支路199号");
            list.add(shoppingCartBean);
        }
        RBrange.setTextColor(Color.parseColor("#333333"));
        RBsort.setTextColor(Color.parseColor("#6B6B6B"));
        RBorder.setTextColor(Color.parseColor("#6B6B6B"));
        //网络请求
        initView();
    }


    private void initView() {
        mMultipleStatusView.showLoading();//显示加载中视图
        mRVshopinglist.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new CommonAdapter<ShoppingCartBean>(this, R.layout.item_shoppingcart_layout,list){

            @Override
            protected void convert(ViewHolder holder, ShoppingCartBean bean, int position) {
                holder.setText(R.id.mTextShowName,bean.getName());
            }
        };

    }
}

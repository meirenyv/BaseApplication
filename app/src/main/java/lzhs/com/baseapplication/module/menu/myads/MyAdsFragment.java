package lzhs.com.baseapplication.module.menu.myads;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.mine.MineFragment;

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

}

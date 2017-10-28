package lzhs.com.baseapplication.module.menu.myscreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.myads.MyAdsFragment;

/**
 * 我的屏幕
 */
public class MyScreenFragment extends Fragment {


    public MyScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_screen, container, false);
    }
    public static MyScreenFragment newInstance() {
        return new MyScreenFragment();
    }

}

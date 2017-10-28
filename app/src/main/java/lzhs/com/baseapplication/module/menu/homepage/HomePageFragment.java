package lzhs.com.baseapplication.module.menu.homepage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lzhs.com.baseapplication.R;

/**
 * 首页
 */
public class HomePageFragment extends Fragment {


    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }
    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

}

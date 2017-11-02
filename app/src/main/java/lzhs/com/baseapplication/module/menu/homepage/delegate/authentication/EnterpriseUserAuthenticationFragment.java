package lzhs.com.baseapplication.module.menu.homepage.delegate.authentication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseFragment_V4;

/**
 * 企业用户认证
 */
public class EnterpriseUserAuthenticationFragment extends BaseFragment_V4 {


    public EnterpriseUserAuthenticationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enterprise_user_authentication, container, false);
    }
    public static EnterpriseUserAuthenticationFragment newInstance() {
        return new EnterpriseUserAuthenticationFragment();
    }

}

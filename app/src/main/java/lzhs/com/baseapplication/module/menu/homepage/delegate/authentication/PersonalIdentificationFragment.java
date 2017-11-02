package lzhs.com.baseapplication.module.menu.homepage.delegate.authentication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseFragment_V4;


/**
 * 个人身份认证
 */
public class PersonalIdentificationFragment extends BaseFragment_V4 {


    public PersonalIdentificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_identification, container, false);
    }
    public static PersonalIdentificationFragment newInstance() {
        return new PersonalIdentificationFragment();
    }

}

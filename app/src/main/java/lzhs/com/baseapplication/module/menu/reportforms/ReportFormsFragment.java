package lzhs.com.baseapplication.module.menu.reportforms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lzhs.com.baseapplication.R;

/**
 * 报表
 */
public class ReportFormsFragment extends Fragment {


    public ReportFormsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report_forms, container, false);
    }
    public static ReportFormsFragment newInstance() {
        return new ReportFormsFragment();
    }

}

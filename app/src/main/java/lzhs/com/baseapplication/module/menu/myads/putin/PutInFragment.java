package lzhs.com.baseapplication.module.menu.myads.putin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseFragment_V4;

/**
 * 可投放<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 16:44<br/>
 * 邮箱：1050629507@qq.com
 */
public class PutInFragment extends BaseFragment_V4 {
    static final String TAG = "TAG";

    @BindView(R.id.mViewSubmit)
    RelativeLayout mViewSubmit;
    @BindView(R.id.mViewSetting)
    RelativeLayout mViewSetting;

    Unbinder unbinder;


    public static PutInFragment newInstance(String argument) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG, argument);
        PutInFragment putInFragment = new PutInFragment();
        putInFragment.setArguments(bundle);
        return putInFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_ads_make_layout, container, false);
        unbinder = ButterKnife.bind(this, view);

       /* Random random = new Random();
        TextView tv = new TextView(getActivity());
        tv.setText(getArguments().getString(TAG));
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(Color.argb(random.nextInt(100),
                random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        return tv;*/
        init();
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    private void init() {
  mViewSubmit.setVisibility(View.GONE);
        mViewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),PutInStyleActivity.class));
            }
        });

    }

}

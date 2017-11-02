package lzhs.com.baseapplication.module.menu.homepage.delegate.authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;
import lzhs.com.library.widget.views.viewpager.ViewPagerFixed;

/**
 * 身份认证
 */
public class AuthenticationActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {


    @BindView(R.id.mVPFauthentication)
    ViewPagerFixed mVPFauthentication;
    @BindView(R.id.mRBPerson)
    RadioButton mRBPerson;
    @BindView(R.id.mRBEnterprise)
    RadioButton mRBEnterprise;
    private Fragment personfragment = PersonalIdentificationFragment.newInstance();
    private Fragment enterprisefragment= EnterpriseUserAuthenticationFragment.newInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        //设置沉浸式转台栏
        ActivityUtil.setStatusBarBackground(this);
        ButterKnife.bind(this);
        initView();
        initviewpager();
    }

    private void initviewpager() {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            ArrayList<Fragment> fragments = new ArrayList<>();

            {
                fragments.add(personfragment);
                fragments.add(enterprisefragment);

            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments != null ? fragments.size() : 0;
            }
        };
        mVPFauthentication.setAdapter(adapter);
        mVPFauthentication.setOffscreenPageLimit(2);
    }

    private void initView() {
        mRBPerson.setOnCheckedChangeListener(this);
        mRBEnterprise.setOnCheckedChangeListener(this);

    }



    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b){
            switch (compoundButton.getId()){
                case R.id.mRBPerson:
                    mVPFauthentication.setCurrentItem(0);
                    break;
                case R.id.mRBEnterprise:
                    mVPFauthentication.setCurrentItem(1);
                    break;

            }

        }
    }
}

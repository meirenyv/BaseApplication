package lzhs.com.baseapplication.module.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

/**
 * 手机注册页面
 */
public class PhoneRegistActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_regist);
        ButterKnife.bind(this);
        //设置沉浸式转台栏
        ActivityUtil.setStatusBarBackground(this);
    }


}

package lzhs.com.baseapplication.module.menu.homepage.delegate.type.recharge;

import android.os.Bundle;
import android.support.annotation.Nullable;

import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

/**
 * 充值 支付宝 微信
 */
public class RecargeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recarge);
        ActivityUtil.setStatusBarBackground(this);

    }
}

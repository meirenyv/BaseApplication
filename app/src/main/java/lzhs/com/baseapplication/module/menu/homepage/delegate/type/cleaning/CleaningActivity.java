package lzhs.com.baseapplication.module.menu.homepage.delegate.type.cleaning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.module.menu.homepage.delegate.type.recharge.RecargeActivity;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

/**
 * 购物车之立即结算
 */
public class CleaningActivity extends BaseActivity {

    @BindView(R.id.mLinMywallet)
    LinearLayout mLinMywallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning);
        ActivityUtil.setStatusBarBackground(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.mLinMywallet)
    public void onViewClicked() {
        startActivity(new Intent(this, RecargeActivity.class));
    }
}

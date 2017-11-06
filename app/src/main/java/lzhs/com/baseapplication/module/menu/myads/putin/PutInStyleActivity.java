package lzhs.com.baseapplication.module.menu.myads.putin;

import android.os.Bundle;
import android.support.annotation.Nullable;

import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

/**
 * 投放广告类型选择： 普通，自投 ，插播
 */
public class PutInStyleActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_in_style);
        ActivityUtil.setStatusBarBackground(this);
    }
}

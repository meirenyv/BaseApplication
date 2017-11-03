package lzhs.com.baseapplication.module.menu.myads.make.delegate.formework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

/**
 * 模板选择：横屏还是竖屏
 *
 *
 */
public class SomehowScreenActivity extends BaseActivity {


    @BindView(R.id.TVlandscape)
    TextView TVlandscape;
    @BindView(R.id.TVverticalScreen)
    TextView TVverticalScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somehow_screen);
        ButterKnife.bind(this);
        ActivityUtil.setStatusBarBackground(this);

    }

    @OnClick({R.id.TVlandscape, R.id.TVverticalScreen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.TVlandscape:
               //Toast.makeText(getApplicationContext(),"你点击了添加按钮",Toast.LENGTH_LONG).show();
           // startActivity(new Intent(getApplicationContext(),LoginActivity.class));
              startActivity(new Intent(getApplicationContext(),UseActivity.class));

                break;
            case R.id.TVverticalScreen:
               // startActivity(new Intent(this,UseActivity.class));
                break;
        }
    }
}

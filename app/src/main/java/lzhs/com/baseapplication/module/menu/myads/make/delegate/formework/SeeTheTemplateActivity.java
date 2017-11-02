package lzhs.com.baseapplication.module.menu.myads.make.delegate.formework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;

/**
 * 选择模板查看
 */
public class SeeTheTemplateActivity extends BaseActivity {

    @BindView(R.id.BTgoshoping)
    Button BTgoshoping;
    @BindView(R.id.BTuse)
    Button BTuse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_the_template);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.BTgoshoping, R.id.BTuse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BTgoshoping:
                break;
            case R.id.BTuse:
                break;
        }
    }
}

package lzhs.com.baseapplication.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

public class NewAppActivity extends BaseActivity {

    @BindView(R.id.mButtonRegist)
    Button mButtonRegist;
    @BindView(R.id.mButtonLogin)
    Button mButtonLogin;
    @BindView(R.id.ImgQQ)
    ImageView ImgQQ;
    @BindView(R.id.ImgWeChat)
    ImageView ImgWeChat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_app);
        ButterKnife.bind(this);
        ActivityUtil.setStatusBarBackground(this);
    }

    @OnClick({R.id.mButtonRegist, R.id.mButtonLogin, R.id.ImgQQ, R.id.ImgWeChat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mButtonRegist:
                startActivity(new Intent(this, PhoneRegistActivity.class));
                break;
            case R.id.mButtonLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.ImgQQ:
                break;
            case R.id.ImgWeChat:
                break;
        }
    }
}

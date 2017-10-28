package lzhs.com.baseapplication.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.baseapplication.mvp.login.LoginPresenter;
import lzhs.com.baseapplication.mvp.login.LoginView;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

/**
 * 该页面账号登陆页面<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/25 16:58<br/>
 * 邮箱：1050629507@qq.com
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.mETLoninPhone)
    EditText mETLoninPhone;
    @BindView(R.id.mIVdeleteinput)
    ImageView mIVdeleteinput;
    @BindView(R.id.mETLoninPSW)
    EditText mETLoninPSW;
    @BindView(R.id.mTextGetCode)
    TextView mTextGetCode;
    @BindView(R.id.mButtonRegis)
    Button mButtonRegis;
    @BindView(R.id.mButtonRegisPhone)
    Button mButtonRegisPhone;
    @BindView(R.id.mButtonRegisQQ)
    Button mButtonRegisQQ;
    @BindView(R.id.mButtonRegisWeChat)
    Button mButtonRegisWeChat;
    @BindView(R.id.mTextConsent)
    TextView mTextConsent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //设置沉浸式转台栏
        ActivityUtil.setStatusBarBackground(this);
        initView();
    }

    private void initView() {

    }

    @Override
    public LoginPresenter onCreatePresenter() {
        return new LoginPresenter();
    }


    @OnClick(R.id.mButtonRegisPhone)
    public void onViewClicked() {
      startActivity(new Intent(this, PhoneRegistActivity.class));
    }
}

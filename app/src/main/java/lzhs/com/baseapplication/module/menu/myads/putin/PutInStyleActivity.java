package lzhs.com.baseapplication.module.menu.myads.putin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

/**
 * 投放广告类型选择： 普通，自投 ，插播
 */
public class PutInStyleActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.mRBCommon)
    RadioButton mRBCommon;
    @BindView(R.id.mRBputinByMyself)
    RadioButton mRBputinByMyself;
    @BindView(R.id.fvjjv)
    TextView fvjjv;
    @BindView(R.id.fvjjc)
    TextView fvjjc;
    @BindView(R.id.mLinStartAndEndtime)
    LinearLayout mLinStartAndEndtime;
    @BindView(R.id.mTextPutinDates)
    TextView mTextPutinDates;
    @BindView(R.id.CKSeleck)
    CheckBox CKSeleck;
    @BindView(R.id.mTextWaitBegin)
    TextView mTextWaitBegin;
    @BindView(R.id.mTextWaitBeginHour)
    TextView mTextWaitBeginHour;
    @BindView(R.id.mLinCallWaitingTime)
    LinearLayout mLinCallWaitingTime;
    @BindView(R.id.RBfifteenminute)
    RadioButton RBfifteenminute;
    @BindView(R.id.RBthirtyminute)
    RadioButton RBthirtyminute;
    @BindView(R.id.RBfortyfiveminute)
    RadioButton RBfortyfiveminute;
    @BindView(R.id.RBsixtyminute)
    RadioButton RBsixtyminute;
    @BindView(R.id.mLinCallWaitingSelectTime)
    LinearLayout mLinCallWaitingSelectTime;
    @BindView(R.id.RGADstyle)
    RadioGroup RGADstyle;
    @BindView(R.id.BTSelectAddress)
    Button BTSelectAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_in_style);
        ButterKnife.bind(this);
        ActivityUtil.setStatusBarBackground(this);
        RGADstyle.setOnCheckedChangeListener(this);
        CKSeleck.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.mRBCommon:
                mLinStartAndEndtime.setVisibility(View.VISIBLE);
                mTextPutinDates.setVisibility(View.VISIBLE);
                break;
            case R.id.mRBputinByMyself:
                mLinStartAndEndtime.setVisibility(View.VISIBLE);
                mTextPutinDates.setVisibility(View.VISIBLE);
                break;

        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            switch (compoundButton.getId()) {
                case R.id.CKSeleck:
                    mLinStartAndEndtime.setVisibility(View.GONE);
                    mTextPutinDates.setVisibility(View.GONE);
                    mLinCallWaitingTime.setVisibility(View.VISIBLE);
                    mLinCallWaitingSelectTime.setVisibility(View.VISIBLE);
            }
        }
    }

    @OnClick(R.id.BTSelectAddress)
    public void onViewClicked() {
        //  跳转到继续添加界面
        startActivity(new Intent(this,ContinueAddActivity.class));
    }
}

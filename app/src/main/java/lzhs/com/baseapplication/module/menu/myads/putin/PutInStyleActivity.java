package lzhs.com.baseapplication.module.menu.myads.putin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;
import lzhs.com.library.utils.tools.DateChooseUtils;

/**
 * 投放广告类型选择： 普通，自投 ，插播
 */
public class PutInStyleActivity extends BaseActivity implements
        CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener
    {

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
    @BindView(R.id.mRLBeginTime)
    RelativeLayout mRLBeginTime;
    @BindView(R.id.mRLEndTime)
    RelativeLayout mRLEndTime;
    @BindView(R.id.Relativehour)//小时分钟选择
            RelativeLayout Relativehour;
    @BindView(R.id.RelativeCallWaitingCalender)
    RelativeLayout RelativeCallWaitingCalender;

    int TAG;

    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";//日历
    private static final String FRAG_TAG_TIME_PICKER = "timePickerDialogFragment";//时间


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
                CKSeleck.setChecked(false);
                CKSeleck.setClickable(false);
                mLinStartAndEndtime.setVisibility(View.VISIBLE);
                mTextPutinDates.setVisibility(View.VISIBLE);
                break;
            case R.id.mRBputinByMyself:
                CKSeleck.setChecked(false);
                CKSeleck.setClickable(false);

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
                    mRBCommon.setClickable(false);
                    mRBputinByMyself.setClickable(false);
                    mLinStartAndEndtime.setVisibility(View.GONE);
                    mTextPutinDates.setVisibility(View.GONE);
                    mLinCallWaitingTime.setVisibility(View.VISIBLE);
                    mLinCallWaitingSelectTime.setVisibility(View.VISIBLE);
            }
        }
    }

    @OnClick({R.id.mRLBeginTime, R.id.mRLEndTime, R.id.BTSelectAddress, R.id.Relativehour, R.id.RelativeCallWaitingCalender})
    public void onViewClicked(View view) {
        switch ( view.getId()) {
            case R.id.mRLBeginTime://普通或者自投的开始日期
                Long longTime=System.currentTimeMillis();
                Log.i("info","开始时间："+fvjjv.getText().toString());
            DateChooseUtils.chooseDate(1,this, longTime, fvjjv.getText().toString(), new DateChooseUtils.GetDateInfoListenter() {
                @Override
                public void getDateInfo(String date_info) {
                    fvjjv.setText(date_info);
                }
            });

                break;
            case R.id.mRLEndTime://普通或者自投的结束日期
                String startTime = fvjjv.getText().toString();
            if (!startTime.equals("开始时间")){
                DateChooseUtils.chooseDate(2,this, System.currentTimeMillis(), startTime, new DateChooseUtils.GetDateInfoListenter() {
                    @Override
                    public void getDateInfo(String date_info) {
                        fvjjc.setText(date_info);
                    }
                });
            } else{
                Toast.makeText(this, "请选择起始日期", Toast.LENGTH_LONG).show();
            }
                break;
            case R.id.RelativeCallWaitingCalender://插播起始日期选择

                TAG=3;
                break;
            case R.id.BTSelectAddress://  跳转到继续添加界面
                startActivity(new Intent(this, ContinueAddActivity.class));
                break;
            case R.id.Relativehour:
                DateChooseUtils.TimePicker(this, new DateChooseUtils.GetTimeInfoListenter() {
                    @Override
                    public void getTimeInfo(String time_info) {
                        mTextWaitBeginHour.setText(time_info);
                    }
                });
                break;
        }
    }



}

package lzhs.com.baseapplication.module.menu.myads.putin;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
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

import com.codetroopers.betterpickers.OnDialogDismissListener;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.calendardatepicker.MonthAdapter;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzhs.com.baseapplication.R;
import lzhs.com.library.base.BaseActivity;
import lzhs.com.library.utils.ActivityUtil;

/**
 * 投放广告类型选择： 普通，自投 ，插播
 */
public class PutInStyleActivity extends BaseActivity implements CalendarDatePickerDialogFragment.OnDateSetListener,
        CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener
        , RadialTimePickerDialogFragment.OnTimeSetListener, OnDialogDismissListener {

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
    protected void onResume() {
        super.onResume();
        RadialTimePickerDialogFragment rtpd = (RadialTimePickerDialogFragment) getSupportFragmentManager().findFragmentByTag(FRAG_TAG_TIME_PICKER);
        if (rtpd != null) rtpd.setOnTimeSetListener(this);
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
        switch (view.getId()) {
            case R.id.mRLBeginTime://普通或者自投的开始日期
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(PutInStyleActivity.this)
                        .setFirstDayOfWeek(Calendar.SUNDAY)
                        .setPreselectedDate(2017, 8, 15)
                        .setDoneText("确认")
                        //.setDateRange(october,null)//设置对话框的范围，以在特定日期内。在therange之外的数年和数月没有显示，在范围之外的日子是可见的，但不能选择。

                        .setCancelText("取消");
                cdp.show(getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
                TAG = 1;
                break;
            case R.id.mRLEndTime://普通或者自投的结束日期
                String startTime = fvjjv.getText().toString();
                String[] temp = null;
                temp = startTime.split("-");

                // etShow.setText(temp[0] + " linc " + temp[1]);
                if (null != startTime) {
                    CalendarDatePickerDialogFragment cdpend = new CalendarDatePickerDialogFragment()
                            .setOnDateSetListener(PutInStyleActivity.this)
                            .setFirstDayOfWeek(Calendar.SUNDAY)
                            .setPreselectedDate(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[2]))//日历默认选中时间 实际月份比+1
                            .setDoneText("确认")
                            .setDateRange(new MonthAdapter.CalendarDay(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[2])), null)//设置对话框的范围，以在特定日期内。在therange之外的数年和数月没有显示，在范围之外的日子是可见的，但不能选择。

                            .setCancelText("取消");
                    cdpend.show(getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
                }

                TAG = 2;
                break;
            case R.id.RelativeCallWaitingCalender://插播起始日期选择
                CalendarDatePickerDialogFragment calendarDatePickerDialogFragment = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(PutInStyleActivity.this)
                        .setFirstDayOfWeek(Calendar.SUNDAY)
                        .setPreselectedDate(2017, 8, 15)
                        .setDoneText("确认")
                        .setCancelText("取消");
                calendarDatePickerDialogFragment.show(getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
                TAG=3;
                break;
            case R.id.BTSelectAddress://  跳转到继续添加界面
                startActivity(new Intent(this, ContinueAddActivity.class));
                break;
            case R.id.Relativehour:
                RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                        .setOnTimeSetListener(PutInStyleActivity.this)
                        .setOnDismissListener(PutInStyleActivity.this);
                rtpd.show(getSupportFragmentManager(), FRAG_TAG_TIME_PICKER);
                break;
        }
    }

    //日历选择器
    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        String dateStr = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
        if (null != dateStr) {
            switch (TAG) {
                case 1:
                    fvjjv.setText(dateStr);
                    break;
                case 2:
                    // TODO: 2017/11/7 判断开始时间是否为空
                    if (fvjjv.getText().toString().equals("") || (null == fvjjv.getText().toString())) {
                        mRLEndTime.setClickable(false);
                        Toast.makeText(this, "请选择起始日期", Toast.LENGTH_SHORT).show();
                    } else {
                        fvjjc.setText(dateStr);
                    }
                    break;
                case 3:
                    mTextWaitBegin.setText(dateStr);
            }
        }
    }

    //时间选择器
    @Override
    public void onDialogDismiss(DialogInterface dialoginterface) {
        // mTextWaitBeginHour.setText(R.string.dialog_dismissed);
    }

    @Override
    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
        Log.i("====================", "onTimeSet: " + hourOfDay + minute);
        mTextWaitBeginHour.setText(getString(R.string.radial_time_picker_result_value, hourOfDay, minute));
    }
}

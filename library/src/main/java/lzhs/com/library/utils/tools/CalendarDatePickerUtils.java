package lzhs.com.library.utils.tools;

import android.icu.util.Calendar;
import android.support.v4.app.FragmentManager;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.calendardatepicker.MonthAdapter;

/**
 * Created by lenovo on 2017/11/7.
 */

public class CalendarDatePickerUtils  {
    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";//日历
    public  static void  addCalendar(int year, int month, int day,FragmentManager manager){
        CalendarDatePickerDialogFragment cdpend = new CalendarDatePickerDialogFragment()
                .setOnDateSetListener(new CalendarDatePickerDialogFragment.OnDateSetListener() {
                    @Override
                    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
                        // TODO: 2017/11/7   控件显示
                    }
                })
                .setFirstDayOfWeek(Calendar.SUNDAY)
                //.setPreselectedDate(year,month,day)//日历默认选中时间 实际月份比+1
                .setDoneText("确认")
                .setDateRange(new MonthAdapter.CalendarDay(year, month, day), null)//设置对话框的范围，以在特定日期内。在therange之外的数年和数月没有显示，在范围之外的日子是可见的，但不能选择。

                .setCancelText("取消");
        cdpend.show(manager, FRAG_TAG_DATE_PICKER);
    }


}

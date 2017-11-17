package lzhs.com.library.utils.tools;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.calendardatepicker.MonthAdapter;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChooseUtils {
    /**
     * 
     * @param context Activity 上下文
     * @param longtime 后台指定/系统时间
     * @param getDateInfoListenter
     */
    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";//日历
    private static final String FRAG_TAG_TIME_PICKER = "timePickerDialogFragment";//时间

    public static  void chooseDate(int TAG,AppCompatActivity context, Long longtime, String ViewStartTime, final GetDateInfoListenter  getDateInfoListenter ){
       String []nowTimeStart=new SimpleDateFormat("yyyy-MM-dd").format(new Date(longtime)).split("-");
        int year1= Integer.valueOf(nowTimeStart[0]);
        int  monthOfYear1=Integer.valueOf(nowTimeStart[1])-1;
        int dayOfMouth1=Integer.valueOf(nowTimeStart[2]);


        CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                .setFirstDayOfWeek(Calendar.SUNDAY)//日历默认排列在第一位的星期
                .setOnDateSetListener(new CalendarDatePickerDialogFragment.OnDateSetListener() {
                    @Override
                    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
                        getDateInfoListenter.getDateInfo( year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                })
                .setDoneText("确认")
                .setCancelText("取消");


       if (TAG==1){
            cdp.setPreselectedDate(year1, monthOfYear1, dayOfMouth1)//日历默认选中的时间
                .setDateRange(new MonthAdapter.CalendarDay(year1,monthOfYear1,dayOfMouth1),null);
        }else {
           String[] temp=ViewStartTime.split("-");
           int year2=Integer.parseInt(temp[0]);
           int  monthOfYear2=Integer.parseInt(temp[1]) - 1;
           int dayOfMouth2= Integer.parseInt(temp[2]);
                cdp.setPreselectedDate(year2, monthOfYear2, dayOfMouth2)//日历默认选中的时间
                   .setDateRange(new MonthAdapter.CalendarDay(year2, monthOfYear2, dayOfMouth2), null);//在范围之外的日子是可见的，但不能选择。
       }
        cdp.show(context.getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
    }
    public static  void  TimePicker(AppCompatActivity context, final GetTimeInfoListenter getTimeInfoListenter){
        RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                .setOnTimeSetListener(new RadialTimePickerDialogFragment.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
                        getTimeInfoListenter.getTimeInfo(hourOfDay+":"+minute);
                    }
                });
        rtpd.show(context.getSupportFragmentManager(), FRAG_TAG_TIME_PICKER);
    }
    /**
     * 控件展示日期
     */
    public interface GetDateInfoListenter{
        void getDateInfo(String  date_info);
    }

    /**
     * 控件展示时间
     */
    public  interface GetTimeInfoListenter{
        void getTimeInfo(String time_info);
    }
}

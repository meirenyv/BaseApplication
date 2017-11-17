package lzhs.com.library.utils.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/11/14.
 */

public class DateUtils {
    /**
     * 格式化数据
     * @param format 例如"yyyy-MM-dd HH:mm:ss"
     * @param time
     * @return
     */
    public  static String formateTime(String format ,long time){
        return  new SimpleDateFormat(format).format(new Date(time));
    }

}

package red.kalos.usersystem.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ToDay {
    private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * @Author:whf
     * @param:
     * @Description: 获得“今天”零点时间戳 获得2点的加上2个小时的毫秒数就行
     * @Date:2018/4/12 0012
     */
    public Long getTodayZeroPointTimestamps(){
        long currentTimestamps=System.currentTimeMillis();
        long oneDayTimestamps= 60 * 60 * 24 * 1000;
        return currentTimestamps-(currentTimestamps+60*60*8*1000)%oneDayTimestamps;
    }

    public Long getTheMonth(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //获得本月第一天
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        long oneDayTimestamps= 60 * 60 * 24 * 1000;
        return calendar.getTime().getTime()-(calendar.getTime().getTime()+60*60*8*1000)%oneDayTimestamps;
    }


    public String toString(long timeUS) {
        return SDF.format(timeUS);
    }

}

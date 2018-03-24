package jdbc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomTimeFactory {
	
	/** 
     * 獲取隨機日期
     * 
     * @param beginDate
     *            起始日期，格式為：yyyy-MM-dd 
     * @param endDate 
     *            結束日期，格式為：yyyy-MM-dd 
     * @return 
     */  
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate); // 取開始日期
            Date end = format.parse(endDate);// 取結束日期
            // getTime()表示取自 1970 年 1 月 1 日 00:00:00 GMT 以來此 Date 對象表示的毫秒數。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }  
  
    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是開始時間和結束時間，則遞迴使用本方法查找隨機值  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }  
}

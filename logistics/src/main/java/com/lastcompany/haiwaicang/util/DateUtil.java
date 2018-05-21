package com.lastcompany.haiwaicang.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static String date2String(Date date){
		return new SimpleDateFormat(DATE_FORMAT_PATTERN).format(date);
	}
	public static String getInstance() {
		return date2String(new Date());
	}
	public static String date2String(Date date, String string) {
		return new SimpleDateFormat("yyy-MM-dd").format(date);
	}
	public static String getDateString(int number) {
		StringBuffer stringBuffer = new StringBuffer();
		number = Math.min(number, 8);
		String format = "yyyyMMdd";
		if(number > 4){
			format = "yyMMdd";
		}else if(number > 2){
			format = "yyMM";
		}else if(number <= 2){
			format = "yy";
		}
		stringBuffer.append(new SimpleDateFormat(format).format(new Date()));
		return stringBuffer.toString();
	}
	/**
	 * 将long型的时间time，转换为定义格式的时间字符串
	 * 
	 * @param time
	 * @return
	 */
	public static String long2String(long time) {
		return date2String(new Date(time));
	}

	/*

	获取当前时间之前或之后几分钟 minute

	*/
	public static Date getTimeByMinute(int minute) {
		Calendar calendar = Calendar.getInstance();

		Date temp = TimezoneUtil.timeConvert(calendar.getTime(),calendar.getTimeZone().getID(),"Asia/Shanghai");

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(temp);

		calendar2.add(Calendar.MINUTE, minute);

		return calendar2.getTime();

	}


	public static String getnewDate()
	{
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat(DATE_FORMAT_PATTERN);
		String time=df.format(date);
		return time;
	}

}


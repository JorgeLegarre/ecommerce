package se.legarre.ecommerce.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils
{
	public static String formatDate(long date)
	{
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdt.format(date);
	}

	public static long getCurrentDate()
	{
		return (new Date()).getTime();
	}
}

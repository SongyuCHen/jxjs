package nju.software.jxjs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
	/**
	 * default date format
	 */
	public static final String STANDARD_FORMAT = "yyyy-MM-dd";
	
	public static SimpleDateFormat STANDARD_SDF = new SimpleDateFormat(STANDARD_FORMAT);
	
	public static String getStandardFormat(Date date)
	{
		return STANDARD_SDF.format(date);
	}
}

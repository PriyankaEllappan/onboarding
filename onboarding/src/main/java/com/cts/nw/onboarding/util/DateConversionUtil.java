package com.cts.nw.onboarding.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversionUtil {

	/**
	 * @param format
	 * @param dateString
	 * @return
	 */
	public static Date convertStringToDate(String format, String dateString) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			System.out.println("dateString converted to Date : " + dateString);
			return simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

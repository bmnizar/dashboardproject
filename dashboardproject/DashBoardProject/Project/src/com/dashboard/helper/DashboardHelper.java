package com.dashboard.helper;

import java.util.Calendar;
import java.util.Date;

/**
 * @author BMN(BM.NIZAR) s715055
 *
 */
public class DashboardHelper {

	/**
	 * @return
	 */
	public static Date getDateOfExpiryMoralPerson() {
		Calendar todayCalendar = Calendar.getInstance();
		Integer todayYear = todayCalendar.get(Calendar.YEAR);
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.YEAR, todayYear+1);
		instance.set(Calendar.MONTH, 12);
		instance.set(Calendar.DAY_OF_MONTH, 31);
		Date time = instance.getTime();
		return time;
	}

}

package Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class commonUtils {

	public static String getCurrentDate() {
		DateFormat customformat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}
}

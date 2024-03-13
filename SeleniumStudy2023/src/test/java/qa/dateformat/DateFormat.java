package qa.dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static void main(String[] args)
	{

		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		Date datestart = new Date();

		try {
			Date Strttimeformated = format.parse(datestart.toString());
			System.out.println("Parsed date: " + Strttimeformated);
		} catch (java.text.ParseException e) {
			System.err.println("Error parsing date: " + e.getMessage());
		}

	}


}



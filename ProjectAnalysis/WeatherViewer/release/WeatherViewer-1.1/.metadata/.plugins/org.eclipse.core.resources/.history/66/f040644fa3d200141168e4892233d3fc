package group17.weatherviewer;

import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {
	public static String convert(String value, char unitFrom, char unitTo){
		double number = Double.parseDouble(value);
		double result = 0;
		
		//convert fahrenheit to celsius
		if (unitFrom == 'F' && unitTo == 'C')
			result = (number - 32) * 5/9;
		
		//convert celsius to fahrenheit
		if (unitFrom == 'C' && unitTo == 'F')
			result = number *9/5 + 32;
		
		//do the same for other conversions
		
		return String.valueOf(result);
	}

    /**
     * Accepts a unix time string and converts it to a time of day on a 24-hour clock
     * @param unixTime string representation of unix time
     * @return the time of day corresponding to the unix time
     */
    public static String toTime(String unixTime) {
        //we only care about hours and minutes
        DateFormat df = new SimpleDateFormat("HH:mm");
        //multiply by 1000 for milliseconds
        return df.format(new Date(1000*Long.parseLong(unixTime)));
    }
}

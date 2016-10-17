package implem;

import model.DatePart;
import model.IDate;
import model.IISoCalendar;

public class Date implements IDate {
	private static final int MINYEAR = -2000;
	private static final int MAXYEAR = 2000;
	
	private static final IDate MINDATE = new Date(MINYEAR,1,1);
	private static final IDate MADATE = new Date(MAXYEAR,12,31);
	
	private int year,month,day;
	
	/**
	 * @return the current local date.
	 */
	public static IDate today(){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param ordinal
	 * @return the date corresponding to the proleptic Gregorian ordinal, 
	 * where January 1 of year 1 has ordinal 1
	 */
	public static IDate fromOrdinal(int ordinal) {
		//TODO
		return null;
	}
	
	/**
	 * @param timestamp can be obtained va long unixTime = System.currentTimeMillis() / 1000L;
	 * @return the local date corresponding to the POSIX timestamp
	 */
	public static IDate fromtimestamp(long timestamp) {
		//TODO
		return null;
	}
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public IDate replace(DatePart datePart, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDate toOrdinal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int weekDay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int isoWeekDay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IISoCalendar isoCalendar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String isoFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ctime() {
		// TODO Auto-generated method stub
		return null;
	}

}

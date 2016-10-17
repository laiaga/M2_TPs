package implem;

import com.google.common.base.Preconditions;

import model.DatePart;
import model.IDate;
import model.IISoCalendar;

public class Date implements IDate {
	private static final int MINYEAR = -2000;
	private static final int MAXYEAR = 2000;
	private static final IDate MINDATE = new Date(MINYEAR, 1, 1);
	private static final IDate MAXDATE = new Date(MAXYEAR, 12, 31);

	private int year, month, day;

	/**
	 * @return the current local date.
	 */
	public static final IDate today() {
		// TODO
		return null;
	}

	/**
	 * 
	 * @param ordinal
	 * @return the date corresponding to the proleptic Gregorian ordinal, where
	 *         January 1 of year 1 has ordinal 1
	 * @throws IllegalArgumentException if ordinal<1 or ordinal>MAXDATE.toOrdinal()
	 */
	public static final IDate fromOrdinal(int ordinal) throws IllegalArgumentException  {
		// TODO
		return null;
	}

	/**
	 * @param timestamp
	 *            can be obtained va long unixTime = System.currentTimeMillis()
	 *            / 1000L;
	 * @return the local date corresponding to the POSIX timestamp
	 */
	public static final IDate fromTimestamp(long timestamp) {
		// TODO
		return null;
	}

	/**
	 * Constructor for date
	 * @param year
	 * @param month
	 * @param day
	 * @throws IllegalArgumentException if the year is not between MINYEAR and MAXYEAR
	 * 			or if the month is not between 1 and 12
	 * 			or if the day is not between 1 and month length
	 */
	public Date(int year, int month, int day) throws IllegalArgumentException {
		Preconditions.checkArgument(year <= MAXYEAR && year >= MINYEAR,
				"A date must have a year between " + MINYEAR + " and " + MAXYEAR + ".");
		Preconditions.checkArgument(1 <= month && month <= 12, 
				"A date must have a month between 1 and 12.");
		Preconditions.checkArgument(1 <= day && day <= nbDaysInMonth(month, year),
				"A date must have a day betweeen 1 and " + nbDaysInMonth(month, year) + ".");

		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * Checks the length of a given month, and if the year is a leap year in case it's ferbruary
	 * @param month the month we want to know the length
	 * @param year the year in order to know if it is a leap year
	 * @return the number of days in the month
	 */
	private int nbDaysInMonth(int month, int year) {
		// TODO
		return -1;
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

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

}
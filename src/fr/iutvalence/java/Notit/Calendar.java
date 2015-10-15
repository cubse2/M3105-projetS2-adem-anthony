package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Calendar
{
	private Set<Date> listOfDateForAMonth;
	private int monthNumber;

	/**
	 * Create calendar for a month of one year.
	 * @param month
	 * @param year
	 * @throws IOException
	 */
	public Calendar(int month, int year) throws IOException
	{
		this.monthNumber = month;
		this.listOfDateForAMonth = getAllDatesInAMonthOfOneYear(month, year);
	}

	public Set<Date> getAllDatesInAMonthOfOneYear(int month, int year)
			throws IOException
	{ 
		Date firstDayOfMonth = new Date(year, month, 1);
		int nbDaysInMonth = 0;
		if (month == 2)
		{
			nbDaysInMonth = firstDayOfMonth.isLeapYear(year) ? 29 : 28;
		} else
		{
			nbDaysInMonth = firstDayOfMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		}
		int nbDay = 1;
		SortedSet<Date> listOfDays = new TreeSet<Date>();
		while (nbDay <= nbDaysInMonth)
		{
			listOfDays.add(new Date(year, month, nbDay));
			nbDay++;
		}
		return listOfDays;
	}

	public Set<Date> getListOfDateForAMonth()
	{
		return listOfDateForAMonth;
	}

	public void setListOfDateForAMonth(int month, int year) throws IOException
	{
		this.listOfDateForAMonth = getAllDatesInAMonthOfOneYear(month, year);
	}
	
	public int getDayOfWeekForFirstDayOfMonth(){
		for (Date date : this.listOfDateForAMonth)
		{
			if (date.get(Date.DAY_OF_MONTH) == 1){
				return date.get(Date.DAY_OF_WEEK);
			}
		}
		return 0;
	}
	
	public int getMonthNumber() {
		return monthNumber;
	}

	public String toString()
	{
		final StringBuilder result = new StringBuilder();
		for (Date date : listOfDateForAMonth)
		{
			result.append(date);
			result.append("\n");
		}
		return result.toString();
	}
}

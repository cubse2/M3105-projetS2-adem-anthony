package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;

/**
 * The description of a date (year, month, day).
 * 
 * @author G19
 */

public class Date extends GregorianCalendar
{

	private Set<DayNote> collectionOfNote;
	private String dayName;
	private String monthName;

	/**
	 * create a date with its collection of note 
	 */
	public Date(int year, int month, int day) throws IOException
	{
		super(year, month, day);
		this.collectionOfNote = new NoteList(this).getlistOfDayNote();
		this.searchDayAndMonthName();
	}

	/**
	 * create a current date with its collection of note
	 */
	public Date() throws IOException
	{
		super();
		this.collectionOfNote = new NoteList(this).getlistOfDayNote();
		this.searchDayAndMonthName();
	}
	
	private void searchDayAndMonthName()
	{
		DateFormatSymbols formatSymbol = new DateFormatSymbols(Locale.ENGLISH);
		String[] daysName = formatSymbol.getWeekdays();
		this.dayName = daysName[this.get(DAY_OF_WEEK)];
		String[] monthsName = formatSymbol.getMonths();
		this.monthName = monthsName[this.get(MONTH)];
	}
	
	public void updateNotesCollection() throws IOException{
		this.collectionOfNote = new NoteList(this).getlistOfDayNote();
	}
	
	public Set<DayNote> getCollectionOfNote() {
		return collectionOfNote;
	}
	
	/**
	 * Get a String of the date (Wednesday 10 June 2015).
	 * @return String
	 */
	public String getEntireDate(){
		return this.dayName + " " + this.get(DAY_OF_MONTH) + " " + this.monthName + " " + this.get(YEAR);
	}
	
	/**
	 * Get a String of the date (2015-05-10).
	 * @return String
	 */
	public String getDate(){
		return this.get(YEAR) + "-" + this.get(MONTH) + "-" + this.get(DAY_OF_MONTH);
	}
	

	public String toString()
	{
		return this.get(DAY_OF_MONTH) + "/" + this.get(MONTH) + "/"
				+ this.get(YEAR) + " : " + this.collectionOfNote.size();
	}
}

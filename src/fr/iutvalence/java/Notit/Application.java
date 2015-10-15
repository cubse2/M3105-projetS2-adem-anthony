package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.Set;

public class Application {
	
	private int currentYear;
	
	/**
	 * Create new instance of app with current year.
	 * @throws IOException
	 */
	public Application() throws IOException{
		this.currentYear = new Date().get(Date.YEAR);
	}
	
	public void editExistingDayNote(DayNote dayNote, String title, String content) throws IOException{
		dayNote.setTitle(title);
		dayNote.setContent(content);
		dayNote.editNote();
	}
	
	public void createDayNote(String title, String content, Date date) throws IOException{
		String path = "Notes/"+date.getDate();
		editExistingDayNote(new DayNote(Path.maxFileInPath(path), title, content, date), title, content);
	}

	public void editExistingGeneralNote(GeneralNote generalNote, String title, String content) throws IOException{
		generalNote.setTitle(title);
		generalNote.setContent(content);
		generalNote.editNote();
	}
	
	public void createGeneralNote(String title, String content) throws IOException{
		String path = "GeneralNotes";
		editExistingGeneralNote(new GeneralNote(Path.maxFileInPath(path), title, content), title, content);
	}
	
	public void deleteDayNote(DayNote dayNote) throws IOException{
		dayNote.deleteNote();
	}
	
	public void deleteGeneralNote(GeneralNote generalNote) throws IOException{
		generalNote.deleteNote();
	}
	
	public Set<GeneralNote> getGeneralNote() throws IOException{
		return new NoteList().getlistOfGeneralNote();
	}
	
	public Set<DayNote> getDayNote() throws IOException{
		return new NoteList(new Date()).getlistOfDayNote();
	}
	
	public Calendar getCalendarOfAMonth(int monthNumber) throws IOException{
		return new Calendar(monthNumber, this.currentYear);
	}
}

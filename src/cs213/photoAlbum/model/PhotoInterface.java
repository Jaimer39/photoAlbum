package cs213.photoAlbum.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Pavan Amin
 *
 */
public interface PhotoInterface {
	String name = "";
	String caption = "";
	ArrayList<Tag> tags = new ArrayList<Tag>();
	
	/**
	 * @return Returns name of photo
	 */
	public String getName();
	
	/**
	 * @return Returns caption on photo
	 */
	public String getCaption();
	
	/**
	 * @param newCaption New caption to be added
	 * @return
	 */
	public void changeCaption(String newCaption);
	
	/**
	 * @param type Type of tag
	 * @param value Value of tag
	 */
	public void addTag(String type, String value);
	
	/**
	 * @param type Type of tag
	 * @param value Value of tag
	 */
	public void deleteTag(String type, String value);
	
	/**
	 * @param tp The type of tags to be printed
	 */
	public void listTags(String tp);
}

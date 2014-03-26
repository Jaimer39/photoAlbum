package cs213.photoAlbum.model;

import java.lang.Object;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



/**
 * @author Pavan Amin
 *
 */
public class Photo implements PhotoInterface {
	
	protected Calendar cal;
	protected String name;
	protected String caption;
	protected ArrayList<Tag> tags;
	
	/**
	 * @param n Name of photo
	 * @param c Caption on photo
	 * @param date Date added
	 */
	public Photo(String n, String c)
	{
		this.name = n;
		this.caption = c;
		this.cal.setTime(this.cal.getTime());
	}
	
	
	
	/**
	 * @param n Name of photo
	 * @param c Caption on photo
	 * @param date Date added
	 * @param t Tags
	 */
	public Photo(String n, String c, Date date, ArrayList<Tag> t)
	{
		this.name = n;
		this.caption = c;
		this.cal.setTime(date);
		this.tags = t;
	}
	

	public String getName()
	{
		return this.name;
	}

	
	public String getCaption()
	{
		return this.caption;
	}
	

	public void listTags(String tp)
	{
		for(int i = 0; i < tags.size(); i++)
		{
			if(tags.get(i).type.equals(tp)) System.out.println(tags.get(i));
		}
	}

	public void changeCaption(String newCaption) {
		this.caption = newCaption;
	}

	public void addTag(String type, String value) {
		tags.add(new Tag(type, value)); // Creates a new tag
		
	}

	public void deleteTag(String type, String value) {
		for(Tag t : tags)
		{
			if(t.getType() == type && t.getVal() == value)
			{
				tags.remove(t);
				break;
			}
		}
	}

	public String toString()
	{
		String d = cal.MONTH + "/" + cal.DAY_OF_MONTH + "/" + cal.YEAR + "-" + cal.HOUR_OF_DAY + ":" +  cal.MINUTE + ":" + cal.SECOND;
		return ("Name: " + name + "Caption: " + caption + "Date:" + d);
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}

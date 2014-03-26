package cs213.photoAlbum.model;

/**
 * @author Manan
 *
 */
public class Tag{
	
	protected String type;
	protected String value;
	
	/**
	 * @param t type of tag
	 * @param v value of tag
	 */
	public Tag(String t, String v)
	{
		this.type = t;
		this.value = v;
	}
	
	public String toString()
	{
		return(type + ": " + value);
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getVal()
	{
		return this.value;
	}
}

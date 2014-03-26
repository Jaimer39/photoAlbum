package cs213.photoAlbum.model;

import java.util.ArrayList;
/**
 * @author Pavan Amin
 *
 */

public class User implements UserInterface{

	String UserID = "";
	String name = "";
	ArrayList<Album> albums = new ArrayList<Album>();
	
	public User(String id, String n)
	{
		this.UserID = id;
		this.name = n;
	}
	/**
	 * Gets album of given name
	 */
	public Album getAlbum(String name) {
		if(name == null || name.length() == 0)
		{
			System.out.println("No album name given.");
			return null;
		}
		
		for(Album a : albums)
		{
			if(a.getName() == name)
			{ 
				return a;
			}
		}
		
		return null;
	}
	
	public void addAlbum(String name) {
		if(name == null || name.length() == 0)
		{
			System.out.println("No album name given.");
			return;
		}
		
		for(Album a : albums)
		{
			if(a.getName() == name)
			{ 
				System.out.println("Album with that name already exists.");
				break;
			}
		}
		
		albums.add(new Album(name));
		
	}

	public void deleteAlbum(String albumName) {
		for(Album a : albums)
		{
			if(a.getName() == albumName)
			{
				albums.remove(a); // Removes it
				break;
			}
		}
		
	}

	public void renameAlbum(String oldName, String newName) {
		for(Album a : albums)
		{
			if(a.getName() == oldName)
			{
				a.changeAlbumName(newName); // changes name
				break;
			}
		}
	}

	public void listAlbums() {
		for(Album a : albums)
		{
			System.out.println(a.getName()); // Prints it;
		}		
	}
	
	public String getID()
	{
		return this.UserID;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return("<" + this.UserID + ">");
	}
	
	
	public ArrayList<Album> getAlbums()
	{
		return albums;
	}

}

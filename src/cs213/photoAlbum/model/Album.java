package cs213.photoAlbum.model;

import java.util.ArrayList;
/**
 * @author Pavan Amin
 *
 */

public class Album implements AlbumInterface{

	String albumName = "";
	ArrayList<Photo> photos = new ArrayList<Photo>();
	
	public Album(String name)
	{
		this.albumName = name;
	}
	
	public void addPhoto(String pName, String caption) {
		photos.add(new Photo(pName, caption)); // Adds it
		
	}

	public void addPhoto(Photo p) {
		photos.add(p); // Adds it
		
	}
	
	public void deletePhoto(String name) {
		for(Photo p : photos)
		{
			if(p.name == name)
			{ 
				photos.remove(p);
				break;
			}
		}
	}

	
	public void recaptionPhoto(String name, String newCap) {
		for(Photo p : photos)
		{
			if(p.getName() == name)
			{ 
				p.changeCaption(newCap);
				break;
			}
		}
	}
	
	public Photo getPhoto(String name) {
		if(name == null || name.length() == 0)
		{
			System.out.println("No album name given.");
			return null;
		}
		
		for(Photo p : photos)
		{
			if(p.getName() == name)
			{ 
				return p;
			}
		}
		
		return null;
	}
	
	public void listPhotos()
	{
		int i = 0;
		System.out.print("hi");
		for(Photo p : photos)
		{
			i++;
			System.out.println("Photo #" + i + ": " + p);
		}
	}
	
	public void changeAlbumName(String name)
	{
		this.albumName = name;
	}
	
	public String getName()
	{
		return this.albumName;
	}


	
}

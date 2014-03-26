package cs213.photoAlbum.model;

import java.util.ArrayList;

/**
 * @author Pavan Amin
 *
 */
public interface UserInterface {
	String UserID = "";
	String name = "";
	ArrayList<Album> albums = new ArrayList<Album>();
	
	/**
	 * @param name Name of album to be added
	 */
	void addAlbum(String name);
	
	/**
	 * @param name Name of album to be deleted
	 */
	void deleteAlbum(String name);
	
	/**
	 * @param name Name of album to be renamed
	 */
	void renameAlbum(String oldName, String newName);

    /**
     * Lists all albums of this user
     */
    void listAlbums();
    
    /**
     * @return UserID
     */
    public String getID();
	
	/**
	 * @return name
	 */
	public String getName();
}

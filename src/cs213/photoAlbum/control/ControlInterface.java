package cs213.photoAlbum.control;

import cs213.photoAlbum.model.User;

/**
 * @author Pavan Amin
 *
 */
public interface ControlInterface {
	
	/**
	 * @param id User ID
	 * @param name user name
	 */
	void addUser(String id, String name);
	
	/**
	 * @param id User ID
	 */
	void deleteUser(String id);
	
	/**
	 * @param id User ID
	 */
	User loginUser(String id);
	
	/**
	 * Logout user
	 */
	void logoutUser();
	
	/**
	 * Lists all current users
	 */
	void listExistingUsers();
	
	/**
	 * @param pName Name of Photo
	 * @param currAlbum Name of current album
	 * @param newAlbum Name of album to put photo in
	 */
	void movePhoto(String pName, String currAlbum, String newAlbum);
	
	/**
	 * @param albumName Name of the album
	 * @param picName Name of picture to be found
	 */
	void findPhoto(String albumName, String picName);
	
	/**
	 * @param albumName Name of album to be found
	 */
	void findAlbum(String albumName);
	
	/**
	 * @param tagType Type of tag to be found
	 */
	void findTag(String tagType);
}

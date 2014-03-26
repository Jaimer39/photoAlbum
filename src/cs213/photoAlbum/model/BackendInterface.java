package cs213.photoAlbum.model;

/**
 * @author Pavan Amin
 *
 */
public interface BackendInterface {
	
	
	void addUser(String id);
	
	/**
	 * @param id UserID
	 */
	void readUser(String id);
	
	/**
	 * @param id UserID
	 */
	void writeUser(String id);
	
	/**
	 * @param id UserID
	 */
	void deleteUser(String id);
	
	/**
	 * Lists all Users
	 */
	void listUsers();
}

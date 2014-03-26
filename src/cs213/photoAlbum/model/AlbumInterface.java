package cs213.photoAlbum.model;

import java.util.ArrayList;

/**
 * @author Pavan Amin
 *
 */
public interface AlbumInterface {

	String albumName = "";
	ArrayList<Photo> photos = new ArrayList<Photo>();
	
	/**
	 * @param pName name of Photo to be added
	 * @param caption caption of Photo to be added
	 */
	void addPhoto(String pName, String caption);
	
	/**
	 * @param name Name of photo to be deleted
	 */
	void deletePhoto(String name);

	
	/**
	 * @param name Name of photo
	 * @param oldCap New caption
	 */
	void recaptionPhoto(String name, String newCap);

    /**
     * Lists all photos in album
     */
    void listPhotos();
}


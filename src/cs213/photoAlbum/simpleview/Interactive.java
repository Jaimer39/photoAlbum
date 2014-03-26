package cs213.photoAlbum.simpleview;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import cs213.photoAlbum.control.Control;
import cs213.photoAlbum.model.Album;
import cs213.photoAlbum.model.Photo;
import cs213.photoAlbum.model.User;

/**
 * @author Pavan Amin
 *
 */
public class Interactive {
	private Control control;
	private String userID;
	private Scanner scanner;
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
	User user = control.loginUser(userID);

	public Interactive (String userID){
		this.userID = userID;
		scanner = new Scanner(System.in);
		control = new Control();
		sdf.setLenient(false);
		
		
		interactiveMain();
	}
	
	public void interactiveMain(){
		
		String cmdLine;
		
		cmdLine = scanner.nextLine();
		if(cmdLine.length() == 0){
			System.out.println("Error: no command");
			return;
		}
		
		String[] cmdArray = new String[100];
		StringTokenizer st = new StringTokenizer(cmdLine);
		
		cmdArray[0] = st.nextToken();
		
		if(cmdArray[0] != null){
			if (cmdArray[0].equalsIgnoreCase("createAlbum")){
				
				//remove quotes
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				
				createAlbum(cmdArray[1]);
			}else if (cmdArray[0].equalsIgnoreCase("deleteAlbum")){
				
				//remove quotes
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				deleteAlbum(cmdArray[1]);
			}else if (cmdArray[0].equalsIgnoreCase("listAlbums")){
				listAlbums();
			}else if (cmdArray[0].equalsIgnoreCase("listPhotos")){
				//remove quotes
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				listPhotos(cmdArray[1]);
			}else if (cmdArray[0].equalsIgnoreCase("addPhoto")){
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				 
				cmdArray[2] = st.nextToken("\"");
				cmdArray[2] = st.nextToken("\"");
				 
				cmdArray[3] = st.nextToken("\"");
				cmdArray[3] = st.nextToken("\"");
				
				addPhoto(cmdArray[1], cmdArray[2], cmdArray[3]);
			}else if (cmdArray[0].equalsIgnoreCase("movePhoto")){
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				 
				cmdArray[2] = st.nextToken("\"");
				cmdArray[2] = st.nextToken("\"");
				 
				cmdArray[3] = st.nextToken("\"");
				cmdArray[3] = st.nextToken("\"");
				
				cmdArray[3] = st.nextToken("\"");
				cmdArray[3] = st.nextToken("\"");
				
				boolean isAlbum = false;
				String aName = "";
				
				for(Album a : user.getAlbums())
				{
					if(a.getName() == cmdArray[3])
					{
						isAlbum = true;
						aName = a.getName();
					}
				}
				if(isAlbum == false) return;
				
				user.getAlbum(aName).addPhoto(cmdArray[1], cmdArray[2]);
			}else if (cmdArray[0].equalsIgnoreCase("removePhoto")){
				//remove quotes
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				
				cmdArray[2] = st.nextToken("\"");
				cmdArray[2] = st.nextToken("\"");
				
				removePhoto(cmdArray[1], cmdArray[2]);
			}else if (cmdArray[0].equalsIgnoreCase("addTag")){
				//remove quotes
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				
				cmdArray[2] = st.nextToken(":");
				cmdArray[2] = cmdArray[2].replace("\"", " ");
				cmdArray[2] = cmdArray[2].trim();
				
				cmdArray[2] = st.nextToken(":");
				cmdArray[2] = cmdArray[2].replace("\"", " ");
				cmdArray[2] = cmdArray[2].trim();
				
				addTag(cmdArray[1], cmdArray[2], cmdArray[3]);
			}else if (cmdArray[0].equalsIgnoreCase("deleteTag")){
				//remove quotes
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				
				cmdArray[2] = st.nextToken(":");
				cmdArray[2] = cmdArray[2].replace("\"", " ");
				cmdArray[2] = cmdArray[2].trim();
				
				cmdArray[2] = st.nextToken(":");
				cmdArray[2] = cmdArray[2].replace("\"", " ");
				cmdArray[2] = cmdArray[2].trim();
				
				deleteTag(cmdArray[1], cmdArray[2], cmdArray[3]);
			}else if (cmdArray[0].equalsIgnoreCase("listPhotoInfo")){
				//remove quotes
				cmdArray[1] = st.nextToken("\"");
				cmdArray[1] = st.nextToken("\"");
				
				listPhotoInfo(cmdArray[1]);
			}else if (cmdArray[0].equalsIgnoreCase("getPhotosByDate")){
				//remove quotes
				cmdArray[1] = st.nextToken();
				cmdArray[2] = st.nextToken();
				
				getPhotosByDate(cmdArray[1], cmdArray[2]);
			}else if (cmdArray[0].equalsIgnoreCase("getPhotosByTag")){
				//remove quotes
				ArrayList<String> tagTemp = new ArrayList<String>();
				ArrayList<String> tagValue = new ArrayList<String>();
				while(st.hasMoreTokens()){
					tagTemp.add(st.nextToken(","));
					
				}
				for (int i = 0; i < tagTemp.size(); i++) {
					if (tagTemp.get(i).contains(":")) {
						String temp = tagTemp.get(i).substring(tagTemp.get(i).indexOf(":") + 2, tagTemp.get(i).length() - 1);
						tagValue.add(temp);
					}
					else {

						String temp = tagTemp.get(i).trim().substring(1, tagTemp.get(i).trim().length() - 1);
						tagValue.add(temp);
					}
				}
				
				getPhotosByTag(tagValue);
			}else if (cmdArray[0].equalsIgnoreCase("logout")){
				logout();
			}
		}
	}
	
	/**
	 * @param name 
	 * Asks for name of album 
	 * Prints "created album for user <userID>: <name>"
	 * Or prints "album exists for user <userID>: <name>"
	 */
	private void createAlbum(String name){
		user.addAlbum(name);
		
	}

	/**
	 * @param name
	 * Asks for name of album 
	 * Prints "deleted album from user <userID>: <name>" 
	 * Or prints "album does not exist for user <userID>: <name>"
	 */
	private void deleteAlbum(String name){
		user.deleteAlbum(name);
	}

	/**
	 * Prints "Albums for user <userID>:
	 * 		   <name> number of photos: <numberOfPhotos>, <startDate> - <endDate>
	 * 		   ..."
	 * Or Prints "No albums exist for user <userID>"
	 */
	private void listAlbums(){
		user.listAlbums();
	}
	
	/**
	 * @param name
	 * Asks for name of album
	 * Prints "Photos for album <name>:
	 * 		   <filename> - <date>
	 * 		   ..."
	 */
	private void listPhotos(String name){
		user.getAlbum(name).listPhotos();
	}
	
	/**
	 * @param fileName
	 * Asks for photo name
	 * @param caption
	 * Asks for caption for photo
	 * Empty String if caption is retained from a previous add
	 * @param albumName
	 * Asks for name of album
	 * Prints "Added photo <fileName>:
	 * 		   <caption> - Album: <albumName>"
	 * Or prints "Photo <fileName> already exists in album <albumName>"
	 * Or prints "File <fileName> does not exist
	 */
	private void addPhoto(String fileName, String caption, String albumName){
		
		user.getAlbum(albumName).addPhoto(fileName, caption);
		
		
	}
	
	/**
	 * @param fileName
	 * Asks for photo name
	 * @param oldAlbumName
	 * Asks for name of old album
	 * @param newAlbumName
	 * Asks for name of new album
	 * Prints "Moved photo <fileName>:
	 * 	 	   <fileName> - From album <oldAlbumName> to album <newAlbumName>"
	 * Or prints "Photo <fileName> does not exist in <oldAlbumName>"
	 */
	private void MovePhoto(User user, String fileName, String oldAlbumName, String newAlbumName){
		user.getAlbum(newAlbumName).addPhoto(user.getAlbum(oldAlbumName).getPhoto(fileName));
		user.getAlbum(oldAlbumName).deletePhoto(fileName);
	}
	
	/**
	 * @param fileName
	 * Asks for photo name
	 * @param AlbumName
	 * asks for name of Album
	 * Prints "Removed photo:
	 * 		   <fileName> - From album <albumName>"
	 * Or prints "Photo <fileName> is not in album <albumName>"
	 */
	void removePhoto(String fileName, String albumName){
		user.getAlbum(albumName).deletePhoto(fileName);
	}
	
	/**
	 * @param fileName
	 * Asks for photo name
	 * @param tagType
	 * Asks for tag type
	 * @param tagValue
	 * Asks for tag value
	 * Prints "Added tag:
	 * 		   <fileName> <tagType>:<tagValue>"
	 * Or prints "Tag already exists for <fileName> <tagType>:<tagValue>"
	 */
	public void addTag(String fileName, String tagType, String tagValue){
		for(Album a : user.getAlbums())
		{
			if(a.getPhoto(fileName) != null)
			{
				a.getPhoto(fileName).addTag(tagType, tagValue);
			}
		}
		
	}
	
	/**
	 * @param fileName
	 * Asks for photo Name
	 * @param tagType
	 * Asks for tag type
	 * @param tagValue
	 * Asks for tag Value
	 * Prints "Deleted tag:
	 * 		   <fileName <tagType>:<tagValue>"
	 * Or prints "Tag does not exist for <fileName> <tagType>:<tagValue>"
	 */
	public void deleteTag(String fileName, String tagType, String tagValue){
		
		
	}
	
	/**
	 * @param fileName
	 * Asks for photo Name
	 * Prints "Photo file name: <fileName>
	 * 		   Album: <ablumName>[,<albumName>]...
	 *         Date: <date>
	 *         Caption: <caption>
	 *         Tags:
	 *         <tagType>:<tagValue>
	 *         ..."
	 * Or prints "Photo <fileName> does not exist"
	 */
	public void listPhotoInfo(String fileName)
	{
		
	}
	
	/**
	 * @param startDate
	 * Start date inputed as String
	 * @param endDate
	 * End date inputed as String
	 * Prints "Photos for user <userID> in range <startDate> to <endDate>: 
	 * 		   <caption> - Album: <albumName>[,<albumName>]... - Date: <date> 
	 *         ..."
	 */
	public void getPhotosByDate(String startDate, String endDate)
	{
		
	}
	
	/**
	 * @param tag
	 * <tagType> and tagValue>
	 * Prints "Photos for user <userID> with tags <tag>: 
	 * 		   <caption> - Album: <albumName>[,<albumName>]... - Date: <date>
	 * 		   ..."
	 */
	private void getPhotosByTag ( ArrayList<String> tagValue){
		
	}
	
	/**
	 * Ends interactive mode
	 */
	public void logout(){
		control.logoutUser();
	}
}

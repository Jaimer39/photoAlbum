package cs213.photoAlbum.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import cs213.photoAlbum.model.User;
import cs213.photoAlbum.simpleview.Interactive;
/**
 * @author Pavan Amin
 *
 */

public class Control implements ControlInterface{

	private ArrayList<User> users = new ArrayList<User>(); // List of Users
	private PrintWriter writer;
	private Scanner scanner;
	private File file = new File("C:/Users/Manan/workspace/PhotoAlbum40/src/cs213/photoAlbum/control/save.txt");

	//throws FileNotFoundException, UnsupportedEncodingException
	public Control() 
	{
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String line = "";
		while(scanner.hasNext()){
			line = scanner.nextLine();
			if(line == null || line.length() == 0) break;
			String id = "", uname = "";
			int i;
		
			for(i = 0; line.charAt(i) != '|'; i++)
			{
				id += line.charAt(i);
				//System.out.println("FLAG: " + i + " " + id);
			}
			
			for(int j = i; j < line.length(); j++)
			{
				uname += line.charAt(j);
			}
			users.add(new User(id, uname));
		}
		
		scanner.close();
		
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e)
		  {
			e.printStackTrace();
		  }
	}
	
	
	/**
	 * Adds User
	 */
	public void addUser(String id, String name) {
		if(id == null || id.length() == 0) // If no ID
		  {
			  System.out.println("No UserID given.");
		      return;
		  }
		
		if(name == null || name.length() == 0)
		  {
			  System.out.println("No Username given."); // If no name
			  return;
	  	  }
		boolean exists = false;
		for(User u : users)
		{
			//System.out.println(u.getID().equals(id));
			//System.out.println(u.getName().equals(name));
			//System.out.println(u.getName() + name);
			if(u.getID().equals(id)/* && u.getName().equals(name)*/)
			{
				System.out.println("user <" + id + "> already exists with name <" + name + ">"); // Already exists
				exists = true;
				return;
			}
		}
		
		for(User u : users)
		{
			writer.println(u.getID() + "|" + u.getName());
		}
		if(exists == true) return;
		users.add(new User(id, name));
		System.out.println("created user <" + id + "> with name <" + name + ">");
		writer.println(id + "|" + name);
		writer.close();
		return;
		
		
	}
	
	/**
	 * Deletes User
	 */
	public void deleteUser(String id) throws NullPointerException {
		if(id == null || id.length() == 0) // If no ID
		{
			System.out.println("No UserID given.");
		    return;
		  }
		
		if(users.size() == 0) // If no users in list
		{
			System.out.println("There are no existing users.");
		}
		
		for(User u : users)
		{
			if(u.getID().equals(id))
		    {
				users.remove(u); // Delete it
				System.out.println("deleted user <" + id + "> ");
				return;
			}
		}
		
		System.out.println("user <" + id + "> does not exist");
	}
	
	/**
	 * Logs in User
	 */
	public User loginUser(String id) {
		if(id == null || id.length() == 0) // If no ID
		{
			System.out.println("ERROR: No UserID given.");
		  }
		
		if(users.size() == 0) // If no users in list
		{
			System.out.println("ERROR: There are no existing users.");
		}
		
		for(User u : users)
		{
			if(u.getID().equals(id))
			{
				Interactive intr = new Interactive(u.getID());
				intr.interactiveMain();
			}
		}
		
		return null;
		
	}

	@Override
	public void logoutUser() {
		// TODO Auto-generated method stub
		
	}

	
	public void listExistingUsers() throws NullPointerException {
		if(users.size() == 0) // If no users in list
		{
			System.out.println("There are no existing users.");
			return;
		}
		
		for(User u : users)
		{
			System.out.println(u); // Delete it
		}
		
	}

	@Override
	public void movePhoto(String pName, String currAlbum, String newAlbum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findPhoto(String albumName, String picName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAlbum(String albumName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findTag(String tagType) {
		// TODO Auto-generated method stub
		
	}

}

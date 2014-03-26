package cs213.photoAlbum.simpleview;
import java.io.*;
import java.util.*;

import cs213.photoAlbum.control.Control;
import cs213.photoAlbum.model.User;
/**
 * @author Pavan Amin
 *
 */
public class CmdView {


	static Control control = new Control();
	static User user;
	
	/**
	 * Lists all users
	 */

	public static void listUsers() {		
		control.listExistingUsers();	
	}
	

	/**
	 * @param userID, userName
	 * @param userName
	 */
	public static void addUser(String userID, String userName){
		control.addUser(userID, userName);
	}
		
		
	
	/**
	 * @param userID
	 */
	public static void deleteUser(String userID){
		control.deleteUser(userID);
	}

	/**
	 * @param userID
	 */
	public static void login(String userID){
		user = control.loginUser(userID);	
	}
	
	public static void main(String[] args){
		if(args.length == 1){
			String temp = args[0];
			if(temp.equalsIgnoreCase("listusers")){
				CmdView.listUsers();
			}else{
				System.err.println("not a correct input");
			}
		}else if (args.length == 2){
			String temp = args[0];
			if(temp.equalsIgnoreCase("deleteUser")){
				String userID = args[1];
				CmdView.deleteUser(userID);
			}else if(temp.equalsIgnoreCase("login")){
				String userID = args[1];
				CmdView.login(userID);
			}else{
				System.err.println("not a correct input");
			}
		}
		else if(args.length == 3){
			String temp = args[0];
			if(temp.equalsIgnoreCase("addUser")){
				String userID = args[1];
				String userName = args[2];
				CmdView.addUser(userID, userName);
			}else{
				System.err.println("not a correct input");
			}
		}
		else{
			System.err.println("not a correct input");
		}
	}
}

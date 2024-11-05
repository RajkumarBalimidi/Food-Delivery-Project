package com.tap.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.tap.foodapp.dao.UserDAO;
import com.tap.foodapp.impl.UserDAOImpl;
import com.tap.foodapp.model.User;

public class UserMain {

	public static void main(String[] args) {
		UserDAO udao = new UserDAOImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a operation to perform : \n\n 1.Display All Users.\n 2.Display Specific User By Id.\n 3.Insert a User.\n 4.Update User Address By Id.\n 5.Delete User By ID");
		int choose = scan.nextInt();
		int status = -1;
		switch(choose) {
		
		
		case 1: ArrayList<User> users = (ArrayList<User>) udao.getAllUsers();
				for(User u1 : users){
					System.out.println(u1);
				}
				break;
				
		case 2 : scan.nextLine();
				 System.out.println("Enter User Email ID : ");
		 		 String uemail = scan.nextLine();
				 User user = udao.getUserByEmail(uemail);
			     System.out.println(user);
			     break;
			     
		case 3 : scan.nextLine();
				 System.out.println("Enter the User Details => (User Name,Email,Password,Phone Number,Address,Role");
				 String input = scan.nextLine();
				 String [] arr = input.split(",");
				 User u3 = new User(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
				 status = udao.insertUser(u3);
				 System.out.println(status+" row inserted.");
				 break;
				 
				 
		case 4 : scan.nextLine();
				 System.out.println("Enter User ID : ");
				 String uemail3 = scan.nextLine();
				 System.out.println("Enter the new Address");
				 String addr = scan.nextLine();
				 status = udao.updateUserByEmail(uemail3,addr);
				 System.out.println(status+" row address updated.");
				 break;
				 
		case 5 : System.out.println("Enter user ID : ");
				 String uemail2 = scan.nextLine();
				 status = udao.deleteUserByEmail(uemail2);
				 System.out.println(status+" row deleted.");
				 break;
				 
		default : System.out.println("Enter valid choice.");
		}
	
		scan.close();
	}

}

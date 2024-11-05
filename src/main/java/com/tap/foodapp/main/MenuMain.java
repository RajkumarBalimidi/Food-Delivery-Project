package com.tap.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.tap.foodapp.dao.MenuDAO;
import com.tap.foodapp.impl.MenuDAOImpl;
import com.tap.foodapp.model.Menu;

public class MenuMain {
	

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MenuDAO mdao = new MenuDAOImpl();
		int status = -1;
		System.out.println("Choose a operation to perform : \n\n 1.Display All Menus.\n 2.Display Specific Menu By Id.\n 3.Insert a Menu.\n 4.Update Menu Address By Id.\n 5.Delete Menu By ID");
		int choose = scan.nextInt();
		switch(choose) {
		
		
		case 1: ArrayList<Menu> menu = (ArrayList<Menu>) mdao.getAllMenus();
				for(Menu m : menu)
				{
					System.out.println(m);
				}
				break;
				
		case 2 : System.out.println("Enter Menu ID : ");
		 		 int mid = scan.nextInt();
		 		 Menu m = mdao.getMenuById(mid);
				 System.out.println(m);
			     break;
			     
		case 3 : scan.nextLine();
				 System.out.println("Enter the Menu Details => (Restaurant ID, Menu Name, Price, Description, isAvailabel) : ");
				 String input = scan.nextLine();
				 String [] arr = input.split(",");
				 Menu m1 = new Menu(Integer.parseInt(arr[0]), arr[1], Float.parseFloat(arr[2]), arr[3] ,Boolean.parseBoolean(arr[4]));
				 status = mdao.insertMenu(m1);
				 System.out.println(status+" row inserted.");
				 break;
				 
		case 4 : System.out.println("Enter Menu ID : ");
				 int mid1 = scan.nextInt();
				 scan.nextLine();
				 System.out.println("Enter the new Price");
				 Float newPrice = scan.nextFloat();
	//			 status = mdao.updateMenuById(mid1, newPrice);
				 System.out.println(status+" row price updated.");
				 break;
				 
		case 5 : System.out.println("Enter user ID : ");
				 int rid2 = scan.nextInt();
				 status = mdao.deleteMenuById(rid2);
				 System.out.println(status+" row deleted.");
				 break;
				 
		default : System.out.println("Enter valid choice.");
		}
	
		scan.close();
	
		
		
	}

}

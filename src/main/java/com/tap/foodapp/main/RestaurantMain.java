package com.tap.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.model.Restaurant;

public class RestaurantMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int status = -1;
		RestaurantDAO rdao = new RestaurantDAOImpl();
		
		System.out.println("Choose a operation to perform : \n\n 1.Display All Restaurants.\n 2.Display Specific Restaurant By Id.\n 3.Insert a Restaurant.\n 4.Update Restaurant Address By Id.\n 5.Delete Restaurant By ID");
		int choose = scan.nextInt();
		switch(choose) {
		
		
		case 1: ArrayList<Restaurant> rest = (ArrayList<Restaurant>) rdao.getAllRestaurants();
				for(Restaurant rs : rest)
				{
					System.out.println(rs);
				}
				break;
				
		case 2 : System.out.println("Enter Restaurant ID : ");
		 		 int rid = scan.nextInt();
		 		 Restaurant restaurant = rdao.getRestaurantById(rid);
				 System.out.println(restaurant);
			     break;
			     
		case 3 : scan.nextLine();
				 System.out.println("Enter the Restaurant Details => (Restaurant Name, Address, Rating, isActive");
				 String input = scan.nextLine();
				 String [] arr = input.split(",");
			//	 Restaurant r = new Restaurant(arr[0],arr[1],Float.parseFloat(arr[2]),Boolean.parseBoolean(arr[3]));
			//	 status = rdao.insertRestaurant(r);
				 System.out.println(status+" row inserted.");
				 break;
				 
		case 4 : System.out.println("Enter Restaurant ID : ");
				 int rid1 = scan.nextInt();
				 scan.nextLine();
				 System.out.println("Enter the new isActive");
				 boolean isActive = scan.nextBoolean();
				 status = rdao.updateRestaurantById(rid1,isActive);
				 System.out.println(status+" row isActive updated.");
				 break;
				 
		case 5 : System.out.println("Enter user ID : ");
				 int rid2 = scan.nextInt();
//				 status = rdao.deleteRestaurantById(rid2);
				 System.out.println(status+" row deleted.");
				 break;
				 
		default : System.out.println("Enter valid choice.");
		}
	
		scan.close();
		
		
//		Restaurant r = new Restaurant("Spicy","Bengalore, Marathahalli",4.0f,false,1,"C:\\Users\\raj kumar\\restaurant1.jpg");
//		
//		RestaurantDAO rdao = new RestaurantDAOImpl();
//		int status = rdao.insertRestaurant(r);
//		System.out.println(status);
		
//		RestaurantDAO rdao = new RestaurantDAOImpl();
//		ArrayList<Restaurant> rest = (ArrayList<Restaurant>) rdao.getAllRestaurants();
//		for(Restaurant rs : rest)
//		{
//			System.out.println(rs);
//		}
		
//		RestaurantDAO rdao = new RestaurantDAOImpl();
//		Restaurant restaurant = rdao.getRestaurantById(1);
//		System.out.println(restaurant);
		
		
//		RestaurantDAO rdao = new RestaurantDAOImpl();
//		int status = rdao.deleteRestaurantById(2);
//		System.out.println(status);
//		
//		RestaurantDAO rdao = new RestaurantDAOImpl();
//		int status = rdao.updateRestaurantById(1, 4.0f);
//		System.out.println(status);
//		
		
	}

}

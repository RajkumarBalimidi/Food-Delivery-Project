package com.tap.foodapp.main;

import java.util.List;
import java.util.Scanner;

import com.tap.foodapp.dao.OrderDAO;
import com.tap.foodapp.impl.OrderDAOImpl;
import com.tap.foodapp.model.Order;

public class OrderMain {

	public static void main(String[] args) {

	        Scanner scan = new Scanner(System.in);
	        OrderDAO odao = new OrderDAOImpl();
	        int status = -1;
	        System.out.println("Choose an operation to perform \n\n 1. Display All Orders \n 2. Insert Order.\n 3. Update Order Status By Order ID.\n 4. Fetch Orders By User ID.\n 5. Delete Order By ID");
	        int choice = scan.nextInt();
	        scan.nextLine();

	        switch(choice) {
	            case 1:
	                List<Order> order = odao.getAllOrders();
	                for(Order o : order) {
	                	System.out.println(o);	                	
	                }
	                break;

	            case 2:
	                System.out.println("Enter order details => (userId, restaurantId, totalAmount, status, paymentOption) : ");
	                String orderDetails = scan.nextLine();
	                String[] oarr = orderDetails.split(",");
	                status = odao.insertOrder(new Order(Integer.parseInt(oarr[0]), Integer.parseInt(oarr[1]), Float.parseFloat(oarr[2]),Boolean.parseBoolean(oarr[3]), oarr[4]));
	                System.out.println(status + " row inserted");
	                break;

	            case 3:
	                System.out.println("Enter order status: ");
	                String orderStatus = scan.nextLine();
	                System.out.println("Enter order id: ");
	                int orderId = scan.nextInt();
	                status = odao.updateOrderStatusById(orderId, orderStatus);
	                System.out.println(status + " row updated");
	                break;

	            case 4:
	                System.out.print("Enter user id: ");
	                int userId = scan.nextInt();
	                List<Order> ordersByUser = odao.getOrderByUserId(userId);
	                System.out.println(ordersByUser);
	                break;
	                
	            case 5:
	            	System.out.println("Enter Order id : ");
	            	int orderId1 = scan.nextInt();
	            	status = odao.deleteOrderById(orderId1);
	            	System.out.println(status+" row deleted.");
	            	break;
	            	
	            default:
	                System.out.println("Enter a valid choice");
	        }

	        scan.close();
		
	}

}

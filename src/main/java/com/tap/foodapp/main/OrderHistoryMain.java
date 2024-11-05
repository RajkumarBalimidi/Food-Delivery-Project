package com.tap.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.tap.foodapp.dao.OrderHistoryDAO;
import com.tap.foodapp.impl.OrderHistoryDAOImpl;
import com.tap.foodapp.model.OrderHistory;
//import com.tap.Model.OrderHistory;

public class OrderHistoryMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        OrderHistoryDAO odao = new  OrderHistoryDAOImpl();

        int status = -1;
        System.out.println("Choose an operation to perform \n\n 1. Display Order History By ID.\n 2. Insert Order History.\n 3. Update Order History Status By ID.\n 4. Fetch Order History By User ID");
        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter order history id: ");
                int ohid = scan.nextInt();
                OrderHistory orderHistory = odao.fetchOrderHistoryById(ohid);
                System.out.println(orderHistory);
                break;

            case 2:
                System.out.println("Enter order history details => orderHistoryId, userId, orderId, date (YYYY-MM-DD), totalAmount, status");
                String orderHistoryDetails = scan.nextLine();
                String[] oharr = orderHistoryDetails.split(",");
                status = odao.insertOrderHistory(new OrderHistory(
                        Integer.parseInt(oharr[0]),
                        Integer.parseInt(oharr[1]),
                        Integer.parseInt(oharr[2]),
                        Float.parseFloat(oharr[3]),
                        oharr[4]
                        ));
                System.out.println(status + " row inserted");
                break;

            case 3:
                System.out.println("Enter order history status: ");
                String historyStatus = scan.nextLine();
                System.out.println("Enter order history id: ");
                int orderHistoryId = scan.nextInt();
                status = odao.updateOrderHistoryStatusById(orderHistoryId, historyStatus);
                System.out.println(status + " row updated");
                break;

            case 4:
                System.out.print("Enter user id: ");
                int userId = scan.nextInt();
                ArrayList<OrderHistory> historyByUser = (ArrayList<OrderHistory>) odao.fetchOrderHistoryByUserId(userId);
                for (OrderHistory oh : historyByUser) {
                    System.out.println(oh);
                }
                break;

            default:
                System.out.println("Enter a valid choice");
        }

        scan.close();
    }
}





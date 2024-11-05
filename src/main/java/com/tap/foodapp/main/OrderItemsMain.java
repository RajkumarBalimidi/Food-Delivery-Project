package com.tap.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.tap.foodapp.dao.OrderItemsDAO;
import com.tap.foodapp.impl.OrderItemsDAOImpl;
import com.tap.foodapp.model.OrderItems;

public class OrderItemsMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        OrderItemsDAO orderItemDao = new OrderItemsDAOImpl();

        int status = -1;
        System.out.println("Choose an operation to perform \n\n 1. Display Order Items By Order ID.\n 2. Insert Order Item.\n 3. Update Order Item By OrderItem ID.\n 4. Delete Order Item By OrderItem ID.\n 5. Fetch Order Item By OrderItem ID");
        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                // Fetching order items by order id
                System.out.print("Enter order id: ");
                int orderId = scan.nextInt();
                ArrayList<OrderItems> orderItems = (ArrayList<OrderItems>) orderItemDao.fetchOrderItemsByOrderId(orderId);
                for (OrderItems item : orderItems) {
                    System.out.println(item);
                }
                break;

            case 2:
                // Inserting an order item
                System.out.println("Enter order item details => orderitem_id, order_id, menuId, quantity, subtotalPrice");
                String orderItemDetails = scan.nextLine();
                String[] oarr = orderItemDetails.split(",");
                status = orderItemDao.insertOrderItem(new OrderItems(
                        Integer.parseInt(oarr[0]),
                        Integer.parseInt(oarr[1]),
                        Integer.parseInt(oarr[2]),
                        Integer.parseInt(oarr[3]),
                        Float.parseFloat(oarr[4])));
                System.out.println(status + " row inserted");
                break;

            case 3:
                // Updating an order item
                System.out.println("Enter updated quantity: ");
                int quantity = scan.nextInt();
                System.out.println("Enter updated subtotal price: ");
                double subtotalPrice = scan.nextDouble();
                System.out.println("Enter order item id: ");
                int orderItemId = scan.nextInt();
                status = orderItemDao.updateOrderItemById(orderItemId, quantity, subtotalPrice);
                System.out.println(status + " row updated");
                break;

            case 4:
                // Deleting an order item
                System.out.println("Enter order item id to delete: ");
                orderItemId = scan.nextInt();
                status = orderItemDao.deleteOrderItemById(orderItemId);
                System.out.println(status + " row deleted");
                break;

            case 5:
                // Fetching a single order item by orderitem_id
                System.out.println("Enter order item id: ");
                orderItemId = scan.nextInt();
                OrderItems orderItem = orderItemDao.fetchOrderItemById(orderItemId);
                System.out.println(orderItem);
                break;

            default:
                System.out.println("Enter a valid choice");
        }

        scan.close();
    }
}

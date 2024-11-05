package com.tap.foodapp.impl;

import java.util.ArrayList;
import java.util.List;

import com.tap.foodapp.dao.OrderItemsDAO;
import com.tap.foodapp.model.OrderItems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemsDAOImpl implements OrderItemsDAO {

	OrderItems orderItems;
    private static Connection con;
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private ArrayList<OrderItems> orderItemsList = new ArrayList<>();
    private int x;

    private static final String GET_ORDER_ITEMS_BY_ORDER_ID = "SELECT * FROM `orderitems` WHERE `order_id` = ?";
    private static final String GET_ORDER_ITEMS_BY_Email_ID = "SELECT * FROM `orderitems` WHERE `userEmail` = ?";
    
    private static final String INSERT_ORDER_ITEM = "INSERT INTO `orderitems` (`userEmail`, `userAddress`,`menu_id`,`menuName`,`restaurant_id`,`restaurantName`,`quantity`, `subtotalPrice`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ORDER_ITEM_BY_ID = "UPDATE `orderitems` SET `quantity` = ?, `subtotalPrice` = ? WHERE `orderitem_id` = ?";
    private static final String UPDATE_ADDRESS_BY_ORDER_ITEM_ID = "UPDATE `orderitems` SET `userAddress` = ? WHERE `orderitem_id` = ? ";
    private static final String DELETE_ORDER_ITEM_BY_ID = "DELETE FROM `orderitems` WHERE `orderitem_id` = ?";
    private static final String FETCH_ORDER_ITEM_BY_ID = "SELECT * FROM `orderitems` WHERE `orderitem_id` = ?";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_project", "root", "MySQL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItems> fetchOrderItemsByOrderId(int orderItemId) {
        try {
            pstmt = con.prepareStatement(GET_ORDER_ITEMS_BY_ORDER_ID);
            pstmt.setInt(1, orderItemId);
            resultSet = pstmt.executeQuery();

            orderItemsList = (ArrayList<OrderItems>) extractOrderItemListFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItemsList;
    }

    @Override
    public int insertOrderItem(OrderItems orderItem) {
        try {
            pstmt = con.prepareStatement(INSERT_ORDER_ITEM);
            pstmt.setString(1, orderItem.getUserEmail());
            pstmt.setString(2, orderItem.getUserAddress());
            pstmt.setInt(3, orderItem.getMenuId());
            pstmt.setString(4, orderItem.getMenuName());
            pstmt.setInt(5, orderItem.getRestaurantId());
            pstmt.setString(6, orderItem.getRestaurantName());
            pstmt.setDouble(7, orderItem.getQuantity());
            pstmt.setDouble(8, orderItem.getSubtotalPrice());

            x = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public int updateOrderItemById(int orderItemId, int quantity, double subtotalPrice) {
        try {
            pstmt = con.prepareStatement(UPDATE_ORDER_ITEM_BY_ID);
            pstmt.setInt(1, quantity);
            pstmt.setDouble(2, subtotalPrice);
            pstmt.setInt(3, orderItemId);

            x = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public int deleteOrderItemById(int orderItemId) {
        try {
            pstmt = con.prepareStatement(DELETE_ORDER_ITEM_BY_ID);
            pstmt.setInt(1, orderItemId);

            x = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public OrderItems fetchOrderItemById(int orderItemId) {
        try {
            pstmt = con.prepareStatement(FETCH_ORDER_ITEM_BY_ID);
            pstmt.setInt(1, orderItemId);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                orderItems = new OrderItems(
                        resultSet.getInt("orderitem_id"),
                        resultSet.getString("userEmail"),
                        resultSet.getString("userAddress"),
                        resultSet.getInt("menu_id"),
                        resultSet.getString("menuName"),
                        resultSet.getInt("restaurant_id"),
                        resultSet.getString("restaurantName"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("subtotalPrice")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    private List<OrderItems> extractOrderItemListFromResultSet(ResultSet resultSet) {
        List<OrderItems> orderItemsList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                orderItemsList.add(new OrderItems(
                		 resultSet.getInt("orderitem_id"),
                         resultSet.getString("userEmail"),
                         resultSet.getString("userAddress"),
                         resultSet.getInt("menu_id"),
                         resultSet.getString("menuName"),
                         resultSet.getInt("restaurant_id"),
                         resultSet.getString("restaurantName"),
                         resultSet.getInt("quantity"),
                         resultSet.getFloat("subtotalPrice")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemsList;
    }

	@Override
	public List<OrderItems> fetchOrderItemsByEmail(String userEmail) {
		try {
            pstmt = con.prepareStatement(GET_ORDER_ITEMS_BY_Email_ID);
            pstmt.setString(1, userEmail);
            resultSet = pstmt.executeQuery();

            orderItemsList = (ArrayList<OrderItems>) extractOrderItemListFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItemsList;
	}

	@Override
	public int updateAddressByOrderItemId(int orderitemid, String Address) {

		 try {
	            pstmt = con.prepareStatement(UPDATE_ADDRESS_BY_ORDER_ITEM_ID);
	            pstmt.setString(1, Address);
	            pstmt.setInt(2, orderitemid);

	            x = pstmt.executeUpdate();

	        }
		 catch (SQLException e) 
		 {
	            e.printStackTrace();
	     }
	        return x;
	}
	
}


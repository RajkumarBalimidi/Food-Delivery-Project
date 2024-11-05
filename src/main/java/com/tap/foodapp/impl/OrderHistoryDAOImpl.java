package com.tap.foodapp.impl;

import java.util.ArrayList;
import java.util.List;

import com.tap.foodapp.dao.OrderHistoryDAO;
import com.tap.foodapp.model.OrderHistory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

    private static Connection con;
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private static OrderHistory orderHistory;
    private ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
    private int x = -1;

    private static final String ORDER_HISTORY_BY_ID = "SELECT * FROM `orderhistory` WHERE `orderHistory_id` = ?";
    private static final String INSERT_ORDER_HISTORY = "INSERT INTO `orderhistory` (`orders_id`, `userEmail`, `restaurantName`, `menuId`, `menuName`,`quantity`, `totalAmount`, `paymentType`, `orderedAddress`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ORDER_HISTORY_STATUS = "UPDATE `orderhistory` SET `order_status` = ? WHERE `orderhistory_id` = ?";
    private static final String GET_ORDER_HISTORY_BY_USER_EMAIL = "SELECT * FROM `orderhistory` WHERE `userEmail` = ?";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_project", "root", "MySQL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderHistory fetchOrderHistoryById(int id) {
        try {
            pstmt = con.prepareStatement(ORDER_HISTORY_BY_ID);
            pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();

            orderHistoryList = (ArrayList<OrderHistory>) extractOrderHistoryListFromResultSet(resultSet);
            orderHistory = orderHistoryList.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public int insertOrderHistory(OrderHistory orderHistory) {
        try {
            pstmt = con.prepareStatement(INSERT_ORDER_HISTORY);
            pstmt.setInt(1, orderHistory.getOrderId());
            pstmt.setString(2, orderHistory.getUserEmail());
            pstmt.setString(3, orderHistory.getRestaurantName());
            pstmt.setInt(4, orderHistory.getMenuId());
            pstmt.setString(5, orderHistory.getMenuName());
            pstmt.setInt(6, orderHistory.getQuantity());
            pstmt.setFloat(7, orderHistory.getTotalAmount());
            pstmt.setString(8, orderHistory.getPaymentType());
            pstmt.setString(9, orderHistory.getOrderedAddress());
  //          pstmt.setString(4, orderHistory.getOrderStatus());
 //           pstmt.setString(6, orderHistory.getDate()); 

            x = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public int updateOrderHistoryStatusById(int id, String status) {
        try {
            pstmt = con.prepareStatement(UPDATE_ORDER_HISTORY_STATUS);
            pstmt.setString(1, status);
            pstmt.setInt(2, id);

            x = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public List<OrderHistory> fetchOrderHistoryByUserId(String uid) {
        try {
            pstmt = con.prepareStatement(GET_ORDER_HISTORY_BY_USER_EMAIL);
            pstmt.setString(1, uid);
            resultSet = pstmt.executeQuery();

            orderHistoryList = (ArrayList<OrderHistory>) extractOrderHistoryListFromResultSet(resultSet);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    private List<OrderHistory> extractOrderHistoryListFromResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                orderHistoryList.add(new OrderHistory(
                        resultSet.getInt("orderHistory_id"),
                        resultSet.getInt("orders_id"),
                        resultSet.getString("userEmail"),
                        resultSet.getString("restaurantName"),
                        resultSet.getInt("menuId"),
                        resultSet.getString("menuName"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("totalAmount"),
                        resultSet.getString("paymentType"),
                        resultSet.getNString("orderedAddress"),
                        resultSet.getString("order_Status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }
}

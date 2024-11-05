package com.tap.foodapp.impl;

import java.util.ArrayList;
import java.util.List;

import com.tap.foodapp.dao.OrderDAO;
import com.tap.foodapp.model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDAOImpl implements OrderDAO {
	
	Order order; 
	
    private static Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
	private ResultSet resultSet;
	private int res;
	
	private ArrayList<Order> orderList = new ArrayList<Order>();
    private static final String GET_ALL_ORDERS = "select * from `order`";
    private static final String INSERT_ORDERS = "insert into `order`(`userEmail`,`orderitem_id`,`totalAmount`, `paymentoption`, `status`) values(?,?,?,?,?)";
    private static final String UPDATE_ORDER_STATUS_BY_ID = "update `order` set `status` = ? where `orderid` = ?";
    private static final String GET_ORDERS_BY_UID = "select * from `order` where `userEmail`=?";
    private static final String GET_ORDERS_BY_ORDER_ID = "select * from `order` where `orderid`=?";
    private static final String DELETE_BY_OID = "delete from `order` where `orderid`=?";
    static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_project","root","MySQL");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

    @Override
    public Order getOrderByUserEmail(String userEmail) {

        try  {
        	pstmt = con.prepareStatement(GET_ORDERS_BY_UID);
            pstmt.setString(1, userEmail);
            resultSet = pstmt.executeQuery();
           
        	while(resultSet.next())
        	{
        		order = new Order(
        				resultSet.getInt("orderid"),
        				resultSet.getInt("orderitem_id"),
        				resultSet.getString("userEmail"),
        				resultSet.getDouble("totalAmount"),
        				resultSet.getString("paymentoption"),
        				resultSet.getString("status")
        				
        				);
        	}            	
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    
	@Override
    public int insertOrder(Order order) {

        try {
        	pstmt = con.prepareStatement(INSERT_ORDERS);
        	
            pstmt.setString(1, order.getUserEmail());
            pstmt.setInt(2, order.getOrderItemId());
            pstmt.setDouble(3, order.getTotalAmount());
            pstmt.setString(4, order.getPaymentOption());
            pstmt.setString(5, order.getStatus());

            res = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return res;
    }

    @Override
    public int updateOrderStatusById(int id, String status) {
        

        try{
        	pstmt = con.prepareStatement(UPDATE_ORDER_STATUS_BY_ID);
            pstmt.setString(1, status);
            pstmt.setInt(2, id);

            res = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Order> getAllOrders() {        

        try{
        	stmt = con.createStatement();    
        	resultSet = stmt.executeQuery(GET_ALL_ORDERS);
            orderList = (ArrayList<Order>) extractOrderListFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }
    
    private List<Order> extractOrderListFromResultSet(ResultSet resultSet) {
    	List<Order> orderList = new ArrayList<>();		
    	try {
			while(resultSet.next()==true) {
				orderList.add(new Order(resultSet.getInt("orderid"),
						resultSet.getInt("orderitem_id"),
			            resultSet.getString("userEmail"),
			            resultSet.getDouble("totalAmount"),
			            resultSet.getString("paymentoption"),
			            resultSet.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}



	@Override
	public int deleteOrderById(int id) {
		try {
			pstmt = con.prepareStatement(DELETE_BY_OID);
			pstmt.setInt(1, id);
			res = pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	}


	@Override
	public Order getOrderByOrderId(int oid) {

        try  {
        	pstmt = con.prepareStatement(GET_ORDERS_BY_ORDER_ID);
            pstmt.setInt(1, oid);
            resultSet = pstmt.executeQuery();
           
        	while(resultSet.next())
        	{
        		order = new Order(
        				resultSet.getInt("orderid"),
        				resultSet.getInt("orderitem_id"),
        				resultSet.getString("userEmail"),
        				resultSet.getDouble("totalAmount"),
        				resultSet.getString("paymentoption"),
        				resultSet.getString("status")
        				);
        	}            	
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;

	}


}


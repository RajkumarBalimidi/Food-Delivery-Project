package com.tap.foodapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.impl.CartItemDAOImpl;
import com.tap.foodapp.impl.MenuDAOImpl;
import com.tap.foodapp.model.Menu;
import com.tap.foodapp.dao.MenuDAO;
import com.tap.foodapp.model.CartItem;

/**
 * Servlet implementation class AddToCartByMenuID
 */
//@WebServlet("/AddToCartByMenuID")
public class AddToCartByMenuID extends HttpServlet {
	
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession();
		CartItem cart = (CartItem) session.getAttribute("cart");

		if(cart == null)
		{
			cart = new CartItem();
			session.setAttribute("cart", cart);
		}
		
		String action = request.getParameter("action");
		
		if("add".equals(action))
		{
			addItemToCart(request, cart);
		}
		
		session.setAttribute("cart", cart);
		response.sendRedirect("addToCart.jsp");
	}

	private void addItemToCart(HttpServletRequest request, CartItem cart) {
		
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		  // Fetch the menu item from the database using MenuDAO
        MenuDAO menuDAO = new MenuDAOImpl();
        Menu menuItem = menuDAO.getMenuById(menuId);

        // If the menu item exists, add it to the cart
        if (menuItem != null) {
            CartItem item = new CartItem(
                menuItem.getMenu_id(),
                menuItem.getRestaurant_id(),
                menuItem.getMenu_name(),
                quantity,
                menuItem.getPrice()
            );
            CartItemDAOImpl cart1 = new CartItemDAOImpl();
            cart1.addItem(item);

            // Store the restaurantId in the session for future reference
            HttpSession session = request.getSession();
            session.setAttribute("restaurantId", menuItem.getRestaurant_id());
        }
		
	}
}


/*
 
 //		HttpSession session = req.getSession();
		int menuById = Integer.parseInt(request.getParameter("id"));
//			session.setAttribute("menuById", menuById);
//			resp.sendRedirect("addToCart.jsp");
//	

			// Get session and cart from session
        HttpSession session = request.getSession();
        CartItem cart = (CartItem) session.getAttribute("cart");

        // If no cart exists in session, create a new cart
        if (cart == null) {
            cart = new CartItem();
            session.setAttribute("cart", cart);
        }

        // Get the action parameter from the request
        String action = request.getParameter("act");

        // Perform actions based on the parameter
        if ("add".equals(action)) {
            addItemToCart(request, cart);
        } else if ("update".equals(action)) {
            updateCartItem(request, cart);
        } else if ("remove".equals(action)) {
            removeItemFromCart(request, cart);
        }

        // Update the cart in the session
        session.setAttribute("cart", cart);
        // Redirect to the cart.jsp page
        response.sendRedirect("cart.jsp");
    }

    // Method to handle adding an item to the cart
    private void addItemToCart(HttpServletRequest request, CartItem cart) {
        // Parse item ID and quantity from the request
		int menuById = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Fetch the menu item from the database using MenuDAO
        MenuDAO menuDAO = new MenuDAOImpl();
        Menu menuItem = menuDAO.getMenuById(menuById);

        // If the menu item exists, add it to the cart
        if (menuItem != null) {
            CartItem item = new CartItem(
                menuItem.getMenu_id(),
                menuItem.getRestaurant_id(),
                menuItem.getMenu_name(),
                quantity,
                menuItem.getPrice()
            );
            cart.addItem(item);

            // Store the restaurantId in the session for future reference
            HttpSession session = request.getSession();
            session.setAttribute("restaurantId", menuItem.getRestaurant_id());
        }
    }

    // Method to update the quantity of an item in the cart
    private void updateCartItem(HttpServletRequest request, CartItem cart) {
        // Parse item ID and new quantity from the request
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));

        // Update the item's quantity in the cart
        cart.updateItem(itemId, newQuantity);
    }

    // Method to remove an item from the cart
    private void removeItemFromCart(HttpServletRequest request, CartItem cart) {
        // Parse the item ID from the request
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        // Remove the item from the cart
        cart.removeItem(itemId);
    }

    // Override doGet to redirect to doPost for handling GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

 
 */

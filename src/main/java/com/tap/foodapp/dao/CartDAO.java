package com.tap.foodapp.dao;

import java.util.List;

import com.tap.foodapp.model.Cart;

public interface CartDAO {

	int insertCart(Cart cart);
	
	List<Cart> getAllCartItems();
	
	List<Cart> getCartByUserId(String userId);
	
	int RemoveCartItemByCartId(int cartId);
	
}

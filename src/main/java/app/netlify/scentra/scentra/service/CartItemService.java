package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem createCartItem(CartItem cartItem);
    CartItem getCartItemById(Long cartItemId);
    CartItem updateCartItem(Long cartItemId, CartItem cartItem);
    List<CartItem> getAllCartItems();
    void deleteCartItem(Long cartItemId);

}

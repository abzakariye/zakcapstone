package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.Cart;

import java.util.List;

public interface CartService {

    Cart createCart(Cart cart);
    Cart getCartById(Long id);
    Cart updateCart(Long id, Cart updatedCart);
    void deleteCart(Cart cart);
    List<Cart> getAllCarts();
}

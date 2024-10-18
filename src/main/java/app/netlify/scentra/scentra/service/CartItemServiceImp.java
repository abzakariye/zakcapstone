package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.CartItem;
import app.netlify.scentra.scentra.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImp implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem getCartItemById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
    }

    @Override
    public CartItem updateCartItem(Long cartItemId, CartItem updatedCartItem) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
        cartItem.setProduct(updatedCartItem.getProduct());
        cartItem.setQuantity(updatedCartItem.getQuantity());
//        cartItem.setUser(updatedCartItem.getUser());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public void deleteCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}

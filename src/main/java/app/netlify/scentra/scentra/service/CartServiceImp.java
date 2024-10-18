package app.netlify.scentra.scentra.service;

import app.netlify.scentra.scentra.model.Cart;
import app.netlify.scentra.scentra.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserServiceImp userServiceImp;

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cart not found"));
    }

    @Override
    public Cart updateCart(Long id, Cart updatedCart) {
        Cart cart = getCartById(id);
        cart.setCartItems(updatedCart.getCartItems());
//        cart.setUser(updatedCart.getUser());
        cart.setTotal(updatedCart.getTotal());
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
}

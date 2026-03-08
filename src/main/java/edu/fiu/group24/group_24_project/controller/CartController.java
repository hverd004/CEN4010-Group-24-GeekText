package edu.fiu.group24.group_24_project.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController //REST APIs
@RequestMapping("/api/cart")
public class CartController {

    //Imitates the storage in a cart, including user and book IDs
    private Map<Long, List<Long>> carts = new HashMap<>();

    //Example of book prices
    private Map<Long, Double> bookPrices = Map.of(
            1L, 10.99,
            2L, 15.50,
            3L, 7.25
    );

    //GET method to retrieve subtotal of user's cart
    @GetMapping("/{userId}/subtotal")
    public double getSubtotal(@PathVariable Long userId) {

        List<Long> cart = carts.getOrDefault(userId, new ArrayList<>());

        double subtotal = 0.0;

        for (Long bookId : cart) {
            subtotal += bookPrices.getOrDefault(bookId, 0.0);
        }

        return Math.round(subtotal * 100.0) / 100.0; //Rounds the subtotal
    }

    //POST method to add a book to the user's cart with confirmation statement
    @PostMapping
    public String addBookToCart(@RequestParam Long userId,
                                @RequestParam Long bookId) {

        carts.putIfAbsent(userId, new ArrayList<>());
        carts.get(userId).add(bookId);

        return "Book " + bookId + " added to cart for user " + userId;
    }

    //GET list to retrieve the books in the user's cart
    @GetMapping("/{userId}")
    public List<Long> getCartBooks(@PathVariable Long userId) {

        return carts.getOrDefault(userId, new ArrayList<>());
    }

    //DELETE method to remove a book from the user's cart with confirmation statement
    @DeleteMapping
    public String removeBookFromCart(@RequestParam Long userId,
                                     @RequestParam Long bookId) {

        List<Long> cart = carts.get(userId);

        if (cart != null) {
            cart.remove(bookId);
        }

        return "Book " + bookId + " removed from cart for user " + userId;
    }
}
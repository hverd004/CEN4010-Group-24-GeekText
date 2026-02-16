package edu.fiu.group24.group_24_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")

public class CartController {

    @GetMapping
    public List<String> getCart() {

        return List.of("Example book A", "Example book B");

    }

    @GetMapping("/{id}")
    public String getCartItem(@PathVariable Long id) {
        return "Cart Item with ID" + id + " retrieved.";
    }
}

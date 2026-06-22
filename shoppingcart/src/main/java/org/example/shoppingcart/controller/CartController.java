package org.example.shoppingcart.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.shoppingcart.model.CartItem;
import org.example.shoppingcart.model.Product;
import org.example.shoppingcart.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final IProductService productService;

    /**
     * Lấy giỏ hàng từ Session
     */
    private List<CartItem> getCart(HttpSession session) {
        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        return cart;
    }

    /**
     * Hiển thị giỏ hàng
     */
    @GetMapping
    public String viewCart(HttpSession session,
                           Model model) {

        List<CartItem> cart = getCart(session);

        model.addAttribute("cart", cart);
        model.addAttribute("total", calculateTotal(cart));

        return "cart/view";
    }

    /**
     * Thêm sản phẩm vào giỏ hàng
     */
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            HttpSession session) {

        Product product = productService.findById(id)
                .orElseThrow();

        List<CartItem> cart = getCart(session);

        boolean existed = false;

        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(id)) {

                item.setQuantity(item.getQuantity() + 1);

                existed = true;

                break;
            }
        }

        if (!existed) {
            cart.add(new CartItem(product, 1));
        }

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    /**
     * Cập nhật số lượng
     */
    @PostMapping("/update")
    public String updateQuantity(@RequestParam Long productId,
                                 @RequestParam Integer quantity,
                                 HttpSession session) {

        List<CartItem> cart = getCart(session);

        if (quantity <= 0) {

            cart.removeIf(item ->
                    item.getProduct()
                            .getId()
                            .equals(productId));

        } else {

            for (CartItem item : cart) {

                if (item.getProduct()
                        .getId()
                        .equals(productId)) {

                    item.setQuantity(quantity);

                    break;
                }
            }
        }

        return "redirect:/cart";
    }

    /**
     * Xóa sản phẩm khỏi giỏ hàng
     */
    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id,
                                HttpSession session) {

        List<CartItem> cart = getCart(session);

        cart.removeIf(item ->
                item.getProduct()
                        .getId()
                        .equals(id));

        return "redirect:/cart";
    }

    /**
     * Hiển thị trang thanh toán
     */
    @GetMapping("/checkout")
    public String checkout(HttpSession session,
                           Model model) {

        List<CartItem> cart = getCart(session);

        model.addAttribute("cart", cart);
        model.addAttribute("total", calculateTotal(cart));

        return "cart/checkout";
    }

    /**
     * Xác nhận thanh toán
     */
    @PostMapping("/checkout")
    public String completeCheckout(HttpSession session) {

        session.removeAttribute("cart");

        return "redirect:/products";
    }

    /**
     * Tính tổng tiền
     */
    private Double calculateTotal(List<CartItem> cart) {

        return cart.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
}
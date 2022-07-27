package com.example.shoppingcart.controller;


import com.example.shoppingcart.dto.CartDto;
import com.example.shoppingcart.dto.ProductDto;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")  // khai báo session tên là cart
@Controller
@RequestMapping("shop")
public class ProductController {

    //    khởi tạo giá trị mặc định cho card
    @ModelAttribute("cart")
    public CartDto initCard() {
        return new CartDto();
    }

    @Autowired
    IProductService productService;

    @GetMapping
    public ModelAndView showList(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        return new ModelAndView("product/list", "productList", productService.findAll());
    }

    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response) {
        //Tạo Cookie
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(2 * 24 * 60 * 60); //thời gian tồn tại cookie là 2 ngày
        cookie.setPath("/");
        return new ModelAndView("product/detail", "product", productService.findById(id).get());
    }

    @GetMapping("add/{id}")
    public String addToCard(@PathVariable Long id, @ModelAttribute("cart") CartDto cartDto) { //lấy session cart ra dùng
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            //thêm sản phẩm Dto vào giỏ hàng
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("delete")
    public String delete(@RequestParam Long id, @SessionAttribute(name = "cart", required = false) CartDto cartDto) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            cartDto.delete(productDto);
        }
        return "redirect:/cart";
    }
}
package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        return new ModelAndView("detail", "products", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart")CartDto cartDto){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            com.codegym.dto.ProductDto productDto = new com.codegym.dto.ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);

            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }

}

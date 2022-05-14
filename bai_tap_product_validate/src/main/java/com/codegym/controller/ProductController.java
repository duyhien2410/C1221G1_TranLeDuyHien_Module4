package com.codegym.controller;

import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.ICategoryService;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String goList(Model model,
                         @PageableDefault(value = 3) Pageable pageable,
                         @RequestParam Optional<String> name,
                         @RequestParam Optional<String> manufacture) {
        String nameVal = name.orElse("");
        String manufactureVal = manufacture.orElse("");

        model.addAttribute("product", this.productService.findAllAndSearch(
                nameVal, manufactureVal, pageable));
        model.addAttribute("nameVal",nameVal);
        model.addAttribute("manufactureVal",manufactureVal);

        return "list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("category", this.categoryService.findAll());
        model.addAttribute("productDto", new ProductDto());

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ProductDto productDto,
                         BindingResult bindingResult,
                         Model model) {
        new ProductDto().validate(productDto,bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("category", this.categoryService.findAll());
            return "create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
        }

        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        this.productService.delete(id);

        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String goUpdate(@RequestParam("id") int id,
                           Model model) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(this.productService.findById(id),productDto);

        model.addAttribute("category", this.categoryService.findAll());
        model.addAttribute("productDto", productDto);
        return "update";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute @Validated ProductDto productDto,
                         BindingResult bindingResult,
                         Model model) {

        new ProductDto().validate(productDto,bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("category", this.categoryService.findAll());
            return "update";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
        }

        return "redirect:/list";
    }

}

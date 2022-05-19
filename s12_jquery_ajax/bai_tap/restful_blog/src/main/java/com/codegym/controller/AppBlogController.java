package com.codegym.controller;

import com.codegym.dto.AppBlogDto;
import com.codegym.model.AppBlog;
import com.codegym.service.IAppBlogService;
import com.codegym.service.IBlogTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AppBlogController {
    @Autowired
    private IAppBlogService appBlogService;

    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("/list")
    public String goListBlog(Model model,
                             @PageableDefault(value = 2) Pageable pageable) {

        model.addAttribute("blog", this.appBlogService.findAll(pageable));

        return "list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("typeBlog", this.blogTypeService.findAll());
        model.addAttribute("blogDto", new AppBlogDto());

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute AppBlogDto appBlogDto) {

        AppBlog appBlog = new AppBlog();
        BeanUtils.copyProperties(appBlogDto, appBlog);
        appBlogService.save(appBlog);

        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        this.appBlogService.deleteById(id);

        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String goUpdate(@RequestParam("id") int id, Model model) {
        AppBlogDto appBlogDto = new AppBlogDto();
        BeanUtils.copyProperties(this.appBlogService.findById(id), appBlogDto);

        model.addAttribute("category", this.blogTypeService.findAll());
        model.addAttribute("appBlogDto", appBlogDto);

        return "update";
    }

    @PostMapping("/edit")
    public String update(AppBlog appBlog) {
        appBlogService.save(appBlog);
        return "redirect:/list";
    }



}

package com.codegym.controller;

import com.codegym.model.AppBlog;
import com.codegym.model.BlogType;
import com.codegym.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog-type")
public class BlogTypeRestController {
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("/search/{id}")
    public ResponseEntity<List<AppBlog>> getBlogType(@PathVariable int id){
        BlogType blogType = this.blogTypeService.findById(id);
        if (blogType == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogType.getBlogList(), HttpStatus.OK);
    }
}

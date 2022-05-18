package com.codegym.controller;

import com.codegym.dto.AppBlogDto;
import com.codegym.model.AppBlog;
import com.codegym.model.BlogType;
import com.codegym.service.IAppBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog-rest")
public class AppBlogRestController {
    @Autowired
    private IAppBlogService appBlogService;

    @GetMapping("/list")
    public ResponseEntity<Page<AppBlog>> getPageBlog(@PageableDefault(value = 3)Pageable pageable){
        Page<AppBlog> blogPage = this.appBlogService.findAll(pageable);

        if (!blogPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createBlog(@Validated @RequestBody AppBlogDto appBlogDto,
                                                       BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        AppBlog appBlog = new AppBlog();
        BlogType blogType = new BlogType();
        blogType.setId(appBlogDto.getBlogType().getId());

        appBlog.setBlogType(blogType);
        BeanUtils.copyProperties(appBlogDto, appBlog);

        this.appBlogService.save(appBlog);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<AppBlog> showDetail(@PathVariable int id) {
        Optional<AppBlog> optionalAppBlog = Optional.ofNullable(appBlogService.findById(id));
        if (!optionalAppBlog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalAppBlog.get(),HttpStatus.OK);
    }
}

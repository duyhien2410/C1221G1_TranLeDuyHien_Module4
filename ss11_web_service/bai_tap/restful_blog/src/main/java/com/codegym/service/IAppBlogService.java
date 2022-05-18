package com.codegym.service;

import com.codegym.model.AppBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAppBlogService {
    void save(AppBlog appBlog);

    void deleteById(int id);

    AppBlog findById(int id);

    Page<AppBlog> findAll(Pageable pageable);
}

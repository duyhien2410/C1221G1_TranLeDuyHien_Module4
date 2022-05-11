package com.codegym.service;

import com.codegym.model.AppBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAppBlogService {
    List<AppBlog> findAll();

    void save(AppBlog appBlog);

    void deleteById(int id);

    AppBlog findById(int id);

//    List<AppBlog> listSearch(String name);

    Page<AppBlog> listSearchByName(String keywordVal, Pageable pageable);

//    Page<AppBlog> listPage(Pageable pageable);
}

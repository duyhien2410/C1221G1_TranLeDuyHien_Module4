package com.codegym.service.impl;

import com.codegym.model.AppBlog;
import com.codegym.repository.IAppBlogRepository;

import com.codegym.service.IAppBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppBlogService implements IAppBlogService {
    @Autowired
    private IAppBlogRepository appBlogRepository;

    @Override
    public List<AppBlog> findAll() {
        return this.appBlogRepository.findAll();
    }

    @Override
    public void save(AppBlog appBlog) {

        this.appBlogRepository.save(appBlog);
    }

    @Override
    public void deleteById(int id) {
        this.appBlogRepository.deleteById(id);
    }

    @Override
    public AppBlog findById(int id) {
        return this.appBlogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<AppBlog> listSearchByName(String keywordVal, Pageable pageable) {
        return this.appBlogRepository.findAllByNameBlogContaining(keywordVal, pageable);
    }

//    @Override
//    public Page<AppBlog> listPage(Pageable pageable) {
//        return this.appBlogRepository.findAll(pageable);
//    }

//    @Override
//    public List<AppBlog> listSearch(String name) {
//        return this.appBlogRepository.listSearch("%"+name+"%");
//    }

//    @Override
//    public Page<AppBlog> listSearchByName(String name, Pageable pageable) {
//        return this.appBlogRepository.findAllByNameBlogContaining(name, pageable);
//    }


}

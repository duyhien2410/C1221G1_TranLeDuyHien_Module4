package com.codegym.service.impl;

import com.codegym.model.BlogType;
import com.codegym.repository.IBlogTypeRepository;
import com.codegym.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeService implements IBlogTypeService {
    @Autowired
    private IBlogTypeRepository blogTypeRepository;

    @Override
    public List<BlogType> findAll() {
        return this.blogTypeRepository.findAll();
    }

    @Override
    public BlogType findById(int id) {
        return this.blogTypeRepository.findById(id).orElse(null);
    }
}

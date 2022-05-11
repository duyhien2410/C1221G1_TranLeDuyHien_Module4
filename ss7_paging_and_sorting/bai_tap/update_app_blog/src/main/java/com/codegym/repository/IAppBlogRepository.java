package com.codegym.repository;

import com.codegym.model.AppBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAppBlogRepository extends JpaRepository<AppBlog, Integer> {
//
//    @Query(value = "select * from blog where name_blog like :name",
//            countQuery = "select * from blog where name_blog like :name",
//            nativeQuery = true)
//    Page<AppBlog> findAllByNameBlog(@Param("name") String keywordVal, Pageable pageable);

        Page<AppBlog> findAllByNameBlogContaining(String name, Pageable pageable);
//    Page<AppBlog> findAll(Pageable pageable);
}

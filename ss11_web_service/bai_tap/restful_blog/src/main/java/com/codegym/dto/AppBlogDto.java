package com.codegym.dto;

import com.codegym.model.BlogType;

public class AppBlogDto {
    private Integer idBlog;
    private String nameBlog;
    private String title;
    private String content;
    private BlogType blogType;

    public AppBlogDto() {
    }

    public AppBlogDto(String nameBlog, String title, String content, BlogType blogType) {
        this.nameBlog = nameBlog;
        this.title = title;
        this.content = content;
        this.blogType = blogType;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }
}

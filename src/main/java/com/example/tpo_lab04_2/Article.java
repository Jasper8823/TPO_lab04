package com.example.tpo_lab04_2;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table()
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private User author;
    @ManyToOne
    private Blog blog;

    public Article() {

    }

    @Override
    public String toString(){
        return "Article{id:"+id+" title:"+title+" author:"+author.getId()+" blog:"+blog.getId()+"}";
    }
    public Article(String name, User u, Blog b){
        this.title = name;
        author = u;
        blog =b;
    }
}

package com.example.tpo_lab04_2;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table()
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> article_list = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "manager", unique = true)
    private User manager;

    public Blog() {

    }


    @Override
    public String toString(){
        return "Blog{id:"+id+" name:"+name+" manager:"+manager.getId()+"}";
    }

    public Blog(String name, User u){
        this.name = name;
        manager = u;
    }
    public long getId(){return id;}
}

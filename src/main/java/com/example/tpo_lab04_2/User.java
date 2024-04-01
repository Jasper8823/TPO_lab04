package com.example.tpo_lab04_2;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> article_list = new ArrayList<>();
    @OneToOne(mappedBy = "manager",cascade = CascadeType.ALL, orphanRemoval = true)
    private Blog managedblog;

    @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Role> roleList = new ArrayList<>();

    public User() {

    }

    @Override
    public String toString(){
        return "User{id:"+id+" email:"+email+"}";
    }
    public User(String email){
        this.email =email;
    }
    public long getId(){return id;}
}

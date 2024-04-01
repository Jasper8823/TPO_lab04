package com.example.tpo_lab04_2;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table()
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private List<User> userList = new ArrayList<>();

    public Role() {

    }

    @Override
    public String toString(){
        return "Role{id:"+id+" name:"+name+"}";
    }
    public Role(String name){
        this.name = name;
    }
}

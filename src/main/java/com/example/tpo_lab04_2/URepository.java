package com.example.tpo_lab04_2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface URepository extends CrudRepository<User,Long> {
    @Query("SELECT u FROM User u")
    List<User> seeAll();
    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findByLongId(Long id);
}

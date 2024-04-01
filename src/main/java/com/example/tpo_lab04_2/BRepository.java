package com.example.tpo_lab04_2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BRepository extends CrudRepository<Blog,Long> {
    @Query("SELECT u FROM Blog u")
    List<Blog> seeAll();
    @Query("SELECT u FROM Blog u WHERE u.id = ?1")
    Blog findByLongId(Long id);
}

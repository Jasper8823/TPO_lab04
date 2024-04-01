package com.example.tpo_lab04_2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ARepository extends CrudRepository<Article,Long> {
    @Query("SELECT u FROM Article u")
    List<Article> seeAll();
    @Query("SELECT u FROM Article u WHERE u.id = ?1")
    Article findByLongId(Long id);
}

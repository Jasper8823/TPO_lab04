package com.example.tpo_lab04_2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RRepository extends CrudRepository<Role,Long> {
    @Query("SELECT u FROM Role u")
    List<Role> seeAll();
    @Query("SELECT u FROM Role u WHERE u.id = ?1")
    Role findByLongId(Long id);
}

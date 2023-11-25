package com.cg.uploadimagelocaledemo.repository;

import com.cg.uploadimagelocaledemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

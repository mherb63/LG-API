package com.increditek.lgapi.repository;

import com.increditek.lgapi.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Page<User> findAllByIsDeleted(Boolean isDeleted, Pageable p);
    Optional<User> findByUserName(String userName);
    List<User> findByEmailAndIsDeleted(String email, boolean isDeleted);
}

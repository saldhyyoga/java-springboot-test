package com.bni.test.repository;

import com.bni.test.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findById(Long id);

//    public Page<User> getAllUsers(Pageable pageable);
//    public Page<User>
//    public Page<User> findAllByDeleted_timeIsNull(Pageable pageable);
}


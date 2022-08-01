package com.microTransaction.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microTransaction.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByAccountnumber(long accountnumber);

}

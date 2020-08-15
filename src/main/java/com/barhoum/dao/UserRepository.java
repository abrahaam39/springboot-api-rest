package com.barhoum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barhoum.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{



}

package com.example.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab2.entity.Role;
@Repository
public interface RoleDAO extends JpaRepository<Role, String>{

}

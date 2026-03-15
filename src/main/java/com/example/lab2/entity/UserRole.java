package com.example.lab2.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "UserRoles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    Long id;

    @ManyToOne 
    @JoinColumn(name = "username") 
    User user;

    @ManyToOne 
    @JoinColumn(name = "roleid")
    Role role;
}

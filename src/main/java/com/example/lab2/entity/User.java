package com.example.lab2.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "Users")
public class User {
    @Id
    String username;
    String password;
    boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) 
    List<UserRole> userRoles;
}

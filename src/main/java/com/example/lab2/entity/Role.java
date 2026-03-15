package com.example.lab2.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Roles")
public class Role {
    @Id
    String id;
    String name;

    @OneToMany(mappedBy = "role") 
    List<UserRole> userRoles;
}

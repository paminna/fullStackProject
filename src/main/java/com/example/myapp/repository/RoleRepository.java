package com.example.myapp.repository;

import com.example.myapp.entity.Role;
import com.example.myapp.utils.JpaBase;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaBase<Role, Integer> {
}

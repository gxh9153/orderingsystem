package com.gxh.repository;

import com.gxh.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository {
    public Admin login(String username, String password);
}

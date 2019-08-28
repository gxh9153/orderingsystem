package com.gxh.repository;

import com.gxh.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    public List<User> findAll(int index,int limit);
    public User findById(int id);
    public int count();
    public void save(User user);
    public void update(User user);
    public void deleteById(int id);
}

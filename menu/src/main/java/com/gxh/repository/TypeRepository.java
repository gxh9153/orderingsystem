package com.gxh.repository;

import com.gxh.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository {

    public Type findById(int id);
    public List<Type> findAll();
}

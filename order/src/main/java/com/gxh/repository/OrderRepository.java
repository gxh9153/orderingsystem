package com.gxh.repository;

import com.gxh.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface OrderRepository {

    public void save(@RequestBody Order order);
    public List<Order> findAllByUid(int index, int limit,int uid);
    public int countByUid(int uid);
    public List<Order> findAllByState(int index,int limit);
    public int count();
    public void update(int id);

}

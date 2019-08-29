package com.gxh.controller;

import com.gxh.entity.Order;
import com.gxh.entity.OrderDTO;
import com.gxh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new SimpleDateFormat("yyyy-MM--dd").format(new Date()));
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderDTO findAllByUid(@PathVariable("index") int index,
                            @PathVariable("limit") int limit,
                            @PathVariable("uid") int uid){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCode(0);
        orderDTO.setMessage("");
        orderDTO.setCount(orderRepository.countByUid(uid));
        orderDTO.setData(orderRepository.findAllByUid(index,limit,uid));
        return orderDTO;
    }

    @GetMapping("/findAllByState/{index}/{limit}")
    public OrderDTO findAllByState(@PathVariable("index") int index,
                                   @PathVariable("limit") int limit){
        return new OrderDTO(0,"",orderRepository.count(),orderRepository.findAllByState(index,limit));
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") int id){
        orderRepository.update(id);
    }

}

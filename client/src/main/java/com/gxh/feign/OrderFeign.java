package com.gxh.feign;

import com.gxh.entity.Order;
import com.gxh.entity.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(Order order);

    @RequestMapping("/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderDTO findAllByUid(@PathVariable("index") int index,
                            @PathVariable("limit") int limit,
                            @PathVariable("uid") int uid);

    @GetMapping("/order/findAllByState/{index}/{limit}")
    public OrderDTO findAllByState(@PathVariable("index") int index,
                                   @PathVariable("limit") int limit);

    @PutMapping("/order/update/{id}")
    public void update(@PathVariable("id") int id);
}

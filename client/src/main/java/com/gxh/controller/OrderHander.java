package com.gxh.controller;

import com.gxh.entity.Menu;
import com.gxh.entity.Order;
import com.gxh.entity.OrderDTO;
import com.gxh.entity.User;
import com.gxh.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderHander {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") int mid,
                     HttpSession session){
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        orderFeign.save(order);
        return "redirect:/menu/redirect/order.html";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderDTO findAllByUid(@RequestParam("page") int page,
                                @RequestParam("limit") int limit,
                                HttpSession session){
        User user = (User) session.getAttribute("user");
        int index = (page-1)*limit;
        OrderDTO orderDTO = orderFeign.findAllByUid(index, limit,user.getId());
        return orderDTO;
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderDTO findAllByState(@RequestParam("page") int page,
                                   @RequestParam("limit") int limit){
        int index = (page -1)*limit;
        OrderDTO orderDTO = orderFeign.findAllByState(index, limit);
        return orderDTO;
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id){
        orderFeign.update(id);
        return "redirect:/menu/redirect/order_handler.html";
    }
}

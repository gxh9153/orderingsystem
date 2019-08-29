package com.gxh.controller;

import com.gxh.entity.User;
import com.gxh.entity.UserDTO;
import com.gxh.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserDTO findAll(@RequestParam("page") int page,
                           @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        UserDTO userDTO = userFeign.findAll(index,limit);
        return userDTO;
    }


    @GetMapping("/count")
    @ResponseBody
    public int count(){
        return userFeign.count();
    }

    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) );
        userFeign.save(user);
        return "redirect:/menu/redirect/user_manage.html";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userFeign.deleteById(id);
        return "redirect:/menu/redirect/user_manage.html";
    }
}

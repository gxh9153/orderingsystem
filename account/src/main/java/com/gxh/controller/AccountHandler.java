package com.gxh.controller;

import com.gxh.entity.Admin;
import com.gxh.entity.User;
import com.gxh.repository.AdminRepository;
import com.gxh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/index")
    public String index(){
        return "account的端口号为："+this.port;
    }

    @RequestMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,
                        @PathVariable("password") String password,
                        @PathVariable("type") String type){
        Object object = null;
        switch(type){
            case "user" :
                object = userRepository.login(username, password);
                break;
            case "admin":
                object = adminRepository.login(username, password);
                break;
        }
        return object;
    }
}

package com.gxh.controller;

import com.gxh.entity.User;
import com.gxh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public String index(){
        return "user的端口号是:" +this.port;
    }
    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index,
                              @PathVariable("limit") int limit){
        return userRepository.findAll(index,limit);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id){
        return userRepository.findById(id);
    }

    @GetMapping("/count")
    public int count(){
        return userRepository.count();
    }

    @PostMapping("/save")
    public void save(User user){
        userRepository.save(user);
    }

    @PutMapping("/update")
    public void update(User user){
        userRepository.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        userRepository.deleteById(id);
    }
}

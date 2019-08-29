package com.gxh.feign;

import com.gxh.entity.User;
import com.gxh.entity.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user")
public interface UserFeign {

    @RequestMapping("/user/findAll/{index}/{limit}")
    public UserDTO findAll(@PathVariable("index") int index,
                           @PathVariable("limit") int limit);

    @RequestMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") int id);

    @RequestMapping("/user/count")
    public int count();

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @PutMapping("/user/update")
    public void update(@RequestBody User user);

    @DeleteMapping("/user/delete/{id}")
    public void deleteById(@PathVariable("id") int id);
}

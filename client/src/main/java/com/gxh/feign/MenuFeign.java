package com.gxh.feign;

import com.gxh.entity.Menu;
import com.gxh.entity.MenuDTO;
import com.gxh.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "menu")//这里的menu值是menu客户端注册在配置中心的名字
public interface MenuFeign {

    @RequestMapping("/menu/findAll/{index}/{limit}")
    public MenuDTO findAll(@PathVariable("index") int index,
                           @PathVariable("limit") int limit);

    @RequestMapping("/menu/delete/{id}")
    public void deleteById(@PathVariable("id") int id);

    @RequestMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public void insert(@RequestBody Menu menu);

    @RequestMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") int id);

    @PostMapping("/menu/update")
    public void update(@RequestBody Menu menu);
}

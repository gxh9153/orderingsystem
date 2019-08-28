package com.gxh.controller;


import com.gxh.entity.Menu;
import com.gxh.entity.MenuDTO;
import com.gxh.entity.Type;
import com.gxh.repository.MenuRepository;
import com.gxh.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    TypeRepository typeRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "menu的端口号是:" +this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuDTO findAll(@PathVariable("index") int index,
                           @PathVariable("limit") int limit){
        return new MenuDTO(0,"",menuRepository.count(),menuRepository.findAll(index,limit));
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        menuRepository.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
       return typeRepository.findAll();
    }

    @PostMapping("/save")
    public void insert(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") int id){
        return menuRepository.findById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }
}


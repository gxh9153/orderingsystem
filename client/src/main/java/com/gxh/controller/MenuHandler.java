package com.gxh.controller;

import com.gxh.entity.Menu;
import com.gxh.entity.MenuDTO;
import com.gxh.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuDTO findAll(@RequestParam("page") int page,
                           @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        MenuDTO menus = menuFeign.findAll(index, limit);
        return menus;
    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id){
        menuFeign.deleteById(id);
        return "redirect:/index.html";
    }

    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/save")
    public String insert(Menu menu){
        menuFeign.insert(menu);
        return "redirect:/index.html";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/index.html";
    }
}

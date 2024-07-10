package com.example.restaurant.controller;

import com.example.restaurant.model.MenuItem;
import com.example.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<MenuItem> getMenu() {
        return menuService.getMenu();
    }
}

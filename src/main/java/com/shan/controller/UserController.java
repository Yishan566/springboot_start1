package com.shan.controller;

import com.shan.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${shan.name}")
    private String shanName;

    // user body: {id:, name:}
    @PostMapping
    public String save(@RequestBody User user) {
        return "User saved..." + user.toString();
    }

    // /user/1
    @GetMapping("/{id}")
    public String get(@PathVariable int id) {
        return "User got..." + id + shanName;
    }

    @PutMapping
    public String update() {
        return "User updated...";
    }

    //user/1
    @DeleteMapping
    public String delete() {
        return "User deleted...";
    }

    // user?id=1&name=shan
    @GetMapping
    public String getUserByIdAndName(@RequestParam int id, String name) {
        return "User got" + id + " " + name;
    }
}

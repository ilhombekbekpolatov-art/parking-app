package com.smart.parking.controller;

import com.smart.parking.entity.AppUser;
import com.smart.parking.service.app.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app")
@RequiredArgsConstructor
public class AppController {

    private final AppService user2Service;


    @PostMapping
    public void save(@RequestBody AppUser user) {
        user2Service.save(user);
    }


    @GetMapping
    public List<AppUser> getAll() {
        return user2Service.getAll();
    }


    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AppUser user) {
        user2Service.update(id, user);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        user2Service.delete(id);
    }
}
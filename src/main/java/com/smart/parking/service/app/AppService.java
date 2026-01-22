package com.smart.parking.service.app;

import com.smart.parking.entity.AppUser;

import java.util.List;

public interface AppService {

     void save(AppUser user);

     List<AppUser> getAll();

     void update(Long id, AppUser newUser);

     void delete(Long id);
}

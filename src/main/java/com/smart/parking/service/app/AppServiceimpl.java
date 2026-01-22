package com.smart.parking.service.app;



import com.smart.parking.entity.AppUser;
import com.smart.parking.repository.App2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceimpl implements AppService {

    private final App2Repository user2Repository;


    @Override
    public void save(AppUser user) {
        user2Repository.save(user);
    }

    @Override
    public List<AppUser> getAll() {
        return user2Repository.findAll();
    }

    @Override
    public void  update(Long id, AppUser newUser) {
        AppUser user2Entity = user2Repository.findById(id).get();
        if (newUser.getName() != null){
            user2Entity.setName(newUser.getName());
        }
        if (newUser.getFamily() != null){
            user2Entity.setFamily(newUser.getFamily());
        }
        if (newUser.getPassword() != null){
            user2Entity.setPassword(newUser.getPassword());
        }
        if (newUser.getPhone() != null){
            user2Entity.setPhone(newUser.getPhone());
        }
        if (newUser.getRole() != null){
            user2Entity.setRole(newUser.getRole());
        }
        user2Repository.save(user2Entity);

    }

    @Override
    public void delete(Long id) {
       user2Repository.deleteById(id);
    }
}


package fr.m2i.santagiftapi.controllers;

import fr.m2i.santagiftapi.models.User;
import fr.m2i.santagiftapi.services.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    @Resource(name="userService")
    private final UserServiceImpl userService;

    @GetMapping("")
    public List<User> getUsers(){
       return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}

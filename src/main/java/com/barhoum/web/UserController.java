package com.barhoum.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.barhoum.dao.UserRepository;
import com.barhoum.entities.User;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    public User create(@RequestBody User user)
    {
        return userRepository.save(user);
    }


    @GetMapping("/users")
    public List<User> findAll()
    {
        return userRepository.findAll();
    }


    @PutMapping("/users/{user_id}")
    public User update(@PathVariable ("user_id") Long userId, @RequestBody User userObject)
    {
        User user = userRepository.findById(userId).get();
        user.setLogin(userObject.getLogin());
        user.setPassword(userObject.getPassword());
        return userRepository.save(user);
    }



    @DeleteMapping("/users/{user_id}")
    public List<User> delete(@PathVariable("user_id") Long userId)
    {
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }



    @GetMapping("/users/{user_id}")
    public User findByUserId(@PathVariable("user_id") Long userId)
    {
        return userRepository.findById(userId).get();
    }

}

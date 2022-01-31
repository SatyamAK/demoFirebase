package org.prograd.demoFirebase.controllers;

import org.prograd.demoFirebase.models.MyUser;
import org.prograd.demoFirebase.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    public UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody MyUser user) throws ExecutionException, InterruptedException {
        return userService.createUser(user);
    }

    @GetMapping("/getUser")
    public MyUser getUser(@RequestParam String userId) throws ExecutionException, InterruptedException {
        return userService.getUser(userId);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody MyUser user) throws ExecutionException, InterruptedException{
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String userId)throws ExecutionException, InterruptedException{
        return userService.deleteUser(userId);
    }
}

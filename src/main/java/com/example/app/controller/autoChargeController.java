package com.example.app.controller;

import com.example.app.model.UserModel;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class autoChargeController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public UserModel addUser(@RequestBody UserModel userModel){
        return userService.creatUser(userModel);
    }


    @PostMapping("/{userName}/addMoney")
    public String addMoneyToUser(@RequestBody UserModel userModel,@PathVariable String userName){
        return userService.addMoney(userName,userModel);
    }

/*    @PostMapping("/addCharge")
    public UserModel addMoney(UserModel userModel){
        
    }*/
}

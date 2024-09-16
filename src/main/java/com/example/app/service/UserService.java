package com.example.app.service;

import com.example.app.Dao.UserDao;
import com.example.app.Entity.User;
import com.example.app.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;


    public UserModel creatUser(UserModel userModel){
        User user = new User();
        user.setUserName(userModel.getUserName());
        user.setAmount(userModel.getAmount());
        userDao.save(user);

        return userModel;
    }

    public String addMoney(String userName,UserModel userModel){
        User user=userDao.findByUserName(userName);
        if(user!=null){
            double inventory=user.getAmount() + userModel.getUserAddMoney().getAmount();
            user.setAmount(inventory);
            userDao.save(user);
            return "succses";
        }
        else {
            return "user not found";
        }
    }
}

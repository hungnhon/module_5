package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;


@Service

public class UserService implements IUserService {
    @Override
    public void save(User user) {

        System.out.println("Đã lưu:");
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getPhoneNumber());
        System.out.println(user.getAge());
        System.out.println(user.getEmail());

    }
}

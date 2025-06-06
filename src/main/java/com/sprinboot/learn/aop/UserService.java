package com.sprinboot.learn.aop;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void createUser(String name){
        System.out.println("Creating User with the name -> " + name);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(String name){
        System.out.println("Deleting User with the name -> " + name);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

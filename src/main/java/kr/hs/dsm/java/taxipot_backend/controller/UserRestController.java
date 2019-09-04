package kr.hs.dsm.java.taxipot_backend.controller;

import kr.hs.dsm.java.taxipot_backend.entity.User;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    UserRepository repository;

    @GetMapping
    public User findUserById(@RequestParam(value = "user_id")long id) {
        if(repository==null){
            System.out.println("repositody is Null");
        }
        User user = repository.findUserById(id);
        if(user == null){
            System.out.println("user is Null");
        }
        return user;
    }
}

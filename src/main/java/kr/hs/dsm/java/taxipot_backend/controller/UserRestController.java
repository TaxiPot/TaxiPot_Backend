package kr.hs.dsm.java.taxipot_backend.controller;

import kr.hs.dsm.java.taxipot_backend.entity.User;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ArrayList<User> findAll() {
        return userRepository.findAll();
    }
}

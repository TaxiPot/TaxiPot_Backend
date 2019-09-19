package kr.hs.dsm.java.taxipot_backend.controller;

import kr.hs.dsm.java.taxipot_backend.entity.User;
import kr.hs.dsm.java.taxipot_backend.exception.SignInNotExistException;
import kr.hs.dsm.java.taxipot_backend.exception.SignUpAlreadyExistException;
import kr.hs.dsm.java.taxipot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ArrayList<User> findAll() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/signin")
    public User signIn(@ModelAttribute User param) {
        Optional<User> optionalUser = userRepository.findById(param.getUser_id());
        User user = null;
        try{
            user = optionalUser.get();
        } catch (NoSuchElementException e) {
            throw new SignInNotExistException("Account Not Found");
        }
        if(user.getUser_password().equals(param.getUser_password())) {
            return user;
        } else {
            throw new SignInNotExistException("Account Not Found");
        }
    }

    @RequestMapping(method = RequestMethod.POST, path="/signup")
    public ArrayList<User> signUp(@RequestBody User user) {
        Optional<User> optionalUser = userRepository.findById(user.getUser_id());
        try{
            user = optionalUser.get();
            throw new SignUpAlreadyExistException("Account Already Exist");
        } catch (NoSuchElementException e) {
            userRepository.save(user);
        }
        return findAll();
    }
}

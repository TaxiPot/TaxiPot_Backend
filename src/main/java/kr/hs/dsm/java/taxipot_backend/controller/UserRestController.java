package kr.hs.dsm.java.taxipot_backend.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.hs.dsm.java.taxipot_backend.entity.User;
import kr.hs.dsm.java.taxipot_backend.exception.AlreadyExistException;
import kr.hs.dsm.java.taxipot_backend.exception.NotFoundException;
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

    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "아이디 혹은 패스워드가 잘못되었습니다.")
    })
    @RequestMapping(method = RequestMethod.GET, path = "/signin")
    public User signIn(@ModelAttribute User param) {
        Optional<User> optionalUser = userRepository.findById(param.getUser_id());
        User user = null;
        try{
            user = optionalUser.get();
        } catch (NoSuchElementException e) {
            throw new NotFoundException("Account Not Found");
        }
        if(user.getUser_password().equals(param.getUser_password())) {
            return user;
        } else {
            throw new NotFoundException("Account Not Found");
        }
    }


    @ApiResponses(value = {
            @ApiResponse(code = 409, message = "이미 존재하는 아이디입니다.")
    })
    @RequestMapping(method = RequestMethod.POST, path="/signup")
    public void signUp(@RequestBody User user) throws AlreadyExistException {
        Optional<User> optionalUser = userRepository.findById(user.getUser_id());
        if(optionalUser.isPresent()) {
            throw new AlreadyExistException("Account Already Exist");
        } else {
            userRepository.save(user);
        }
    }
}

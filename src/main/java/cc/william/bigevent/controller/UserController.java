package cc.william.bigevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.william.bigevent.pojo.rest.Result;
import cc.william.bigevent.service.UserService;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, @Pattern(regexp = "^\\S{5,16}$")String password) {

        return userService.register(username, password);
    }

    @PostMapping("/login")
    public Result<String> login(String username, @Pattern(regexp = "^\\S{5,16}$")String password) {

        return userService.login(username, password);
    }
    
}

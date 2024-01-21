package cc.william.bigevent.controller;

import cc.william.bigevent.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name="Authorization") String token) {
        return userService.getUserInfoByToken(token);
    }

    @PutMapping("/update")
    public Result update(@RequestHeader(name="Authorization") String token, @RequestBody @Validated User user) {
        return userService.update(user, token);
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestHeader(name="Authorization") String token, @RequestBody String avatarUrl) {
        return userService.updateAvatar(avatarUrl, token);
    }

    
}

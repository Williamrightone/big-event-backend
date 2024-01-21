package cc.william.bigevent.service.impl;

import cc.william.bigevent.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.william.bigevent.mapper.UserMapper;
import cc.william.bigevent.pojo.User;
import cc.william.bigevent.pojo.rest.Result;
import cc.william.bigevent.service.UserService;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result register(String username, String password) {
        

        User user = userMapper.findByUserName(username);

        if(user != null){
            return Result.error("UserName existed");
        }

        System.out.println("username: " + username);

        userMapper.add(username, password);

        return Result.success();

    }

    @Override
    public Result<String> login(String username, String password) {
        User loginUser = userMapper.findByUserName(username);

        if(null == loginUser){
            return Result.error("UserName not existed");
        }

        if(password.equals(loginUser.getPassword())){

            Map<String, Object> claims = Map.of("username", username, "password", password);

            String token = JwtUtil.generateToken(claims);

            return Result.success(token);
        }

        return Result.error("Password error");

    }

    @Override
    public Result<User> getUserInfoByToken(String token) {

        Map<String, Object> userMap = JwtUtil.parseToken(token);

        String username = (String) userMap.get("username");

        User user = userMapper.findByUserName(username);


        return Result.success(user);
    }

    @Override
    public Result update(User user, String token) {

        Map<String, Object> claims = JwtUtil.parseToken(token);

        String username = (String) claims.get("username");

        userMapper.update(user.getNickname(), user.getEmail(), username);

        return Result.success();
    }

    @Override
    public Result updateAvatar(String avatarUrl, String token) {

        userMapper.updateAvatar(avatarUrl, (String) JwtUtil.parseToken(token).get("username"));

        return Result.success();
    }


}

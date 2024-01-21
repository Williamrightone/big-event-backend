package cc.william.bigevent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.william.bigevent.mapper.UserMapper;
import cc.william.bigevent.pojo.User;
import cc.william.bigevent.pojo.rest.Result;
import cc.william.bigevent.service.UserService;

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
            return Result.success("Login success");
        }

        return Result.error("Password error");

    }


    
}

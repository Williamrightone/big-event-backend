package cc.william.bigevent.service;

import cc.william.bigevent.pojo.User;
import cc.william.bigevent.pojo.rest.Result;

public interface UserService {
    
    public Result register(String username, String password);

    public Result<String> login(String username, String password);

    public Result<User> getUserInfoByToken(String token);

    public Result update(User user, String token);

    public Result updateAvatar(String avatarUrl, String token);
}

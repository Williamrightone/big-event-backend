package cc.william.bigevent.service;

import cc.william.bigevent.pojo.User;
import cc.william.bigevent.pojo.rest.Result;

public interface UserService {

    User findByUserName(String username);

    //注册
    void register(String username, String password);

    //更新
    void update(User user);

    //更新头像
    void updateAvatar(String avatarUrl);

    //更新密码
    void updatePwd(String newPwd);
}

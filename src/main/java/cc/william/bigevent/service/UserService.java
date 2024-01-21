package cc.william.bigevent.service;

import cc.william.bigevent.pojo.rest.Result;

public interface UserService {
    
    public Result register(String username, String password);

    public Result<String> login(String username, String password);


}

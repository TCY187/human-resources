package com.iotek.service;

import com.iotek.model.User;

/**
 * Created by TCY on 2018/7/25.
 */
public interface UserService {
    User getUserByNameAndPass(User user);
    boolean saveUser(User user);
}

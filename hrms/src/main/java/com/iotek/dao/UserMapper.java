package com.iotek.dao;

import com.iotek.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by TCY on 2018/7/25.
 */
public interface UserMapper {
    User getUserByNameAndPass(User user);
    boolean saveUser(User user);
}

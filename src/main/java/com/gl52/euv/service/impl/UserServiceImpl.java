package com.gl52.euv.service.impl;

import com.gl52.euv.dao.UserDao;
import com.gl52.euv.mapper.UserMapper;
import com.gl52.euv.pojo.User;
import com.gl52.euv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理业务层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User identify(String name,String password) {
        return this.userMapper.selectByNameAndPassword(name,password);
    }
}

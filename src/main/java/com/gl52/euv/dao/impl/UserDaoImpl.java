package com.gl52.euv.dao.impl;

import com.gl52.euv.dao.UserDao;
import com.gl52.euv.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * add user
     * @param user
     */
    @Override
    public void insertUser(User user) {
        String sql="insert into users(username,password) values (?,?)";
//        this.jdbcTemplate.update(sql,user.getUserName(),user.getPassWord());
    }
}

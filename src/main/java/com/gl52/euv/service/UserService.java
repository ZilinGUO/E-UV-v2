package com.gl52.euv.service;

import com.gl52.euv.pojo.User;

public interface UserService {

     User identify(String name,String password);
     void insertGroupId(int userId,int groupId);
     boolean isHasGroup(int userId);
     int getGroupId(int userId);

}

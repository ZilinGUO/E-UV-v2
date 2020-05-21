package com.gl52.euv.service;

import com.gl52.euv.pojo.Group;

import java.util.Map;

public interface GroupService {
    Map<String,Object> getAllGroups(Map<String, Object> param);

    boolean createGroup(String groupName, int subjectId, int userId);

    boolean joinGroup(int groupId, int userId);

    Group enterGroup(int userId);
}

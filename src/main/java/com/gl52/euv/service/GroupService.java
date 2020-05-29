package com.gl52.euv.service;

import java.util.HashMap;
import java.util.Map;

public interface GroupService {
    Map<String,Object> getAllGroups(Map<String, Object> param);

    Integer createGroup(String groupName, int subjectId, int userId);

    boolean joinGroup(int groupId, int userId);

    HashMap getGroupByUserId(int userId);

    HashMap getGroupByGroupId(int groupId);

    void saveFichier(String originalFilename, byte[] data, int groupId);
}

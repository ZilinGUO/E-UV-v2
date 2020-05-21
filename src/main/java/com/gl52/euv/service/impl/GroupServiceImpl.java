package com.gl52.euv.service.impl;

import com.gl52.euv.mapper.GroupMapper;
import com.gl52.euv.mapper.UserMapper;
import com.gl52.euv.pojo.Group;
import com.gl52.euv.pojo.GroupExample;
import com.gl52.euv.pojo.User;
import com.gl52.euv.service.GroupService;
import com.gl52.euv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 团队管理业务层
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private UserService userService;

    @Override
    public Map<String, Object> getAllGroups(Map<String, Object> param) {
        GroupExample example=new GroupExample();
        Map<String,Object> map = new HashMap<>();
        List<Map<String, Object>> groupsList=groupMapper.selectByPageIndex(Integer.parseInt((String) param.get("offset")),Integer.parseInt((String) param.get("limit")));
//        List<Group> groupsList =groupMapper.selectByPageIndex(Integer.parseInt((String) param.get("offset")),Integer.parseInt((String) param.get("limit")));
        Integer total= Math.toIntExact(groupMapper.countByExample(example));
        map.put("total",total);
        map.put("rows",groupsList);
        return map;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean createGroup(String groupName, int subjectId, int userId) {
        if(!userService.isHasGroup(userId)){
            Group group=new Group();
            group.setSubjectid(subjectId);
            group.setProjectmanager(userId);
            group.setGroupname(groupName);
            group.setIsValid(0);
            groupMapper.insertSelective(group);
            userService.insertGroupId(userId,group.getGroupid());
            return true;
        }
        return false;
    }

    @Override
    public boolean joinGroup(int groupId, int userId) {
        if(!userService.isHasGroup(userId)){
            userService.insertGroupId(userId,groupId);
            return true;
        }
            return false;
    }

    @Transactional(readOnly=true)
    @Override
    public Group enterGroup(int userId) {
        if(!userService.isHasGroup(userId)){
            return null;
        }else{
            int groupId=userService.getGroupId(userId);
            Group group=groupMapper.selectByPrimaryKey(groupId);
            return group;
        }
    }
}

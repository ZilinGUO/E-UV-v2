package com.gl52.euv.service.impl;

import com.gl52.euv.mapper.ProjectMapper;
import com.gl52.euv.pojo.Project;
import com.gl52.euv.pojo.ProjectExample;
import com.gl52.euv.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目管理业务层
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public Map<String,Object>  getAllProjects(Map<String, Object> param) {
        ProjectExample example=new ProjectExample();
        Map<String,Object> map = new HashMap<>();
        List<Project> projectsList =projectMapper.selectByPageIndex(Integer.parseInt((String) param.get("offset")),Integer.parseInt((String) param.get("limit")));
        Integer total= Math.toIntExact(projectMapper.countByExample(example));
        map.put("total",total);
        map.put("rows",projectsList);
        return map;
    }


}

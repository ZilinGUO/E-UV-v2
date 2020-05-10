package com.gl52.euv.controller;

import com.gl52.euv.pojo.Project;
import com.gl52.euv.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Project")
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    private ProjectService projectService;

    /**
     * Back to project data list
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllProject.do")
    @ResponseBody
    public Map findAllProject (HttpServletRequest request,
                               HttpServletResponse response,@RequestParam Map<String, Object> param) throws Exception {
        try {
            System.out.println(param);
            return projectService.getAllProjects(param);
        }   catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    @RequestMapping("/showProject.do")
    public String showProject (HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
       return "Projects";
    }

}

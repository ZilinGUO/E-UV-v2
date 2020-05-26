package com.gl52.euv.controller;

import com.gl52.euv.pojo.Group;
import com.gl52.euv.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/Group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    /**
     * Find all groups
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllGroup.do")
    @ResponseBody
    public Map findAllGroup (HttpServletRequest request,
                               HttpServletResponse response, @RequestParam Map<String, Object> param) throws Exception {
        try {
            System.out.println(param);
            return groupService.getAllGroups(param);
        }   catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    /**
     * create a group
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping("/createGroup.do")
    public String createGroup (@RequestParam Map<String, Object>  param, HttpSession session,Map<String, Object> map) throws Exception {
        System.out.println("Request successful. Post param : list - " + param);
        String groupName = param.get("groupName").toString();
        int subjectId = Integer.parseInt(param.get("subjectId").toString());
        int userId= (int) session.getAttribute("userId");
        try {
            Integer groupID=groupService.createGroup(groupName,subjectId,userId);
            if(groupID==null){
                map.put("msg","you already have a group");
            }else{
                session.setAttribute("groupid", groupID);
            }
            return "groups";
        }   catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }


    /**
     * create a group
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping("/joinGroup.do")
    public String joinGroup (@RequestParam("groupId") String groupId, HttpSession session,Map<String, Object> map) throws Exception {
        System.out.println("Request successful. Get param : list - " + groupId);
        int groupID = Integer.parseInt(groupId);
        int userId= (int) session.getAttribute("userId");
        try {
            if(!groupService.joinGroup(groupID,userId)){
                map.put("msg","you already have a group");
            }else{
                session.setAttribute("groupid", groupID);
            }
            return "groups";
        }   catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    /**
     * enter a group
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping("/groupPage.do")
    public String groupPage ( HttpSession session,Map<String, Object> map,@PathVariable String param) throws Exception {
        int userId= (int) session.getAttribute("userId");
        try {
            Group group=groupService.enterGroup(userId);
            if(group==null){
                map.put("msg","you don\'t have a group");
                return "groups";
            }

            return "groups";
        }   catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

}

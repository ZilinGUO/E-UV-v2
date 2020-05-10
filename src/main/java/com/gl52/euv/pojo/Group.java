package com.gl52.euv.pojo;

import java.io.Serializable;

public class Group implements Serializable {
    private Integer groupid;

    private String groupname;

    private Integer projectmanager;

    private Integer subjectid;

    private static final long serialVersionUID = 1L;

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public Integer getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(Integer projectmanager) {
        this.projectmanager = projectmanager;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }
}
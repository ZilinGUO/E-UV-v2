package com.gl52.euv.service;

import com.gl52.euv.pojo.Project;
import com.gl52.euv.pojo.Subject;

import java.util.List;
import java.util.Map;

public interface ProjectService {
     Map<String,Object> getAllSubjects(Map<String, Object> param);
     List<Subject> getAllSubjectsName();
     int createSubject(String subjectName,String description,int min,int max);
     Subject getSubjectById(int subjectId);
}

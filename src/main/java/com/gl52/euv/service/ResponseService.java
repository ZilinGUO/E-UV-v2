package com.gl52.euv.service;

import com.gl52.euv.pojo.Evaluation;
import com.gl52.euv.pojo.Response;

import java.util.List;
import java.util.Map;

public interface ResponseService {
    List<Map<String, Object>> getResponseByEvaluationId(int eid);
    Evaluation getEvaluationByEid(int eid);
    boolean createResponse(int eid,int userId,String content);
}

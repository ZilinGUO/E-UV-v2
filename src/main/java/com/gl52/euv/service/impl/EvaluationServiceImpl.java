package com.gl52.euv.service.impl;

import com.gl52.euv.mapper.EvaluationMapper;
import com.gl52.euv.pojo.Evaluation;
import com.gl52.euv.pojo.EvaluationExample;
import com.gl52.euv.pojo.Response;
import com.gl52.euv.service.EvaluationService;
import com.gl52.euv.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationMapper evaluationMapper ;

    @Autowired
    private ResponseService responseService;
    @Override
    public boolean createEvaluation(String etitle, String edescp, int eduration, String econtent) {
        Evaluation evaluation= new Evaluation();
        evaluation.setEtitle(etitle);
        evaluation.setEdesp(edescp);
        evaluation.setEduration(eduration);
        evaluation.setEcontent(econtent);
        evaluation.setEcreated(new Date());
        evaluation.setEvaild(true);
        if(evaluationMapper.insertSelective(evaluation)!=1){
            return false;
        }
        return true;
    }

    @Override
    public List<Evaluation> getAllEvaluation() {
        EvaluationExample example=new EvaluationExample();
        return evaluationMapper.selectByExample(example);
    }

    @Override
    public HashMap getAnEvaluationAndReponse(int eid) {
        Evaluation evaluation= evaluationMapper.selectByPrimaryKey(eid);
        List<Map<String, Object>> responses=responseService.getResponseByEvaluationId(eid);
        HashMap hashMap=new HashMap<String,Object>();
        hashMap.put("evaluation",evaluation);
        hashMap.put("responses",responses);
        return hashMap;
    }
    @Transactional
    @Override
    public List<Evaluation> upateAndfindAllEvaluation() {
        List<Evaluation> evaluations=getAllEvaluation();
        for(Evaluation evaluation:evaluations){
            if(evaluation.getEvaild()) {
                if (!testState(evaluation.getEcreated(), evaluation.getEduration())) {
                    evaluation.setEvaild(false);
                    evaluationMapper.updateByPrimaryKeySelective(evaluation);
                }
            }
        }
        return evaluations;
    }

    @Override
    public Boolean testState(Date createTime, int duration) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        Date currentTime=new Date();
        long diff = currentTime.getTime() - createTime.getTime();
        long day = diff / nd;
        long hour = diff % nd / nh+ day * 24;
        if(hour>duration)return false;
        return true;
    }

    @Override
    public Evaluation getEvaluationById(int id) {
        return evaluationMapper.selectByPrimaryKey(id);
    }


}

package com.gl52.euv.service;

import com.gl52.euv.pojo.Evaluation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface EvaluationService {
    boolean createEvaluation(String etitle, String edescp, Date eduration, String econtent);

    List<Evaluation> getAllEvaluation();

    HashMap getAnEvaluationAndReponse(int eid);

    List<Evaluation> upateAndfindAllEvaluation();

    Boolean testState(Date duration);

    Evaluation getEvaluationById(int id);
}

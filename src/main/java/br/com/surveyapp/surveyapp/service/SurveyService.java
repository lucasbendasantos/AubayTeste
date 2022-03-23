package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import br.com.surveyapp.surveyapp.model.survey.Survey;
import br.com.surveyapp.surveyapp.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {

  @Autowired
  SurveyRepository repository;

  public Survey insert(Survey survey) {
    return repository.save(survey._getSurveyDAO())._getSurveyDTO();
  }

  public Survey update(Survey survey) {
    return repository.insert(survey._getSurveyDAO())._getSurveyDTO();
  }

  public List<Survey> listAll(){
    List<SurveyDAO> listDAO = repository.findAll();
    List<Survey> listDTO = new ArrayList<>();

    listDAO.stream().forEach(item -> listDTO.add(item._getSurveyDTO()));

    return listDTO;
  }


}

package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.model.Survey;
import br.com.surveyapp.surveyapp.repository.SurveyRepository;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

  SurveyRepository repository;

  public Survey insert(Survey survey){
    return repository.insert(survey.getSurveyDAO()).getSurveyDTO();
  }

  public Survey update(Survey survey){
    return repository.insert(survey.getSurveyDAO()).getSurveyDTO();
  }



}

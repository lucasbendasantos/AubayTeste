package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import br.com.surveyapp.surveyapp.model.coodinator.Coordinator;
import br.com.surveyapp.surveyapp.model.survey.Answer;
import br.com.surveyapp.surveyapp.model.survey.Question;
import br.com.surveyapp.surveyapp.model.survey.Survey;
import br.com.surveyapp.surveyapp.repository.SurveyRepository;
import br.com.surveyapp.surveyapp.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SurveyService {

  @Autowired
  SurveyRepository repository;

  @Autowired
  CoordinatorService coordinatorService;

  public Survey insert(Survey survey) throws Exception {

    Coordinator coordinator = coordinatorService.findByDocument(survey.getCoordinator().getDocument());
    if (coordinator == null) {
      throw new Exception("No coordinator found with the document: " + survey.getCoordinator().getDocument());
    }
    survey.setCoordinator(coordinator);
    ValidateUtils.validateSurvey(survey);

    return repository.save(survey._getSurveyDAO())._getSurveyDTO();
  }

  public Survey update(Survey survey) {
    return repository.insert(survey._getSurveyDAO())._getSurveyDTO();
  }

  public List<Survey> listAll() {
    List<SurveyDAO> listDAO = repository.findAll();
    List<Survey> listDTO = new ArrayList<>();

    listDAO.stream().forEach(item -> listDTO.add(item._getSurveyDTO()));

    return listDTO;
  }

  public List<Survey> listByTitle(String title) {
    List<SurveyDAO> listDAO = repository.findByTitle(title);
    List<Survey> listDTO = new ArrayList<>();

    listDAO.stream().forEach(item -> listDTO.add(item._getSurveyDTO()));
    return listDTO;
  }

  public Survey changeStatusSurvey(String documentCoordinator, String idSurvey, char status) throws Exception {
    Coordinator coordinator = coordinatorService.findByDocument(documentCoordinator);
    if (coordinator == null) {
      throw new Exception("No coordinator found with the document: " + documentCoordinator);
    }

    SurveyDAO surveyDao = repository.findById(idSurvey).get();

    if (surveyDao == null) {
      throw new Exception("no survey found with this id: " + idSurvey);
    }

    surveyDao.setStatus(status);
    repository.save(surveyDao);
    return repository.save(surveyDao)._getSurveyDTO();
  }

}

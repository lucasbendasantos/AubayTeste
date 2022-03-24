package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.respondent.RespondentDAO;
import br.com.surveyapp.surveyapp.model.respondent.Respondent;
import br.com.surveyapp.surveyapp.model.survey.Survey;
import br.com.surveyapp.surveyapp.repository.RespondentRepository;
import br.com.surveyapp.surveyapp.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RespondentService {

  @Autowired
  private RespondentRepository repository;

  public Respondent insert(Respondent respondent) {
    try {
      return repository.save(respondent._getRespodentEntity())._getRespondentDto();
    } catch (
      DuplicateKeyException duplicateKeyException) {
      throw duplicateKeyException;
    }

  }

  public Respondent answerSurvey(Survey survey, String document) throws Exception {
    ValidateUtils.validateSurvey(survey);
    Respondent respondent = findByDocument(document);
    if (respondent == null) {
      throw new Exception("no respondents found with the document: " + document);
    }
    checkAnswered(survey, respondent);
    Set<Survey> listSurveysRespondent = new HashSet<>();
    if (respondent.getSurveysAnswered() != null) {
      listSurveysRespondent = respondent.getSurveysAnswered();
    }
    listSurveysRespondent.add(survey);

    respondent.setSurveysAnswered(listSurveysRespondent);

    return repository.save(respondent._getRespodentEntity())._getRespondentDto();
  }

  public Respondent update(Respondent respondent) {
    return repository.insert((respondent._getRespodentEntity()))._getRespondentDto();
  }

  public Respondent findByDocument(String document) {
    Optional<RespondentDAO> optional = repository.findByDocument(document);
    if (optional.isPresent()){
      return optional.get()._getRespondentDto();
    }
    return null;
  }

  public List<Respondent> listAll() {
    List<RespondentDAO> listDAO = repository.findAll();
    List<Respondent> list = new ArrayList<>();

    listDAO.stream().forEach(item -> list.add(item._getRespondentDto()));

    return list;
  }

  private void checkAnswered(Survey survey, Respondent respondent) throws Exception {
    if (respondent.getSurveysAnswered() != null) {
      List<Survey> filteredAnswer = respondent.getSurveysAnswered().stream().filter(item -> item.getId().equals(survey.getId())).collect(Collectors.toList());
      if (!filteredAnswer.isEmpty()) {
        throw new Exception("this survey has already been answered");
      }
    }
  }
}

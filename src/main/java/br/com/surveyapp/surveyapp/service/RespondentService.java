package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.respondent.RespondentDAO;
import br.com.surveyapp.surveyapp.model.respondent.Respondent;
import br.com.surveyapp.surveyapp.model.survey.Answer;
import br.com.surveyapp.surveyapp.repository.RespondentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

  public Respondent update(Respondent respondent) {
    return repository.insert((respondent._getRespodentEntity()))._getRespondentDto();
  }

  public Respondent findByDocument(String document) {
    return repository.findByDocument(document)._getRespondentDto();
  }

  public List<Respondent> listAll() {
    List<RespondentDAO> listDAO = repository.findAll();
    List<Respondent> list = new ArrayList<>();

    listDAO.stream().forEach(item -> list.add(item._getRespondentDto()));

    return list;
  }
}

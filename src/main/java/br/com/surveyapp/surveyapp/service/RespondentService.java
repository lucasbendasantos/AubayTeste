package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.respondent.RespondentDAO;
import br.com.surveyapp.surveyapp.model.respondent.Respondent;
import br.com.surveyapp.surveyapp.repository.RespondentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RespondentService {

  @Autowired
  private RespondentRepository repository;

  public Respondent insert(Respondent respondent) {
    return repository.save(respondent.getRespodentEntity()).getRespondentDto();
  }

  public Respondent update(Respondent respondent) {
    return repository.insert((respondent.getRespodentEntity())).getRespondentDto();
  }

  public Respondent findByDocument(String document) {
    return repository.findByDocument(document).getRespondentDto();
  }

  public List<Respondent> listAll(){
    List<RespondentDAO> listDAO = repository.findAll();
    List<Respondent> list = new ArrayList<>();

    listDAO.stream().forEach(item -> list.add(item.getRespondentDto()));

    return list;
  }

}

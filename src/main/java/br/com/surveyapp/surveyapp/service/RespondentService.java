package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.respondent.RespondentDAO;
import br.com.surveyapp.surveyapp.model.respondent.Respondent;
import br.com.surveyapp.surveyapp.model.survey.Answer;
import br.com.surveyapp.surveyapp.repository.RespondentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    return repository.save(respondent._getRespodentEntity())._getRespondentDto();
  }

  public Respondent update(Respondent respondent) {
    return repository.insert((respondent._getRespodentEntity()))._getRespondentDto();
  }

  public Respondent findByDocument(String document) {
    return repository.findByDocument(document)._getRespondentDto();
  }

  public List<Respondent> listAll(){
    List<RespondentDAO> listDAO = repository.findAll();
    List<Respondent> list = new ArrayList<>();

    listDAO.stream().forEach(item -> list.add(item._getRespondentDto()));

    return list;
  }

  private void validateAnswer(Set<Answer> answers) throws Exception {

    List<Answer> filteredAnswer = answers.stream()
      .filter(item -> item.isChecked() == true)
      .collect(Collectors.toList());

    if(filteredAnswer.size() != 1){
      throw new Exception("The answer to the question should be an answer only");
    }
  }

}

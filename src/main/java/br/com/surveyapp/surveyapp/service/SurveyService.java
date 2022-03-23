package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import br.com.surveyapp.surveyapp.model.coodinator.Coordinator;
import br.com.surveyapp.surveyapp.model.survey.Answer;
import br.com.surveyapp.surveyapp.model.survey.Question;
import br.com.surveyapp.surveyapp.model.survey.Survey;
import br.com.surveyapp.surveyapp.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SurveyService {

  @Autowired
  SurveyRepository repository;

  @Autowired
  CoordinatorService coordinatorService;

  public Survey insert(Survey survey) throws Exception {

    Coordinator coordinator = coordinatorService.findByDocument(survey.getCoordinator().getDocument());
    survey.setCoordinator(coordinator);
    validateSurvey(survey);

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

  private void validateSurvey(Survey survey) throws Exception {

    if(survey.getQuestions().size() < 1){
      throw new Exception("The survey must have at least one question");
    }

    if(survey.getQuestions().size() > 10){
      throw new Exception("Limit of questions in a survey is 10");
    }

    validateQuestions(survey.getQuestions());

  }

  private void validateQuestions(Set<Question> questions) throws Exception {
    for (Question question : questions){

      if(question.getAnswers().size() < 1){
        throw new Exception("The question must have at least one answer");
      }

      if(question.getAnswers().size() > 5){
        throw new Exception("The question must have a maximum of 5 alternatives");
      }

      if(!question.isMultipleChoice()){
        validateAnswer(question.getAnswers());
      }
    }
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

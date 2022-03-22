package br.com.surveyapp.surveyapp.dao.survey;

import br.com.surveyapp.surveyapp.dao.coordinators.CoordinatorDAO;
import br.com.surveyapp.surveyapp.model.Question;
import br.com.surveyapp.surveyapp.model.Survey;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class SurveyDAO {

  @Id
  private int id;

  private String title;
  private char status;
  private CoordinatorDAO coordinator;
  private Set<QuestionDAO> questions;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
  }

  public CoordinatorDAO getCoordinator() {
    return coordinator;
  }

  public void setCoordinator(CoordinatorDAO coordinator) {
    this.coordinator = coordinator;
  }

  public Set<QuestionDAO> getQuestions() {
    return questions;
  }

  public void setQuestions(Set<QuestionDAO> questions) {
    this.questions = questions;
  }

  public Survey getSurveyDTO(){
    Survey survey = new Survey();
    Set<Question> listQuetions = new HashSet<>();

    survey.setId(this.id);
    survey.setTitle(this.title);
    survey.setStatus(this.status);
    survey.setCoordinator(this.coordinator.getCoodinatorDTO());

    this.questions.stream().forEach(item -> listQuetions.add(item.getQuestionDTO()));
    survey.setQuestions(listQuetions);

    return survey;

  }
}

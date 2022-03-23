package br.com.surveyapp.surveyapp.model.survey;

import br.com.surveyapp.surveyapp.dao.survey.QuestionDAO;
import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import br.com.surveyapp.surveyapp.model.coodinator.Coordinator;

import java.util.HashSet;
import java.util.Set;

public class Survey {

  private String id;
  private String title;
  private char status;
  private Coordinator coordinator;
  private Set<Question> questions;

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public Coordinator getCoordinator() {
    return coordinator;
  }

  public void setCoordinator(Coordinator coordinator) {
    this.coordinator = coordinator;
  }

  public Set<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(Set<Question> questions) {
    this.questions = questions;
  }

  public SurveyDAO _getSurveyDAO(){
    SurveyDAO surveyDAO = new SurveyDAO();
    Set<QuestionDAO> listQuestionDAO = new HashSet<>();

    surveyDAO.setId(this.getId());
    surveyDAO.setTitle(this.title);
    surveyDAO.setStatus(this.status);
    surveyDAO.setCoordinator(this.coordinator._getCoodinatorEntity());

    this.questions.stream().forEach(item -> listQuestionDAO.add(item._getQuestionDAO()));

    surveyDAO.setQuestions(listQuestionDAO);
    return surveyDAO;

  }
}

package br.com.surveyapp.surveyapp.dao.survey;

import br.com.surveyapp.surveyapp.dao.coordinator.CoordinatorDAO;
import br.com.surveyapp.surveyapp.model.survey.Question;
import br.com.surveyapp.surveyapp.model.survey.Survey;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "survey")
public class SurveyDAO {

  @Id
  @Field("_id")
  private String id;

  private String title;
  private char status;
  private CoordinatorDAO coordinator;
  private Set<QuestionDAO> questions;

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

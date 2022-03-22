package br.com.surveyapp.surveyapp.dao.respondents;

import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import org.springframework.data.annotation.Id;

import java.util.Set;

public class RespondentDAO {

  @Id()
  private int id;

  private String name;
  private String document;
  private String email;

  private Set<SurveyDAO> surveysAnswered;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<SurveyDAO> getSurveysAnswered() {
    return surveysAnswered;
  }

  public void setSurveysAnswered(Set<SurveyDAO> surveysAnswered) {
    this.surveysAnswered = surveysAnswered;
  }
}

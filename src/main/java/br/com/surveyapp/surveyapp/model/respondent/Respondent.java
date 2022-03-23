package br.com.surveyapp.surveyapp.model.respondent;

import br.com.surveyapp.surveyapp.dao.respondent.RespondentDAO;
import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import br.com.surveyapp.surveyapp.model.survey.Survey;

import java.util.HashSet;
import java.util.Set;

public class Respondent {
  private String id;

  private String name;
  private String document;
  private String email;
  private Set<Survey> surveysAnswered;

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public Set<Survey> getSurveysAnswered() {
    return surveysAnswered;
  }

  public void setSurveysAnswered(Set<Survey> surveysAnswered) {
    this.surveysAnswered = surveysAnswered;
  }

  public RespondentDAO _getRespodentEntity(){
    RespondentDAO respondentDAO = new RespondentDAO();
    Set<SurveyDAO> listSurveyDAO = new HashSet<>();

    respondentDAO.setId(this.getId());
    respondentDAO.setName(this.getName());
    respondentDAO.setDocument(this.getDocument());
    respondentDAO.setEmail(this.getEmail());

    this.surveysAnswered.stream().forEach(item -> listSurveyDAO.add(item._getSurveyDAO()));
    respondentDAO.setSurveysAnswered(listSurveyDAO);

    return respondentDAO;
  }
}

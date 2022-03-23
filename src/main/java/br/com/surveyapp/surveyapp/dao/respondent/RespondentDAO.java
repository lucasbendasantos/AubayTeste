package br.com.surveyapp.surveyapp.dao.respondent;

import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import br.com.surveyapp.surveyapp.model.respondent.Respondent;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Data
@Document(collection = "respondent")
public class RespondentDAO {

  @Id
  @Field("_id")
  private String id;

  private String name;
  private String document;
  private String email;

  private Set<SurveyDAO> surveysAnswered;

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

  public Set<SurveyDAO> getSurveysAnswered() {
    return surveysAnswered;
  }

  public void setSurveysAnswered(Set<SurveyDAO> surveysAnswered) {
    this.surveysAnswered = surveysAnswered;
  }

  public Respondent _getRespondentDto(){
    Respondent respondent = new Respondent();

    respondent.setId(this.id);
    respondent.setName(this.name);
    respondent.setDocument(this.document);
    respondent.setEmail(this.email);

    return respondent;
  }
}

package br.com.surveyapp.surveyapp.model.respondent;

import br.com.surveyapp.surveyapp.dao.respondent.RespondentDAO;

public class Respondent {
  private String id;

  private String name;
  private String document;
  private String email;

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

  public RespondentDAO getRespodentEntity(){
    RespondentDAO respondentDAO = new RespondentDAO();

    respondentDAO.setId(this.getId());
    respondentDAO.setName(this.getName());
    respondentDAO.setDocument(this.getDocument());
    respondentDAO.setEmail(this.getEmail());

    return respondentDAO;
  }
}

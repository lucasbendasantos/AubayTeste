package br.com.surveyapp.surveyapp.model;

import br.com.surveyapp.surveyapp.dao.respondents.RespondentDAO;

public class Respondent {
  private int id;

  private String name;
  private String document;
  private String email;

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

  public RespondentDAO getRespodentEntity(){
    RespondentDAO respondentDAO = new RespondentDAO();

    respondentDAO.setId(this.getId());
    respondentDAO.setName(this.getName());
    respondentDAO.setDocument(this.getDocument());
    respondentDAO.setEmail(this.getEmail());

    return respondentDAO;
  }
}

package br.com.surveyapp.surveyapp.model;

import br.com.surveyapp.surveyapp.dao.coordinators.CoordinatorDAO;

public class Coordinator {
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

  public CoordinatorDAO getCoodinatorEntity(){
    CoordinatorDAO coordinatorDAO = new CoordinatorDAO();

    coordinatorDAO.setId(this.getId());
    coordinatorDAO.setName(this.getName());
    coordinatorDAO.setDocument(this.getDocument());
    coordinatorDAO.setEmail(this.getEmail());

    return coordinatorDAO;
  }
}

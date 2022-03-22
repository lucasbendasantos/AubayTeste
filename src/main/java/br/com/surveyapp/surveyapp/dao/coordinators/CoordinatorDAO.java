package br.com.surveyapp.surveyapp.dao.coordinators;

import br.com.surveyapp.surveyapp.model.Coordinator;
import org.springframework.data.annotation.Id;

public class CoordinatorDAO {
  @Id()
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

  public Coordinator getCoodinatorDTO(){
    Coordinator coordinator = new Coordinator();

    coordinator.setId(this.getId());
    coordinator.setName(this.getName());
    coordinator.setDocument(this.getDocument());
    coordinator.setEmail(this.getEmail());

    return coordinator;
  }
}

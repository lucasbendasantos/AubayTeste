package br.com.surveyapp.surveyapp.dao.coordinator;

import br.com.surveyapp.surveyapp.model.coodinator.Coordinator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coordinator")
public class CoordinatorDAO {

  @Id
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

  public Coordinator _getCoodinatorDTO(){
    Coordinator coordinator = new Coordinator();

    coordinator.setId(this.getId());
    coordinator.setName(this.getName());
    coordinator.setDocument(this.getDocument());
    coordinator.setEmail(this.getEmail());

    return coordinator;
  }
}

package br.com.surveyapp.surveyapp.repository;

import br.com.surveyapp.surveyapp.dao.coordinator.CoordinatorDAO;
import br.com.surveyapp.surveyapp.model.coodinator.Coordinator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatorRepository extends MongoRepository<CoordinatorDAO, String> {

  @Query(value="{ 'document' : ?0 }")
  Coordinator findByDocument(String document);
}

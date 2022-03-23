package br.com.surveyapp.surveyapp.repository;

import br.com.surveyapp.surveyapp.dao.respondent.RespondentDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RespondentRepository extends MongoRepository<RespondentDAO, String> {

  @Query(value="{ 'document' : ?0 }")
  RespondentDAO findByDocument(String document);

}

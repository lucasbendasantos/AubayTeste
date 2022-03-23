package br.com.surveyapp.surveyapp.repository;

import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends MongoRepository<SurveyDAO, String> {

  @Query(value="{ 'title' : ?0 }")
  List<SurveyDAO> findByTitle(String document);

  @Query("{ '_id' : ObjectId(?0) }")
  Optional<SurveyDAO> findById(String id);

}

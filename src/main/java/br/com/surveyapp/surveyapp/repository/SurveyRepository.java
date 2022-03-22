package br.com.surveyapp.surveyapp.repository;

import br.com.surveyapp.surveyapp.dao.survey.SurveyDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends MongoRepository<SurveyDAO, String> {
}

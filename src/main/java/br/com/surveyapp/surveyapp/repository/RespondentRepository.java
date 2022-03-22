package br.com.surveyapp.surveyapp.repository;

import br.com.surveyapp.surveyapp.dao.respondents.RespondentDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespondentRepository extends MongoRepository<RespondentDAO, String> {
}

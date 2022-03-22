package br.com.surveyapp.surveyapp.repository;

import br.com.surveyapp.surveyapp.dao.coordinators.CoordinatorDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatorRepository extends MongoRepository<CoordinatorDAO, String> {
}

package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.coordinators.CoordinatorDAO;
import br.com.surveyapp.surveyapp.model.Coordinator;
import br.com.surveyapp.surveyapp.repository.CoordinatorRepository;
import org.springframework.stereotype.Service;

@Service
public class CoordinatorService {

  private CoordinatorRepository repository;

  public Coordinator insert(Coordinator coordinator){
    return repository.insert(coordinator.getCoodinatorEntity()).getCoodinatorDTO();
  }

}

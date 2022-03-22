package br.com.surveyapp.surveyapp.service;

import br.com.surveyapp.surveyapp.dao.coordinators.CoordinatorDAO;
import br.com.surveyapp.surveyapp.model.Coordinator;
import br.com.surveyapp.surveyapp.repository.CoordinatorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoordinatorService {

  private CoordinatorRepository repository;

  public Coordinator insert(Coordinator coordinator){
    return repository.insert(coordinator.getCoodinatorEntity()).getCoodinatorDTO();
  }

  public Coordinator update (Coordinator coordinator){
    return repository.insert(coordinator.getCoodinatorEntity()).getCoodinatorDTO();
  }

  public Coordinator findByDocument(String document){
    return repository.findByDocument(document);
  }

  public List<Coordinator> listAll(){
    List<CoordinatorDAO> listDAO = repository.findAll();
    List<Coordinator> list = new ArrayList<>();

    listDAO.stream().forEach(item -> list.add(item.getCoodinatorDTO()));

    return list;

  }
}

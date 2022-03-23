package br.com.surveyapp.surveyapp.controller;

import br.com.surveyapp.surveyapp.model.coodinator.Coordinator;
import br.com.surveyapp.surveyapp.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/coordinator")
public class CoordinatorController {

  @Autowired
  CoordinatorService service;

  @PostMapping
  public ResponseEntity<Coordinator> insert(@RequestBody Coordinator coordinator){
    return ResponseEntity.ok(service.insert(coordinator));
  }

  @GetMapping
  public ResponseEntity<List<Coordinator>> listAll(){
    return ResponseEntity.ok(service.listAll());
  }

  @PutMapping
  public ResponseEntity<Coordinator> update(@RequestBody Coordinator coordinator) {
    return ResponseEntity.ok(service.update(coordinator));
  }
}

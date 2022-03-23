package br.com.surveyapp.surveyapp.controller;

import br.com.surveyapp.surveyapp.model.respondent.Respondent;
import br.com.surveyapp.surveyapp.service.RespondentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/respondent")
public class RespondentController {

  @Autowired
  RespondentService service;

  @PostMapping
  public ResponseEntity<Respondent> insert(@RequestBody Respondent respondent){
    return ResponseEntity.ok(service.insert(respondent));
  }

  @GetMapping
  public ResponseEntity<List<Respondent>> listAll(){
    return ResponseEntity.ok(service.listAll());
  }

  @PutMapping
  public ResponseEntity<Respondent> update(@RequestBody Respondent respondent){
    return ResponseEntity.ok(service.update(respondent));
  }
}

package br.com.surveyapp.surveyapp.controller;

import br.com.surveyapp.surveyapp.model.respondent.Respondent;
import br.com.surveyapp.surveyapp.model.survey.Survey;
import br.com.surveyapp.surveyapp.service.RespondentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/respondent")
public class RespondentController {

  @Autowired
  RespondentService service;

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody Respondent respondent) {
    try {
      return ResponseEntity.ok(service.insert(respondent));
    } catch (
      DuplicateKeyException duplicateKeyException) {
      return ResponseEntity.unprocessableEntity().body("There is already a respondent registered with this document");
    }
  }

  @PostMapping("/answerSurvey")
  public ResponseEntity<?> answerSurvey(@RequestParam String documentRespondent, @RequestBody Survey survey){
    try {
      return ResponseEntity.ok(service.answerSurvey(survey, documentRespondent));
    }catch (Exception e){
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<List<Respondent>> listAll() {
    return ResponseEntity.ok(service.listAll());
  }

  @PutMapping
  public ResponseEntity<Respondent> update(@RequestBody Respondent respondent) {
    return ResponseEntity.ok(service.update(respondent));
  }
}

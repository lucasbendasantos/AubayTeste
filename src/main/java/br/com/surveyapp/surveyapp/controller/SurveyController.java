package br.com.surveyapp.surveyapp.controller;

import br.com.surveyapp.surveyapp.model.survey.Survey;
import br.com.surveyapp.surveyapp.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/survey")
public class SurveyController {

  @Autowired
  SurveyService service;

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody Survey survey) {
    try {
      return ResponseEntity.ok(service.insert(survey));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<List<Survey>> listAll() {
    return ResponseEntity.ok(service.listAll());
  }

  @GetMapping("/title")
  public ResponseEntity<List<Survey>> listByTitle(@RequestParam String title) {
    return ResponseEntity.ok(service.listByTitle(title));
  }

  @PostMapping("/close")
  public ResponseEntity<?> closeSurvey(@RequestParam String documentCoordinator, @RequestParam String idSurvey) {
    try {
      return ResponseEntity.ok(service.changeStatusSurvey(documentCoordinator, idSurvey, 'C'));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @PostMapping("/Active")
  public ResponseEntity<?> activeSurvey(@RequestParam String documentCoordinator, @RequestParam String idSurvey) {
    try {
      return ResponseEntity.ok(service.changeStatusSurvey(documentCoordinator, idSurvey, 'A'));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

}

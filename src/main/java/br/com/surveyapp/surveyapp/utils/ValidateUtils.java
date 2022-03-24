package br.com.surveyapp.surveyapp.utils;

import br.com.surveyapp.surveyapp.model.survey.Answer;
import br.com.surveyapp.surveyapp.model.survey.Question;
import br.com.surveyapp.surveyapp.model.survey.Survey;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidateUtils {
  public static void validateSurvey(Survey survey) throws Exception {

    if (survey.getQuestions().size() < 1) {
      throw new Exception("The survey must have at least one question");
    }

    if (survey.getQuestions().size() > 10) {
      throw new Exception("Limit of questions in a survey is 10");
    }

    validateQuestions(survey.getQuestions());

  }

  private static void validateQuestions(Set<Question> questions) throws Exception {
    for (Question question : questions) {

      if (question.getAnswers().size() < 1) {
        throw new Exception("The question must have at least one answer");
      }

      if (question.getAnswers().size() > 5) {
        throw new Exception("The question must have a maximum of 5 alternatives");
      }

      if (!question.isMultipleChoice()) {
        validateAnswer(question.getAnswers());
      }
    }
  }

  private static void validateAnswer(Set<Answer> answers) throws Exception {

    List<Answer> filteredAnswer = answers.stream()
      .filter(item -> item.isChecked() == true)
      .collect(Collectors.toList());

    if (filteredAnswer.size() != 1) {
      throw new Exception("The answer to the question should be an answer only");
    }
  }
}

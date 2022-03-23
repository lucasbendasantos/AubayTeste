package br.com.surveyapp.surveyapp.model.survey;

import br.com.surveyapp.surveyapp.dao.survey.AnswerDAO;
import br.com.surveyapp.surveyapp.dao.survey.QuestionDAO;

import java.util.HashSet;
import java.util.Set;

public class Question {

  private int numberQuestion;
  private String description;
  private boolean multipleChoice;
  private Set<Answer> answers;

  public int getNumberQuestion() {
    return numberQuestion;
  }

  public void setNumberQuestion(int numberQuestion) {
    this.numberQuestion = numberQuestion;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isMultipleChoice() {
    return multipleChoice;
  }

  public void setMultipleChoice(boolean multipleChoice) {
    this.multipleChoice = multipleChoice;
  }

  public Set<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(Set<Answer> answers) {
    this.answers = answers;
  }

  public QuestionDAO getQuestionDAO(){
    QuestionDAO questionDAO = new QuestionDAO();
    Set<AnswerDAO> listAnswerDAO = new HashSet<>();

    questionDAO.setNumberQuestion(this.numberQuestion);
    questionDAO.setDescription(this.description);
    questionDAO.setMultipleChoice(this.multipleChoice);

    this.answers.stream().forEach(item -> listAnswerDAO.add(item.getAnswerDAO()));
    questionDAO.setAnswers(listAnswerDAO);

    return questionDAO;
  }
}

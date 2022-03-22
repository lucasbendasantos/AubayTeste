package br.com.surveyapp.surveyapp.dao.survey;

import java.util.Set;

public class QuestionDAO {

  private int numberQuestion;
  private String description;
  private boolean multipleChoice;
  private Set<AnswerDAO> answers;

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

  public Set<AnswerDAO> getAnswers() {
    return answers;
  }

  public void setAnswers(Set<AnswerDAO> answers) {
    this.answers = answers;
  }
}

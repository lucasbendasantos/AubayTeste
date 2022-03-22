package br.com.surveyapp.surveyapp.dao.survey;

import br.com.surveyapp.surveyapp.model.Answer;
import br.com.surveyapp.surveyapp.model.Question;

import java.util.HashSet;
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

  public Question getQuestionDTO(){
    Question question = new Question();
    Set<Answer> listAnswer = new HashSet<>();

    question.setNumberQuestion(this.numberQuestion);
    question.setDescription(this.description);
    question.setMultipleChoice(this.multipleChoice);

    this.answers.stream().forEach(item -> listAnswer.add(item.getAnswerDTO()));
    question.setAnswers(listAnswer);

    return question;

  }
}

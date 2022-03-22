package br.com.surveyapp.surveyapp.model;

import br.com.surveyapp.surveyapp.dao.survey.AnswerDAO;

public class Answer {

  private char option;
  private String description;
  private boolean checked;

  public char getOption() {
    return option;
  }

  public void setOption(char option) {
    this.option = option;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public AnswerDAO getAnswerDAO(){
    AnswerDAO answerDAO = new AnswerDAO();
    answerDAO.setOption(this.option);
    answerDAO.setDescription(this.description);
    answerDAO.setChecked(this.checked);

    return answerDAO;
  }
}

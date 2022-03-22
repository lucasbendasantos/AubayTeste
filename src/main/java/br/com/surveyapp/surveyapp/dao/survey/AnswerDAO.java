package br.com.surveyapp.surveyapp.dao.survey;

public class AnswerDAO {

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
}

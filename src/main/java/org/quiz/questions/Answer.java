package org.quiz.questions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Answer {

  String player;
  boolean correctAnswer;
  int points;
}

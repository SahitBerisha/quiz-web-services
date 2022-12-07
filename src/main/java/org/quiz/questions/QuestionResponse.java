package org.quiz.questions;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionResponse {

  String question;
  int points;
  int duration;
  List<String> answers;
  int correctIndex;
}

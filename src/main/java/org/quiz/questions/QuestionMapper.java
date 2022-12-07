package org.quiz.questions;

import static java.util.concurrent.ThreadLocalRandom.current;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuestionMapper {

  public QuestionResponse map(QuestionRequest request) {
    return QuestionResponse.builder()
        .question(request.question())
        .points(current().nextInt(5, 10))
        .duration(current().nextInt(15, 30))
        .answers(request.answers())
        .correctIndex(request.correctIndex())
        .build();
  }
}

package org.quiz.questions;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.quiz.players.PlayerRepository;

@ApplicationScoped
@RequiredArgsConstructor
public class QuestionService {

  public static final String QUIZ_JSON_FILE = "src/main/resources/quiz.json";
  private final PlayerRepository playerRepository;
  private final QuestionMapper questionMapper;

  @Transactional
  public Answer submit(String playerId, QuestionResponse question, int answerIndex) {
    var player = playerRepository.findById(playerId);
    boolean answer = question.correctIndex == answerIndex;
    if (answer) {
      player.addScore(question.points);
    }
    return Answer.builder()
        .player(player.getUsername())
        .correctAnswer(answer)
        .points(player.getScore())
        .build();
  }

  @Transactional
  public QuestionResponse getQuestion() {
    try {
      var mapper = new ObjectMapper();
      var questions = Arrays.asList(
          mapper.readValue(Paths.get(QUIZ_JSON_FILE).toFile(), QuestionRequest[].class));
      return findRandom(questions, questions.size());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return QuestionResponse.builder().build();
  }

  private QuestionResponse findRandom(List<QuestionRequest> questionsList, int size) {
    var random = ThreadLocalRandom.current().nextInt(size);
    return questionsList.stream()
        .map(questionMapper::map)
        .toList()
        .get(random);
  }
}

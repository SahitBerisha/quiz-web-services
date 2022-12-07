package org.quiz.players;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlayerResponse {

  String id;
  String name;
  Integer score;
}

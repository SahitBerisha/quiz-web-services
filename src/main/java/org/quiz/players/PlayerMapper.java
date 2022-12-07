package org.quiz.players;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerMapper {

  public Player map(PlayerRequest request) {
    var player = new Player();
    player.setUsername(request.name());
    return player;
  }

  public PlayerResponse map(Player player) {
    return PlayerResponse.builder()
        .id(player.getId())
        .name(player.getUsername())
        .score(player.getScore())
        .build();
  }
}

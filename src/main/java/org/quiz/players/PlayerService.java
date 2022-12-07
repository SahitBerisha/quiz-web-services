package org.quiz.players;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepository repository;
  private final PlayerMapper mapper;

  @Transactional
  public PlayerResponse create(PlayerRequest request) {
    var player = mapper.map(request);
    repository.persist(player);
    return mapper.map(player);
  }

  @Transactional
  public List<PlayerResponse> findAll() {
    var players = repository.findAll();
    return players.stream()
        .map(mapper::map)
        .toList();
  }
}

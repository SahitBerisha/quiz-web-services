package org.quiz.players;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PlayerRepository implements PanacheRepositoryBase<Player, String> {

}

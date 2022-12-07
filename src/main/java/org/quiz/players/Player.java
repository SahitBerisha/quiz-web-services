package org.quiz.players;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@NoArgsConstructor
@Table(name = "players")
public class Player implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", nullable = false, updatable = false)
  private String id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "score", nullable = false)
  private Integer score = 0;

  public void addScore(int score) {
    this.score += score;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (isNull(other) || !(getClass().isInstance(other))) {
      return false;
    }
    var entity = (Player) other;
    return nonNull(id) && id.equals(entity.getId());
  }

  @Override
  public int hashCode() {
    return nonNull(id) ? Objects.hashCode(id) : 31;
  }
}

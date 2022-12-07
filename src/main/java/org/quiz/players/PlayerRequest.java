package org.quiz.players;

import javax.validation.constraints.NotBlank;

public record PlayerRequest(@NotBlank String name) {

}

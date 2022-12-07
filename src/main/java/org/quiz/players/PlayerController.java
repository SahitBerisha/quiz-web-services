package org.quiz.players;


import static org.jboss.resteasy.reactive.RestResponse.Status.CREATED;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;

@Slf4j
@ApplicationScoped
@Tag(name = "Player")
@RequiredArgsConstructor
@Path("/api/v1/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerController {

  private final PlayerService service;

  @POST
  @Operation(summary = "Creates a new Player")
  public RestResponse<PlayerResponse> create(@Valid PlayerRequest request) {
    log.debug("REST request to create a Player: {}", request);
    var response = service.create(request);
    return RestResponse.status(CREATED, response);
  }

  @GET
  @Operation(summary = "Returns all Players with their scores")
  public RestResponse<List<PlayerResponse>> getAll() {
    log.debug("REST request to get all Players");
    var response = service.findAll();
    return RestResponse.ok(response);
  }
}

package org.quiz.questions;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;

@Slf4j
@ApplicationScoped
@Tag(name = "Question")
@RequiredArgsConstructor
@Path("/api/v1/questions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionController {

  private final QuestionService service;

  @POST
  @Path("/{playerId}/answer")
  @Operation(summary = "Answers to a Question")
  public RestResponse<Answer> submit(@PathParam("playerId") String playerId,
                                     QuestionResponse question,
                                     @QueryParam("answerIndex") int answerIndex) {
    log.debug("REST request to submit an Answer : {} - {}", question, answerIndex);
    var response = service.submit(playerId, question, answerIndex);
    return RestResponse.ok(response);
  }

  @GET
  @Operation(summary = "Returns a random Question")
  public RestResponse<QuestionResponse> getOne() {
    log.debug("REST request to get a Question");
    var response = service.getQuestion();
    return RestResponse.ok(response);
  }
}

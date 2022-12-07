package org.quiz.questions;


import java.util.List;

public record QuestionRequest(String question,
                              List<String> answers,
                              int correctIndex) {

}

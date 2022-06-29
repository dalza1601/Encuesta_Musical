package com.pe.dalza.Encuesta_Musical.service;

import com.pe.dalza.Encuesta_Musical.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz saveQuiz(Quiz quiz);

    List<Quiz> fetchQuizList();

    Quiz updateQuiz(Quiz quiz, Long quizId);

    void deleteQuiz(Long quizId);
}

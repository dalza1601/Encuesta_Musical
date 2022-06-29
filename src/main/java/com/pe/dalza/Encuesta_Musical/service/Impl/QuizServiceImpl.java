package com.pe.dalza.Encuesta_Musical.service.Impl;

import com.pe.dalza.Encuesta_Musical.entity.Quiz;
import com.pe.dalza.Encuesta_Musical.repository.QuizRepository;
import com.pe.dalza.Encuesta_Musical.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> fetchQuizList() {
        return (List<Quiz>)
                quizRepository.findAll();
    }

    @Override
    public Quiz updateQuiz(Quiz quiz, Long quizId) {
        Quiz depDB
                = quizRepository.findById(quizId)
                .get();

        if (Objects.nonNull(quiz.getEmail())
                && !"".equalsIgnoreCase(
                quiz.getEmail())) {
            depDB.setEmail(
                    quiz.getEmail());
        }

        if (Objects.nonNull(quiz.getTypeMusic())
                && !"".equalsIgnoreCase(
                quiz.getTypeMusic())) {
            depDB.setTypeMusic(
                    quiz.getTypeMusic());
        }



        return quizRepository.save(depDB);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }
}

package com.pe.dalza.Encuesta_Musical;

import com.pe.dalza.Encuesta_Musical.entity.Quiz;
import com.pe.dalza.Encuesta_Musical.repository.QuizRepository;
import com.pe.dalza.Encuesta_Musical.service.Impl.QuizServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuizServiceImplTests {
    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private QuizServiceImpl quizService;



}

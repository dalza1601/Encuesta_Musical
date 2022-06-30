package com.pe.dalza.Encuesta_Musical;

import com.pe.dalza.Encuesta_Musical.entity.Quiz;
import com.pe.dalza.Encuesta_Musical.repository.QuizRepository;
import com.pe.dalza.Encuesta_Musical.service.Impl.QuizServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class QuizServiceImplTests {
    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private QuizServiceImpl quizService;

    @Test
    public void whenSaveQuizThenReturnQuiz() {
        Quiz quiz = new Quiz();
        quiz.setTypeMusic("ROCK");
        quiz.setEmail("dalza@gmail.com");

        Mockito.when(quizRepository.save(ArgumentMatchers.any(Quiz.class))).thenReturn(quiz);
        Quiz created = quizService.saveQuiz(quiz);
        Assertions.assertThat(created.getEmail()).isSameAs(quiz.getEmail());
        Mockito.verify(quizRepository).save(quiz);

    }

    @Test
    public void shouldReturnAllQuiz() {
        List<Quiz> quizes = new ArrayList<>();
        quizes.add(new Quiz());

        BDDMockito.given(quizRepository.findAll()).willReturn(quizes);
        List<Quiz> expected = quizService.fetchQuizList();

        org.junit.jupiter.api.Assertions.assertEquals(expected, quizes);
        Mockito.verify(quizRepository).findAll();
    }

    @Test
    public void whenGivenId_shouldUpdateQuiz_ifFound() {
        Quiz quiz = new Quiz();
        quiz.setEmail("dalzafs@gmail.com");
        quiz.setTypeMusic("ROCK");
        quiz.setQuizId(1L);

        Quiz newQuiz = new Quiz();
        quiz.setTypeMusic("JAZZ");

        BDDMockito.given(quizRepository.findById(quiz.getQuizId())).willReturn(Optional.of(quiz));
        quizService.updateQuiz(newQuiz, quiz.getQuizId());

        Mockito.verify(quizRepository).save(quiz);
        Mockito.verify(quizRepository).findById(quiz.getQuizId());
    }


}

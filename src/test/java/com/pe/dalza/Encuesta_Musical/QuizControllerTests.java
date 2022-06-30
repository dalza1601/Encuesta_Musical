package com.pe.dalza.Encuesta_Musical;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.dalza.Encuesta_Musical.entity.Quiz;
import com.pe.dalza.Encuesta_Musical.service.QuizService;
import com.pe.dalza.Encuesta_Musical.util.JsonUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
public class QuizControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizService quizService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createQuiz_whenPostMethod() throws Exception {

        Quiz quiz = new Quiz();
        quiz.setTypeMusic("ROCK");
        quiz.setEmail("dalza.16524@gmail.com");

        BDDMockito.given(quizService.saveQuiz(quiz)).willReturn(quiz);

        mockMvc.perform(MockMvcRequestBuilders.post("/quiz")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(quiz)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void listAllQuizes_whenGetMethod() throws Exception {

        Quiz quiz = new Quiz();
        quiz.setTypeMusic("ROCK");
        quiz.setEmail("dalza.16524@gmail.com");

        List<Quiz> quizes = Arrays.asList(quiz);

        BDDMockito.given(quizService
                        .fetchQuizList())
                .willReturn(quizes);

        mockMvc.perform(MockMvcRequestBuilders.get("/quiz")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.hasSize(1)));
    }

}

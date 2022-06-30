package com.pe.dalza.Encuesta_Musical;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.dalza.Encuesta_Musical.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class QuizControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizService quizService;

    @Autowired
    private ObjectMapper mapper;



}

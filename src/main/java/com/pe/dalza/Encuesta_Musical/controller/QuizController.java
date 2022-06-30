package com.pe.dalza.Encuesta_Musical.controller;

import com.pe.dalza.Encuesta_Musical.entity.Quiz;
import com.pe.dalza.Encuesta_Musical.service.QuizService;
import com.pe.dalza.Encuesta_Musical.utils.ConstantHelper;
import com.pe.dalza.Encuesta_Musical.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/quiz")
    public ResponseEntity<Object> saveQuiz(@Valid @RequestBody Quiz quiz) {
        try {
            return ResponseHandler.generateResponse(HttpStatus.OK, false, "", quizService.saveQuiz(quiz));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, ConstantHelper.UNIQUE_VALUE, null);
        }
    }

    @GetMapping("/quiz")
    public ResponseEntity<Object> fetchQuizList() {
        try {
            return ResponseHandler.generateResponse(HttpStatus.OK, false, "", quizService.fetchQuizList());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, ConstantHelper.TRY_AGAIN, null);

        }
    }

    @PutMapping("/quiz/{id}")
    public ResponseEntity<Object> updateQuiz(@RequestBody Quiz quiz, @PathVariable("id") Long quizId) {
        try {
            return ResponseHandler.generateResponse(HttpStatus.OK, false, "", quizService.updateQuiz(
                    quiz, quizId));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, ConstantHelper.UNIQUE_VALUE, null);

        }

    }

    @DeleteMapping("/quiz/{id}")
    public ResponseEntity<Object> deleteQuizById(@PathVariable("id") Long quizId) {
        try {
            quizService.deleteQuiz(quizId);
            return ResponseHandler.generateResponse(HttpStatus.OK, false, ConstantHelper.DELETED, null);

        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, ConstantHelper.TRY_AGAIN, null);

        }
    }

}

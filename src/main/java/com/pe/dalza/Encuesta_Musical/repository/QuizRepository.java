package com.pe.dalza.Encuesta_Musical.repository;

import com.pe.dalza.Encuesta_Musical.entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

}

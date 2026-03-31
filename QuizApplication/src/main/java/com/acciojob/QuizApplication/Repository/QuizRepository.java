package com.acciojob.QuizApplication.Repository;

import com.acciojob.QuizApplication.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}

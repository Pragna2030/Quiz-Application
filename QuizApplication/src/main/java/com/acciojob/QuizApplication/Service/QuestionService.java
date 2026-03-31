package com.acciojob.QuizApplication.Service;

import com.acciojob.QuizApplication.Entity.Question;
import com.acciojob.QuizApplication.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Success";
    }
    public List<Question> getQuestionsByCategory( String category){
        return questionRepository.findByCategory(category);
    }
}

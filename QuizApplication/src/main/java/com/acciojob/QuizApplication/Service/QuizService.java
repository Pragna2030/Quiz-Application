package com.acciojob.QuizApplication.Service;

import com.acciojob.QuizApplication.Entity.Question;
import com.acciojob.QuizApplication.Entity.QuestionWrapper;
import com.acciojob.QuizApplication.Entity.Quiz;
import com.acciojob.QuizApplication.Entity.Response;
import com.acciojob.QuizApplication.Repository.QuestionRepository;
import com.acciojob.QuizApplication.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);
        System.out.println("Questions found: " + questions.size());
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions); // important: safe first step
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsFromUser = new ArrayList<>();
        for (Question q : questionFromDb) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(), q.getCategory());
            questionsFromUser.add(qw);

        }
        return new ResponseEntity<>(questionsFromUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        int right = 0;
        for (Response response : responses) {
            for (Question q : questions) {
                if (q.getId().equals(response.getId())) {
                    if (response.getResponse().equals(q.getRightAnswer())) {
                        right++;
                    }
                    break;
                }
            }
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}



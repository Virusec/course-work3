package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        validate(question);
        validate(answer);
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        validateQuestion(question);
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        validateQuestion(question);
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        ArrayList<Question> questionArrayList = new ArrayList<>(questions);
        return questionArrayList.get(random.nextInt(questionArrayList.size()));
    }

    private void validateQuestion(Question question) {
        if (question == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    private void validate(String string) {
        if (string == null || string.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}

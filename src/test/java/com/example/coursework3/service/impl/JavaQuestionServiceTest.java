package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService;
    Set<Question> questions = new HashSet<>();
    Question question1;
    Question question2;
    Question question3;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        question1 = javaQuestionService.add(new Question("q1", "a1"));
        question2 = javaQuestionService.add(new Question("q2", "a2"));
        question3 = javaQuestionService.add(new Question("q3", "a3"));
    }

    @Test
    void addShouldReturnAddedQuestion() {
        Question actual = new Question("q", "a");
        Question expected = javaQuestionService.add("q", "a");
        assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        Question expected = javaQuestionService.add(question1);
        assertEquals(expected, question1);
    }

    @Test
    void remove() {
        assertEquals(javaQuestionService.remove(question1), question1);
    }

    @Test
    void shouldReturnAllQuestions() {
        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(3, actual.size());
        assertTrue(questions.addAll(List.of(question1, question2, question3)));
    }

    @Test
    void shouldReturnResponseStatusException() {
        JavaQuestionService test = new JavaQuestionService();
        assertThrows(ResponseStatusException.class, test::getRandomQuestion);
    }
}
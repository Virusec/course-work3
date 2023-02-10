package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplWithMockTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl out;
    private final Set<Question> actual = new HashSet<>();
    Question question1 = new Question("q1", "a1");

    @Test
    public void getQuestions() {
        actual.add(question1);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(question1);
        Mockito.when(questionService.getAll()).thenReturn(actual);
        Assertions.assertEquals(out.getQuestions(1), actual);
    }

    @Test
    public void shouldReturnResponseStatusException() {
        Assertions.assertThrows(ResponseStatusException.class, () -> out.getQuestions(3));
    }
}

package com.example.coursework3.conroller;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(new Question(question, answer));
    }

    @GetMapping("remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }
}

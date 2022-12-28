package ru.skypro.examgenerator.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.skypro.examgenerator.entity.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    void init() {
        questions.add(new Question("math1","math 1"));
        questions.add(new Question("math2","math 2"));
        questions.add(new Question("math3","math 3"));
        questions.add(new Question("math4","math 4"));
    }

    public MathQuestionRepository() {
        init();
    }

    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    public Collection<Question> getAll() {
        return questions;
    }
}

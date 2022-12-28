package ru.skypro.examgenerator.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.skypro.examgenerator.entity.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    void init() {

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

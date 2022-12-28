package ru.skypro.examgenerator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.entity.Question;
import ru.skypro.examgenerator.repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
@Qualifier("JavaQuestionService")
@RequiredArgsConstructor
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository javaQuestionRepository;

    @Override
    public Question add(String question, String answer) {
        Question ent = new Question(question,answer);
        return add(ent);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    private final Random random = new Random();

    @Override
    public Question getRandomQuestion() {

        var questions = javaQuestionRepository.getAll();
        int id = random.nextInt(questions.size());
        var iter = questions.iterator();
        int i = 0;
        for(var obj : questions){
            if (i == id)
                return obj;
            i++;
        }
        return null;
    }
}

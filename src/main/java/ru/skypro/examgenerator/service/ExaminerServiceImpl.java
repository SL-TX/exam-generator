package ru.skypro.examgenerator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.examgenerator.entity.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    @Override
    public Collection<Question> getQuestions(int amount) {
        var result = new ArrayList<Question>();
        int i = 0;
        while (result.size() < amount){
            var question = questionService.getRandomQuestion();
            if (i<=5 && !result.contains(question)) {
                result.add(question);
                i=0;
            } else {
                throw new ResponseStatusException(BAD_REQUEST,"Bad request");
            }
            i++;
        }
        return result;
    }
}

package com.company.Controllers;

import com.company.Classes.Сalculator;
import com.company.DAO.AnswerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class FirstController {

    private final AnswerDAO answerDAO;

    @Autowired
    public FirstController(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    @GetMapping("/{string}")
    public String decision(@PathVariable("string") String task, Model model){
        model.addAttribute("task", task);
        int answer = Сalculator.getResult(task);
        model.addAttribute("answer", answer);
        answerDAO.addResult(task, answer);
        return "answer";
    }
}

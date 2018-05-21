package com.sathish.charlotte;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnvironmentController {

    private final EnvironmentRepository repository;

    public EnvironmentController(EnvironmentRepository repository)
    {
        this.repository=repository;

    }

    @GetMapping("/add")
    public String add()
    {
        return "addForm";
    }

    @PostMapping("/addEnv")
    public String add(@ModelAttribute Environment environment, Model model)
    {
        System.out.println("Method /addEnv has called at .."+new java.util.Date().getTime());

        try {
            repository.save(environment);
        } catch (Exception | Error e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "entryPage";
        }
        ;
        return list(model);
    }

    @GetMapping("/list")
    public String  list(Model model)
    {
        try {
            System.out.println("##########################################Method /List has called at .."+new java.util.Date().getTime()+"##########################################");
            model.addAttribute("environment",repository.findAll());
        } catch (Exception | Error e) {
            model.addAttribute("errorMessage", e.getMessage());
//            return "listError";
        }
        return "resultsPage";
    }

}

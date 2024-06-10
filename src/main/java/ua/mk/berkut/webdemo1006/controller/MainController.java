package ua.mk.berkut.webdemo1006.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.mk.berkut.webdemo1006.model.Student;
import ua.mk.berkut.webdemo1006.service.StudentService;

@Controller
@AllArgsConstructor
public class MainController {

    private StudentService studentService;

    @GetMapping("/hello/{color}/{user}")
    public String hello(@PathVariable String user, @PathVariable String color, Model model){
        model.addAttribute("user", user);
        model.addAttribute("color", color);
        return "hello";
    }

    @PostMapping("/hello")
    public String postHello(@RequestParam(name = "user") String user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("color", "red");
        return "hello";
    }

    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @PostMapping("/addstudent")
    public String addStudent(@RequestParam String name, @RequestParam int age) {
        studentService.add(new Student(name, age));
        return "redirect:/students";
    }
}



package com.geekbrains.controllers;

import javax.servlet.http.HttpServletRequest;
import com.geekbrains.entities.Student;
import com.geekbrains.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentsController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService){this.studentService=studentService;}

    // http://localhost:8085/app/students/showForm
    @RequestMapping("/showForm")
    public String showSimpleForm(Model model){
        Student student=new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    // http://localhost:8085/app/students/processForm
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println(student.getFirstName() + " " + student.getLastName());
        return "student-form-result";
    }

    // http://localhost:8085/app/students/showStudentById?id=5
    @RequestMapping(path="/showStudentById", method=RequestMethod.GET)
    public String showStudentById(Model model, @RequestParam Long id) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-form-result";
    }

    // http://localhost:8085/app/students/getStudentById?id=20
    @RequestMapping(path="/getStudentById", method=RequestMethod.GET)
    @ResponseBody
    public Student getStudentById(@RequestParam Long id) {
        Student student = studentService.getStudentById(id);
        return student;
    }

    // http://localhost:8085/app/students/getStudentById/10
    @RequestMapping(path="/getStudentById/{sid}", method=RequestMethod.GET)
    @ResponseBody
    public Student getStudentByIdFromPath(@PathVariable("sid") Long id) {
        Student student = studentService.getStudentById(id);
        return student;
        }
}


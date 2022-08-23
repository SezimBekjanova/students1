package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;
import kg.megacom.students1.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/add")
    public  Object createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }

}

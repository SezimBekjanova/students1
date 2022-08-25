package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;
import kg.megacom.students1.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/update")
    public Student updateStudent(@RequestParam Long id, @RequestParam String title){
        return studentService.update(id, title);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        studentService.delete(id);
    }
    @GetMapping("/findAllNotDeleted")
    public List<Student> findAllNotDeleted(){
        return studentService.findAllNotDelete();
    }
}

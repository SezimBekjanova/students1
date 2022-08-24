package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDto;
import kg.megacom.students1.services.TeacherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/add")
    public  Object createTeacher(@RequestBody TeacherDto teacherDto){
        return teacherService.createTeacher(teacherDto);
    }
    @PutMapping("/update")
    public Teacher updateTeacher(@RequestParam Long id, @RequestParam String name){
        return teacherService.update(id, name);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        teacherService.delete(id);
    }


}

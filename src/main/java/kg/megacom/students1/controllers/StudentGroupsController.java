package kg.megacom.students1.controllers;

import kg.megacom.students1.models.StudentGroups;
import kg.megacom.students1.services.StudentGroupsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentGroups")
public class StudentGroupsController {
    private final StudentGroupsService studentGroupsService;

    public StudentGroupsController(StudentGroupsService studentGroupsService) {
        this.studentGroupsService = studentGroupsService;
    }
    @PostMapping("/add")
    public  Object createStudentGroups(@RequestBody StudentGroups studentGroups){
        return  studentGroupsService.createStudentGroups(studentGroups);
    }
}

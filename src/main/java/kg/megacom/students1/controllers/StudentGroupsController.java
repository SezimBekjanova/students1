package kg.megacom.students1.controllers;

import kg.megacom.students1.models.StudentGroups;
import kg.megacom.students1.models.dto.StudentGroupsDto;
import kg.megacom.students1.services.StudentGroupsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/studentGroups")
public class StudentGroupsController {
    private final StudentGroupsService studentGroupsService;

    public StudentGroupsController(StudentGroupsService studentGroupsService) {
        this.studentGroupsService = studentGroupsService;
    }
    @PostMapping("/add")
    public  Object createStudentGroups(@RequestBody StudentGroupsDto studentGroupsDto){
        return  studentGroupsService.createStudentGroups(studentGroupsDto);
    }
    @PutMapping("/update")
    public StudentGroups update(@RequestParam Long id, @RequestParam Date end_date){
        return studentGroupsService.update(id,end_date);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        studentGroupsService.delete(id);
    }
    @PostMapping("/v2/add")
    public  Object createStudentGroupsV2
            (@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate, @RequestParam  @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate, @RequestParam Long studentId, @RequestParam Long groupId){
        return  studentGroupsService.createStudentGroupsV2(endDate,startDate,studentId,groupId);
    }
}

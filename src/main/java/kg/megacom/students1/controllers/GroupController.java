package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.repositiries.GroupRepo;
import kg.megacom.students1.services.GroupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;
    private final GroupRepo groupRepo;

    public GroupController(GroupService groupService, GroupRepo groupRepo) {
        this.groupService = groupService;
        this.groupRepo = groupRepo;
    }
    @PostMapping("/add")
    public Object create(@RequestBody GroupDto groupDto){
        return groupService.createGroup(groupDto);
    }
    @DeleteMapping("/delete")
    public  void delete(@RequestParam Long id){
        groupService.delete(id);
    }
    @PutMapping("/update")
    public Group update(@RequestParam Long id, @RequestParam String name){
        return groupService.update(id,name);
    }

}

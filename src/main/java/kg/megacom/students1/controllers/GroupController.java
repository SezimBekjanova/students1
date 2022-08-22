package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.services.GroupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    @PostMapping("/add")
    public Object create(@RequestBody Group group){
        return groupService.createGroup(group);
    }
}

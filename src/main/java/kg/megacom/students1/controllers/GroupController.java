package kg.megacom.students1.controllers;

import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.repositiries.GroupRepo;
import kg.megacom.students1.services.GroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

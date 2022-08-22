package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.repositiries.GroupRepo;
import kg.megacom.students1.models.repositiries.StudentRepo;
import kg.megacom.students1.services.GroupService;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;

    public  GroupServiceImpl(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }
    @Override
    public Group createGroup(Group group) {
            return groupRepo.save(group);
    }
}

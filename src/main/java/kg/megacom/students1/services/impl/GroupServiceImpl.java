package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.repositiries.GroupRepo;
import kg.megacom.students1.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;
    private final GroupMapper groupMapper;
    public  GroupServiceImpl(GroupRepo groupRepo, GroupMapper groupMapper) {
        this.groupRepo = groupRepo;
        this.groupMapper = groupMapper;
    }
    @Override
    public Group createGroup(GroupDto groupDto) {

        Group group = groupMapper.toEntity(groupDto);
        groupRepo.save(group);
            return group;
    }
    @Override
    public List<GroupDto> findAll() {
        List<Group> groupList = groupRepo.findAll();
        return groupMapper.toDtoList(groupList);
    }
}
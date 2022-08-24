package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.GroupDto;

import java.util.List;

public interface GroupService {
    Group createGroup(GroupDto groupDto);
    List<GroupDto> findAll();
    Group update(Long id, String name);
    void delete(Long id);
}

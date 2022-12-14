package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.models.requests.GroupRequest;

import java.util.List;

public interface GroupService {
    Group createGroup(GroupDto groupDto);
    List<GroupDto> findAll();
    Group update(Long id, String name);
    void delete(Long id);
    Group createV2(GroupRequest groupRequest);

}

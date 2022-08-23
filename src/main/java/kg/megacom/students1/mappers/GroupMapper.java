package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.models.dto.StudentDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GroupMapper {
    private final ModelMapper modelMapper;
    public Group toEntity(GroupDto groupDto){ // дто в ентити
        return Objects.isNull(groupDto) ? null : modelMapper.map(groupDto,  Group.class);
    }
    public GroupDto toDto(Group group){ // ентити в дто
        return  Objects.isNull(group) ? null : modelMapper.map(group, GroupDto.class);
    }
    public List<GroupDto> toDtoList(List<Group> groupList){
        return groupList.stream().map(group -> modelMapper.map(group, GroupDto.class))
                .collect(Collectors.toList());
    }
}

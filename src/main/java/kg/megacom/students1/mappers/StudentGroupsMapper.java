package kg.megacom.students1.mappers;

import kg.megacom.students1.models.StudentGroups;
import kg.megacom.students1.models.dto.StudentGroupsDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class StudentGroupsMapper {
    private  final ModelMapper modelMapper;
    public StudentGroups toEntity(StudentGroupsDto studentGroupsDto){
        return Objects.isNull(studentGroupsDto) ? null : modelMapper.map(studentGroupsDto, StudentGroups.class);
    }
    public StudentGroupsDto toDto(StudentGroups studentGroups){
        return Objects.isNull(studentGroups) ? null : modelMapper.map(studentGroups, StudentGroupsDto.class);
    }
    public List<StudentGroupsDto> toDtoList(List<StudentGroups> studentGroupsList){
        return studentGroupsList.stream().map(studentGroups -> modelMapper.map(studentGroups, StudentGroupsDto.class))
                .collect(Collectors.toList());
    }

}
